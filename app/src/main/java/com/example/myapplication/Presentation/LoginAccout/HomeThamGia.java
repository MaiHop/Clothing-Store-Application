package com.example.myapplication.Presentation.LoginAccout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Presentation.LoginAccout.SignIn.sign_in;
import com.example.myapplication.Presentation.LoginAccout.SingUp.sign_up;
import com.example.myapplication.R;

public class HomeThamGia extends AppCompatActivity {
    Button btnSignIn, btnSignUP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tham_gia);

        btnSignIn = findViewById(R.id.btn_SignInThamGia);
        btnSignUP = findViewById(R.id.btn_SignUpThamGia);

        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeThamGia.this, sign_up.class);
                startActivity(intent);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeThamGia.this, sign_in.class);
                startActivity(intent);
            }
        });
    }
}