package com.example.myapplication.Presentation.Onboarding.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TINER = 5000;
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
                Intent intent = new Intent(SplashScreen.this, OnBoarding.class);
                startActivity(intent);
                finish();
            }
            else {
                Intent intent = new Intent(SplashScreen.this, HomeThamGia.class);
                startActivity(intent);
                finish();
            }


        },SPLASH_TINER);
    }
}