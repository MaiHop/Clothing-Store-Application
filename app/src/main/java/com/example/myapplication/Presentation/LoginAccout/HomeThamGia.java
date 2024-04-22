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
    Class<?> sign_up = sign_up.class,
            sign_in = sign_in.class;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tham_gia);

        btnSignIn = findViewById(R.id.btn_SignInThamGia);
        btnSignUP = findViewById(R.id.btn_SignUpThamGia);

        Onclickbtn(btnSignIn, sign_in);
        Onclickbtn(btnSignUP,sign_up);
    }
    public void Onclickbtn(Button btn, Class<?> class_activity){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeThamGia.this,class_activity);
                intent.putExtra("confirm_code", "sign_up");
                startActivity(intent);
            }
        });
    }
}