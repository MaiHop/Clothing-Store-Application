package com.example.myapplication.Presentation.LoginAccout.SignIn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Presentation.LoginAccout.ForgotPass.forgot_password;
import com.example.myapplication.R;

public class sign_in extends AppCompatActivity {
    ImageView imagePack;
    TextView tv_forgotPW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        imagePack = findViewById(R.id.pack_signin);
        tv_forgotPW = findViewById(R.id.tv_forgotPW);
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
    }
}