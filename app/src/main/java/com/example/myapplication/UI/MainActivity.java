package com.example.myapplication.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Api.KhachHang_api;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Model2.KhachHang;
import com.example.myapplication.Presentation.ButtonNavigation.Home;
import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.Presentation.LoginAccout.SingUp.sign_up;
import com.example.myapplication.Presentation.Onboarding.Activity.OnBoarding;
import com.example.myapplication.R;
import com.example.myapplication.Repository.KhachHangRepository;
import com.example.myapplication.SharedPreferences.DataLocalManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements KhachHangRepository.KhachHangInterface {
    private FirebaseAuth mAuth;
    private static final int SPLASH_TIMER = 3000; // 3 seconds
    KhachHangRepository khachHangRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_splash_screen); // Use your actual layout

        mAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(() -> {
            if (!DataLocalManager.getFirstInstall()) {
                Intent intent = new Intent(MainActivity.this, OnBoarding.class);
                startActivity(intent);
                DataLocalManager.setFirstInstall(true);
            } else {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser != null) {
//                    fetchKhachHangData(currentUser.getUid());
                    khachHangRepository = new KhachHangRepository(MainActivity.this);
                    khachHangRepository.getKhachHang(currentUser.getUid());
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(MainActivity.this, HomeThamGia.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_TIMER);
    }

    @Override
    public void onKhachHangCreated(KhachHang khachHang) {
        if (khachHang != null) {
            // Lưu thông tin vào SharedPreferences
            DataLocalManager.setUser(khachHang);

            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
            finish();
        } else {
            Log.e("SignInActivity", "KhachHang is null");
            Toast.makeText(this, "Failed to fetch KhachHang", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onKhachHangUpdated(KhachHang khachHang) {

    }

    @Override
    public void onAllKhachHangRead(List<KhachHang> khachHangList) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onKhachHangReceived(KhachHang body) {

    }
}