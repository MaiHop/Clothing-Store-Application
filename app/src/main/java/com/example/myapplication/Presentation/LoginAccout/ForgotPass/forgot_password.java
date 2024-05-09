package com.example.myapplication.Presentation.LoginAccout.ForgotPass;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Presentation.LoginAccout.Load_Dialog;
import com.example.myapplication.Presentation.LoginAccout.OTP.SP_OTP;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_password extends AppCompatActivity {
    TextInputEditText txtip_email_forgot;
    ImageView pack_forgot;
    Button btn_sendcode;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    String Email;
    Load_Dialog loadDialog = new Load_Dialog(forgot_password.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_forgot_password);

        initUI();
        Onclickbtn();

    }
    private void initUI(){
        txtip_email_forgot = findViewById(R.id.txtip_email_forgot);
        pack_forgot = findViewById(R.id.pack_forgot);
        btn_sendcode = findViewById(R.id.btn_sendOTP);
    }
    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }
    public void Onclickbtn(){
        pack_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_sendcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Email = txtip_email_forgot.getText().toString().trim();
                if (!TextUtils.isEmpty(Email)){
                    if(isValidEmail(Email)){
                        ResetPassWord();
                    }
                    else {
                        txtip_email_forgot.setError("Email sai định dạng !!!");
                    }
                }else {
                    txtip_email_forgot.setError("Mời bạn điền Email để bắt đầu đặt lại Password");
                }
            }
        });
    }
    private void ResetPassWord(){
        mAuth.sendPasswordResetEmail(Email)
            .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                loadDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadDialog.dismissDialog();

                        Intent intent = new Intent(forgot_password.this,SP_OTP.class);
                        intent.putExtra("confirm_code", "forgot_password");
                        Toast.makeText(forgot_password.this,"Mời bạn xác thực bên email của bạn",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                },2000);
            }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(forgot_password.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });

    }

}