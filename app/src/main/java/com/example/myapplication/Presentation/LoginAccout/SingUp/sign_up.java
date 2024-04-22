package com.example.myapplication.Presentation.LoginAccout.SingUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Presentation.LoginAccout.ForgotPass.forgot_password;
import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.Presentation.LoginAccout.OTP.SP_OTP;
import com.example.myapplication.Presentation.LoginAccout.SignIn.logout;
import com.example.myapplication.Presentation.LoginAccout.SignIn.sign_in;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class sign_up extends AppCompatActivity {
    ImageView imagePack;
    TextView tv_sigin;
    Button btn_SignUp;
    Class<?> SP_OTP = SP_OTP.class,
            Home_ThamGia = HomeThamGia.class,
            Sign_in= sign_in.class ;
    TextInputEditText txtip_email, txtip_password;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initUI();

        Onclickbtn(btn_SignUp,SP_OTP);
        OnclickImage(imagePack,Home_ThamGia);
        OnclickText(tv_sigin,Sign_in);
    }
    private void initUI(){
        imagePack=findViewById(R.id.pack_signup);
        tv_sigin = findViewById(R.id.tv_sigin);
        btn_SignUp = findViewById(R.id.btn_SignUp);
        txtip_email = findViewById(R.id.txtip_email);
        txtip_password = findViewById(R.id.txtip_password);
    }
    public void Onclickbtn(Button btn, Class<?> class_activity){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtip_email.getText().toString();
                String password = txtip_password.getText().toString();
                if (email.equals("") || password.equals("")){
                    Toast.makeText(sign_up.this,"Không được để trống email hoặc password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<6){
                    Toast.makeText(sign_up.this,"Password không được dưới 6 ký tự",Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if(task.isSuccessful()){
                            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    String profileURL = "abc.jpg";
                                    if (task.isSuccessful()){
                                        HashMap<String, Object> map = new HashMap<>();
                                        map.put("id",user.getUid());
                                        map.put("name",user.getEmail());
                                        map.put("profile",profileURL);

                                        database.getReference().child("users").child(user.getUid()).setValue(map)
                                                .addOnSuccessListener(aVoid -> {
                                                    Intent intent = new Intent(sign_up.this,class_activity);
                                                    intent.putExtra("confirm_code", "sign_up");
                                                    intent.putExtra("Email", email);
                                                    intent.putExtra("Password",password);
                                                    Toast.makeText(sign_up.this,"Mời bạn xác thực bên email của bạn",Toast.LENGTH_SHORT).show();
                                                    startActivity(intent);
                                                })
                                                .addOnFailureListener(e -> {
                                                    Log.e("Firebase", "Failed to write user to database", e);
                                                });
//                                        Intent intent = new Intent(sign_up.this,class_activity);
//                                        intent.putExtra("confirm_code", "sign_up");
//                                        intent.putExtra("Email", email);
//                                        intent.putExtra("Password",password);
//                                        Toast.makeText(sign_up.this,"Mời bạn xác thực bên email của bạn",Toast.LENGTH_SHORT).show();
//                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(sign_up.this,"Hệ thống đang lỗi không thể nào gửi link xác nhận cho bạn.",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                        else {
                            Toast.makeText(sign_up.this,"Email này đã tồn tại",Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
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

}