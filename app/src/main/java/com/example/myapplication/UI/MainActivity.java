package com.example.myapplication.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication.Presentation.ButtonNavigation.Home;
import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.Presentation.Onboarding.Activity.OnBoarding;
import com.example.myapplication.Presentation.Onboarding.Activity.SplashScreen;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TINER = 3000;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_splash_screen);

        new Handler().postDelayed(() ->{
            onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
            boolean isFirstTime = onBoardingScreen.getBoolean("firsTime",true);

            if(isFirstTime){

                SharedPreferences.Editor editor = onBoardingScreen.edit();
                editor.putBoolean("firsTime",false);
                editor.commit();
                Intent intent = new Intent(MainActivity.this, OnBoarding.class);
                startActivity(intent);
                finish();
            }
            else {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if(currentUser !=null){
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, HomeThamGia.class);
                    startActivity(intent);
                    finish();
                }

            }


        },SPLASH_TINER);
    }
}