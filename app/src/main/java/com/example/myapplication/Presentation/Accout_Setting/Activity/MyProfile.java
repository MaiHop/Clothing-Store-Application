package com.example.myapplication.Presentation.Accout_Setting.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class MyProfile extends AppCompatActivity {
    ImageView img_Avata;
    TextView txtip_fullname,txtip_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_my_profile);
        init();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        Picasso.get().load(mUser.getPhotoUrl().toString()).into(img_Avata);
        txtip_fullname.setText(mUser.getDisplayName());
        txtip_email.setText(mUser.getEmail());
    }
    private void init(){
        img_Avata = findViewById(R.id.img_Avata);
        txtip_fullname = findViewById(R.id.txtip_fullname);
        txtip_email = findViewById(R.id.txtip_email);
    }
}