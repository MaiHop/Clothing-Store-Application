package com.example.myapplication.Presentation.LoginAccout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Presentation.LoginAccout.SignIn.logout;
import com.example.myapplication.Presentation.LoginAccout.SignIn.sign_in;
import com.example.myapplication.Presentation.LoginAccout.SingUp.sign_up;
import com.example.myapplication.R;
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

import java.util.HashMap;

public class HomeThamGia extends AppCompatActivity {
    Button btnSignIn, btnSignUP,btn_signIn_GG;
    Class<?> sign_up = sign_up.class,
            sign_in = sign_in.class;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    GoogleSignInClient mGoogleSignInClinet;
    int RC_SignIn = 1234;
    Load_Dialog loadDialog = new Load_Dialog(HomeThamGia.this);

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
                                            HashMap<String, Object> map = new HashMap<>();
                                            map.put("id",user.getUid());
                                            map.put("name",user.getDisplayName());
                                            map.put("profile",user.getPhotoUrl().toString());
                                            database.getReference().child("users").child(user.getUid()).setValue(map)
                                                    .addOnSuccessListener(aVoid -> {
                                                        Intent intent = new Intent(HomeThamGia.this, logout.class);
                                                        startActivity(intent);
                                                    })
                                                    .addOnFailureListener(e -> {
                                                        Log.e("Firebase", "Failed to write user to database", e);
                                                    });
                                        }
                                    },2000);

                                }
                                else {
                                    Toast.makeText(HomeThamGia.this,"Loi",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }catch (Exception e){
                Toast.makeText(HomeThamGia.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(HomeThamGia.this,"Lỗi hệ thống, xin quý khách đợi hệ thống được Cập Nhật !!!",Toast.LENGTH_SHORT).show();

        }
    }
}