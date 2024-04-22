package com.example.myapplication.Presentation.LoginAccout.SignIn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.R;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class logout extends AppCompatActivity {
    TextView tv_email_id;
    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        initUI();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        tv_email_id.setText(mUser.getEmail());
        btnLogout(btn_logout);
    }
    private void initUI(){
        tv_email_id = findViewById(R.id.tv_email_id);
        btn_logout = findViewById(R.id.btn_logout);
    }
    private void btnLogout(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(logout.this, HomeThamGia.class);
                startActivity(intent);
            }
        });
    }

}