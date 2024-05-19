package com.example.myapplication.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Api.KhachHang_api;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Model2.KhachHang;
import com.example.myapplication.Presentation.ButtonNavigation.Home;
import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.Presentation.Onboarding.Activity.OnBoarding;
import com.example.myapplication.R;
import com.example.myapplication.SharedPreferences.DataLocalManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final int SPLASH_TIMER = 3000; // 3 seconds

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
                    fetchKhachHangData(currentUser.getUid());
                } else {
                    Intent intent = new Intent(MainActivity.this, HomeThamGia.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_TIMER);
    }

    private void fetchKhachHangData(String userId) {
        KhachHang_api khachHangApi = ServiceBuilder.buildService(KhachHang_api.class);
        Call<KhachHang> request = khachHangApi.findKhachHangbyUID(userId);

        request.enqueue(new Callback<KhachHang>() {
            @Override
            public void onResponse(Call<KhachHang> call, Response<KhachHang> response) {
                if (response.isSuccessful() && response.body() != null) {
                    KhachHang khachHang = response.body();

                    // Lưu thông tin vào SharedPreferences
                    DataLocalManager.setUser(khachHang);

                    Intent intent = new Intent(MainActivity.this, Home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to retrieve user data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<KhachHang> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error fetching user data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}