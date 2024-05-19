package com.example.myapplication.Presentation.LoginAccout.SignIn;

import android.content.Intent;
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

import com.example.myapplication.Model.KhachHang;
import com.example.myapplication.Presentation.ButtonNavigation.Home;
import com.example.myapplication.Presentation.LoginAccout.ForgotPass.forgot_password;
import com.example.myapplication.Presentation.LoginAccout.Load_Dialog;
import com.example.myapplication.R;
import com.example.myapplication.SharedPreferences.DataLocalManager;
import com.example.myapplication.UI.MainActivity;
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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;

public class sign_in extends AppCompatActivity {
    ImageView imagePack;
    TextView tv_forgotPW, tv_error;
    Button btn_signIn,
            btn_signIn_GG;
    TextInputEditText txtip_email,txtip_password;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseFirestore database = FirebaseFirestore.getInstance();


    GoogleSignInClient mGoogleSignInClinet;
    int RC_SignIn = 1234;
    Load_Dialog loadDialog = new Load_Dialog(sign_in.this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_sign_in);

        GGOption();

        initUI();
        btn();
        logout();
    }
    private void initUI(){
        imagePack = findViewById(R.id.pack_signin);
        tv_forgotPW = findViewById(R.id.tv_forgotPW);
        btn_signIn = findViewById(R.id.btn_SignIn);
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
                        btn();
                    }
                });
    }
    private void btn(){
        imagePack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_forgotPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sign_in.this, forgot_password.class);
                startActivity(intent);
            }
        });
        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
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

    private void SignIn(){
        String email = txtip_email.getText().toString();
        String password = txtip_password.getText().toString();
        final Load_Dialog loadDialog = new Load_Dialog(sign_in.this);
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
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    if(mAuth.getCurrentUser().isEmailVerified()){
                        loadDialog.startLoadingDialog();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                loadDialog.dismissDialog();
//                                        Intent intent = new Intent(sign_in.this, Home.class);
//                                        startActivity(intent);
                                DocumentReference docRef = database.collection("KhachHang").document(mAuth.getCurrentUser().getUid());
                                docRef.get().addOnSuccessListener(documentSnapshot -> {
                                            if (documentSnapshot.exists()) {

                                                KhachHang khachHangsave = documentSnapshot.toObject(KhachHang.class);

                                                // Lưu thông tin vào SharedPreferences
                                                DataLocalManager.setUser(khachHangsave);

                                                Intent intent = new Intent(sign_in.this, Home.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        })
                                        .addOnFailureListener(e -> {
                                            Log.e("Firebase", "Failed to write user to database", e);
                                        });
                            }
                        },1000);
                    }
                    else {
                        loadDialog.startLoadingDialog();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                loadDialog.dismissDialog();
                                tv_error.setText("Hãy xác nhận Email của bạn trước khi đăng nhập!");
                                tv_error.setVisibility(View.VISIBLE);
                            }
                        },1000);
                    }
                }
                else {
                    loadDialog.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadDialog.dismissDialog();
                            tv_error.setText("Email hoặc Password không đúng");
                            tv_error.setVisibility(View.VISIBLE);
                        }
                    },1000);

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
                                    KhachHang khachHang = new KhachHang();
                                    khachHang.setIdKhachHang(user.getUid());
                                    khachHang.setEmail(user.getEmail());
                                    khachHang.setTen(user.getDisplayName());
                                    khachHang.setImageUrl(user.getPhotoUrl().toString());
                                    khachHang.setGioiTinh(0);
                                    DocumentReference docRef = database.collection("KhachHang").document(khachHang.getIdKhachHang());
                                    docRef.get().addOnSuccessListener(documentSnapshot -> {
                                                if (documentSnapshot.exists()) {

                                                    KhachHang khachHangsave = documentSnapshot.toObject(KhachHang.class);

                                                    // Lưu thông tin vào SharedPreferences
                                                    DataLocalManager.setUser(khachHangsave);

                                                    Intent intent = new Intent(sign_in.this, Home.class);
                                                    startActivity(intent);
                                                }
                                            })
                                            .addOnFailureListener(e -> {
                                                Log.e("Firebase", "Failed to write user to database", e);
                                            });
                                }
                            },2000);

                        }
                        else {
                            tv_error.setText("Lỗi hệ thống, xin quý khách đợi hệ thống được Cập Nhật !!!");
                            tv_error.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }catch (Exception e){
                Toast.makeText(sign_in.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        else {
            tv_error.setText("Lỗi hệ thống, xin quý khách đợi hệ thống được Cập Nhật !!!");
            tv_error.setVisibility(View.VISIBLE);
        }
    }
}