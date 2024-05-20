package com.example.myapplication.Presentation.LoginAccout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Model2.KhachHang;
import com.example.myapplication.Presentation.ButtonNavigation.Home;
import com.example.myapplication.Presentation.LoginAccout.SignIn.sign_in;
import com.example.myapplication.Presentation.LoginAccout.SingUp.sign_up;
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
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.List;

public class HomeThamGia extends AppCompatActivity implements KhachHangRepository.KhachHangInterface{
    Button btnSignIn, btnSignUP,btn_signIn_GG,btn_AP,btn_FB;
    TextView tv_error;
    Class<?> sign_up = sign_up.class,
            sign_in = sign_in.class;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseFirestore database = FirebaseFirestore.getInstance();

    GoogleSignInClient mGoogleSignInClinet;
    int RC_SignIn = 1234;
    Load_Dialog loadDialog = new Load_Dialog(HomeThamGia.this);
    TextView tv_loading;

    KhachHangRepository khachHangRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_home_tham_gia);

        GGOption();
        initUI();
        Onclickbtn();
        logout();
    }
    private void initUI(){
        btnSignIn = findViewById(R.id.btn_SignInThamGia);
        btnSignUP = findViewById(R.id.btn_SignUpThamGia);
        btn_signIn_GG = findViewById(R.id.btn_GG);
        tv_error = findViewById(R.id.tv_error);
        btn_AP = findViewById(R.id.btn_AP);
        btn_FB = findViewById(R.id.btn_FB);
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
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeThamGia.this, sign_in);
                startActivity(intent);
            }
        });
        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeThamGia.this, sign_up);
                startActivity(intent);
            }
        });
        btn_signIn_GG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = mGoogleSignInClinet.getSignInIntent();
                startActivityForResult(intent,RC_SignIn);
            }
        });
        btn_AP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_error.setText("Hệ thống chưa được hổ trợ");
                tv_error.setVisibility(View.VISIBLE);
            }
        });
        btn_FB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_error.setText("Hệ thống chưa được hổ trợ");
                tv_error.setVisibility(View.VISIBLE);
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
                                            khachHangRepository = new KhachHangRepository(HomeThamGia.this);
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
                                                            Intent intent = new Intent(HomeThamGia.this, Home.class);
                                                            startActivity(intent);
                                                        })
                                                        .addOnFailureListener(e -> {
                                                            Log.e("Firebase", "Failed to write user to database", e);
                                                        });
                                            }catch (Exception e){
                                                Log.e("Firebase", "Failed to write user to database", e);
                                            }
//                                            database.collection("KhachHang").document(khachHang.getIdKhachHang())
//                                                    .set(khachHang)
//                                                    .addOnSuccessListener(aVoid -> {
//                                                        Intent intent = new Intent(HomeThamGia.this, Home.class);
////                                                        startActivity(intent);
//                                                    })
//                                                    .addOnFailureListener(e -> {
//                                                        Log.e("Firebase", "Failed to write user to database", e);
//                                                    });
                                        }
                                    },7000);

                                }
                                else {
                                    tv_error.setText("Lỗi hệ thống, xin quý khách đợi hệ thống được Cập Nhật !!!");
                                    tv_error.setVisibility(View.VISIBLE);
                                }
                            }
                        });
            }catch (Exception e){
                tv_error.setText("Lỗi hệ thống, xin quý khách đợi hệ thống được Cập Nhật !!!");
                tv_error.setVisibility(View.VISIBLE);
            }
        }
        else {
            tv_error.setText("Lỗi hệ thống, xin quý khách đợi hệ thống được Cập Nhật !!!");
            tv_error.setVisibility(View.VISIBLE);
        }
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