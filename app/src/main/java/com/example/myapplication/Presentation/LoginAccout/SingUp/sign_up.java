package com.example.myapplication.Presentation.LoginAccout.SingUp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Model2.KhachHang;
import com.example.myapplication.Presentation.ButtonNavigation.Home;
import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.Presentation.LoginAccout.Load_Dialog;
import com.example.myapplication.Presentation.LoginAccout.OTP.SP_OTP;
import com.example.myapplication.Presentation.LoginAccout.SignIn.sign_in;
import com.example.myapplication.R;
import com.example.myapplication.Repository.KhachHangRepository;
import com.example.myapplication.SharedPreferences.DataLocalManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class sign_up extends AppCompatActivity implements KhachHangRepository.KhachHangInterface{
    ImageView imagePack;
    TextView tv_sigin,tv_error;
    Button btn_SignUp,btn_signIn_GG;
    Class<?> SP_OTP = SP_OTP.class,
            Home_ThamGia = HomeThamGia.class,
            Sign_in= sign_in.class ;
    TextInputEditText txtip_email, txtip_password;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
//    FirebaseDatabase database = FirebaseDatabase.getInstance();

    FirebaseFirestore database = FirebaseFirestore.getInstance();

    GoogleSignInClient mGoogleSignInClinet;
    int RC_SignIn = 1234;
    Load_Dialog loadDialog = new Load_Dialog(sign_up.this);
    KhachHangRepository khachHangRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_sign_up);

        GGOption();
        initUI();

        Onclickbtn();
        OnclickImage(imagePack,Home_ThamGia);
        OnclickText(tv_sigin,Sign_in);
        logout();

    }
    private void initUI(){
        imagePack=findViewById(R.id.pack_signup);
        tv_sigin = findViewById(R.id.tv_sigin);
        btn_SignUp = findViewById(R.id.btn_SignUp);
        btn_signIn_GG = findViewById(R.id.btn_GG);
        txtip_email = findViewById(R.id.txtip_email);
        txtip_password = findViewById(R.id.txtip_password);
        tv_error = findViewById(R.id.tv_error);
    }
    private void GGOption(){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();
        mGoogleSignInClinet = GoogleSignIn.getClient(this,gso);
    }
    private void logout(){
        mGoogleSignInClinet.signOut().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Now the user will be able to select an account to sign in
                        Onclickbtn();
                    }
                });
    }
    public void Onclickbtn(){
        btn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUP();
            }
        });
        btn_signIn_GG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = mGoogleSignInClinet.getSignInIntent();
                startActivityForResult(intent,RC_SignIn);
            }
        });
    }
    private void SignUP(){
        String email = txtip_email.getText().toString();
        String password = txtip_password.getText().toString();
        if (email.equals("") || password.equals("")){
            tv_error.setText("Không được để trống email hoặc password");
            tv_error.setVisibility(View.VISIBLE);
            return;
        }
        if (password.length()<6){
            tv_error.setText("Password không được dưới 6 ký tự");
            tv_error.setVisibility(View.VISIBLE);
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                // Đợi 2 giây trước khi ẩn Dialog
                                loadDialog.startLoadingDialog();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        loadDialog.dismissDialog();

                                        // Thiết lập thông tin người dùng
                                        String profileURL = "https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/android-studio-icon.png";
                                        String username = user.getEmail();
                                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                .setPhotoUri(Uri.parse(profileURL))
                                                .setDisplayName(username)
                                                .build();

                                        // Cập nhật profile của người dùng
                                        user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    // Tạo dữ liệu người dùng trên Firebase Realtime Database
                                                    khachHangRepository = new KhachHangRepository(sign_up.this);
//                                                    List<KhachHang> list = khachHangRepository.readAllKhachHang();
//                                                    int id = list.size()+4;
                                                    KhachHang khachHang = new KhachHang();
//                                                    khachHang.setIdKhachHang(id);
                                                    khachHang.setUid(user.getUid());
                                                    khachHang.setEmail(user.getEmail());
                                                    khachHang.setTen(user.getDisplayName());
                                                    khachHang.setImageUrl(user.getPhotoUrl().toString());
                                                    khachHang.setGioiTinh(0);
                                                    khachHang.setListDonHang(null);
                                                    khachHang.setListDiaChi(null);
                                                    khachHang.setListYeuThich(null);
//                                                    khachHang.setListThanhToan(null);
                                                    khachHangRepository.createKhachHang(khachHang);
                                                    try {
//                                                        KhachHang khachHangsave = documentSnapshot.toObject(KhachHang.class);
                                                        // Lưu thông tin vào SharedPreferences
//                                                        DataLocalManager.setUser(khachHang);
//                                                        Intent intent = new Intent(sign_up.this,SP_OTP);
//                                                        intent.putExtra("confirm_code", "sign_up");
//                                                        intent.putExtra("Email", email);
//                                                        intent.putExtra("Password", password);
//                                                        Toast.makeText(sign_up.this,"Mời bạn xác thực bên email của bạn",Toast.LENGTH_SHORT).show();
//                                                        startActivity(intent);

                                                        database.collection("KhachHang").document(khachHang.getUid())
                                                                .set(khachHang)
                                                                .addOnSuccessListener(aVoid -> {
                                                                    DataLocalManager.setUser(khachHang);
                                                                    Intent intent = new Intent(sign_up.this,SP_OTP);
                                                                    intent.putExtra("confirm_code", "sign_up");
                                                                    intent.putExtra("Email", email);
                                                                    intent.putExtra("Password", password);
                                                                    Toast.makeText(sign_up.this,"Mời bạn xác thực bên email của bạn",Toast.LENGTH_SHORT).show();
                                                                    startActivity(intent);
                                                                })
                                                                .addOnFailureListener(e -> {
                                                                    Log.e("Firebase", "Failed to write user to database", e);
                                                                });
                                                    }catch (Exception e){
                                                        Log.e("Firebase", "Failed to write user to database", e);
                                                    }
//                                                    DocumentReference docRef = database.collection("KhachHang").document(khachHang.getIdKhachHang());
//                                                    docRef.get().addOnSuccessListener(documentSnapshot -> {
//                                                                if (documentSnapshot.exists()) {
//
//                                                                    KhachHang khachHangsave = documentSnapshot.toObject(KhachHang.class);
//
//                                                                    // Lưu thông tin vào SharedPreferences
//                                                                    DataLocalManager.setUser(khachHangsave);
//
//                                                                    Intent intent = new Intent(sign_up.this,SP_OTP);
//                                                                    intent.putExtra("confirm_code", "sign_up");
//                                                                    intent.putExtra("Email", email);
//                                                                    intent.putExtra("Password", password);
//                                                                    Toast.makeText(sign_up.this,"Mời bạn xác thực bên email của bạn",Toast.LENGTH_SHORT).show();
//                                                                    startActivity(intent);
//                                                                }
//                                                            })
//                                                            .addOnFailureListener(e -> {
//                                                                Log.e("Firebase", "Failed to write user to database", e);
//                                                            });


                                                } else {
                                                    // Đã xảy ra lỗi khi cập nhật profile
                                                    Toast.makeText(sign_up.this, "Failed to update user profile", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }
                                }, 7000);
                            } else {
                                // Lỗi khi gửi email xác nhận
                                tv_error.setText("Hệ thống đang lỗi không thể gửi link xác nhận cho bạn.");
                                tv_error.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
                else {
                    // Đã xảy ra lỗi khi tạo tài khoản
                    tv_error.setText("Email này đã tồn tại hoặc có lỗi xảy ra khi tạo tài khoản");
                    tv_error.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SignIn){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
                mAuth.signInWithCredential(credential)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    loadDialog.startLoadingDialog();
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            loadDialog.dismissDialog();
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            khachHangRepository = new KhachHangRepository(sign_up.this);
//                                                    List<KhachHang> list = khachHangRepository.readAllKhachHang();
//                                                    int id = list.size()+4;
                                            KhachHang khachHang = new KhachHang();
//                                                    khachHang.setIdKhachHang(id);
                                            khachHang.setUid(user.getUid());
                                            khachHang.setEmail(user.getEmail());
                                            khachHang.setTen(user.getDisplayName());
                                            khachHang.setImageUrl(user.getPhotoUrl().toString());
                                            khachHang.setGioiTinh(0);
                                            khachHang.setListDonHang(null);
                                            khachHang.setListDiaChi(null);
                                            khachHang.setListYeuThich(null);
//                                                    khachHang.setListThanhToan(null);
                                            khachHangRepository.createKhachHang(khachHang);
                                            try {
//                                                        KhachHang khachHangsave = documentSnapshot.toObject(KhachHang.class);
                                                // Lưu thông tin vào SharedPreferences
                                                DataLocalManager.setUser(khachHang);
                                                Intent intent = new Intent(sign_up.this, Home.class);
                                                startActivity(intent);
                                                finish();
                                            }catch (Exception e){
                                                Log.e("Firebase", "Failed to write user to database", e);
                                            }
//                                            DocumentReference docRef = database.collection("KhachHang").document(khachHang.getIdKhachHang());
//                                            docRef.get().addOnSuccessListener(documentSnapshot -> {
//                                                        if (documentSnapshot.exists()) {
//
//                                                            KhachHang khachHangsave = documentSnapshot.toObject(KhachHang.class);
//
//                                                            // Lưu thông tin vào SharedPreferences
//                                                            DataLocalManager.setUser(khachHangsave);
//
//                                                            Intent intent = new Intent(sign_up.this, Home.class);
//                                                            startActivity(intent);
//                                                            finish();
//                                                        }
//                                                    })
//                                                    .addOnFailureListener(e -> {
//                                                        Log.e("Firebase", "Failed to write user to database", e);
//                                                    });
                                        }
                                    },2000);
                                }
                                else {
                                    Toast.makeText(sign_up.this,"Loi",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }catch (Exception e){
                Toast.makeText(sign_up.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        else {
            tv_error.setText("Lỗi hệ thống, xin quý khách đợi hệ thống được Cập Nhật !!!");
            tv_error.setVisibility(View.VISIBLE);

        }
    }
    public void OnclickImage(ImageView imgv, Class<?> class_activity){
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sign_up.this,class_activity);
                startActivity(intent);
            }
        });
    }
    public void OnclickText(TextView tv, Class<?> class_activity){
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sign_up.this,class_activity);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onKhachHangCreated(KhachHang khachHang) {

    }

    @Override
    public void onKhachHangUpdated(KhachHang khachHang) {

    }

    @Override
    public void onAllKhachHangRead(List<KhachHang> khachHangList) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onKhachHangReceived(KhachHang body) {

    }
}