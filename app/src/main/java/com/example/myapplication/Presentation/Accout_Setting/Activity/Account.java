package com.example.myapplication.Presentation.Accout_Setting.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.squareup.picasso.Picasso;

public class Account extends AppCompatActivity {
    TextView tv_nameAccount,tv_mailAccount, tv_addrress;
    LinearLayout ln_address,ln_logout;
    ImageView img_account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_acoout);

        initUI();
//        FirebaseAuth mAuth = FirebaseAuth.getInstance();
//        FirebaseUser mUser = mAuth.getCurrentUser();
//        Picasso.get().load(mUser.getPhotoUrl().toString()).into(img_account);
//        tv_nameAccount.setText(mUser.getDisplayName());
//        tv_mailAccount.setText(mUser.getEmail());
        btnLinerLayout();

    }
    private void initUI(){
        tv_nameAccount = findViewById(R.id.tv_nameAccount);
        tv_mailAccount = findViewById(R.id.tv_mailAccount);
        tv_addrress = findViewById(R.id.tv_address);
        ln_logout = findViewById(R.id.ln_logout);
        ln_address = findViewById(R.id.ln_address);
        img_account = findViewById(R.id.imgAccout);

    }
    private void btnLinerLayout(){
        ln_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Account.this, HomeThamGia.class);
                startActivity(intent);
            }
        });
        ln_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "TextView clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}