package com.example.myapplication.Presentation.LoginAccout.SingUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.Presentation.LoginAccout.SignIn.sign_in;
import com.example.myapplication.R;

public class sign_up extends AppCompatActivity {
    ImageView imagePack;
    TextView tv_sigin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        imagePack=findViewById(R.id.pack_signup);
        tv_sigin = findViewById(R.id.tv_sigin);
        imagePack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        tv_sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sign_up.this, sign_in.class);
            }
        });
    }

}