package com.example.myapplication.Presentation.LoginAccout.ForgotPass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Presentation.LoginAccout.OTP.SP_OTP;
import com.example.myapplication.Presentation.LoginAccout.SingUp.sign_up;
import com.example.myapplication.R;

public class forgot_password extends AppCompatActivity {
    Button btn_sendcode;
    Class<?> SP_OTP = SP_OTP.class;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btn_sendcode = findViewById(R.id.btn_sendOTP);
        Onclickbtn(btn_sendcode, SP_OTP);

    }
    public void Onclickbtn(Button btn, Class<?> class_activity){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forgot_password.this,class_activity);
                intent.putExtra("confirm_code", "forgot_password");
                startActivity(intent);
            }
        });
    }

}