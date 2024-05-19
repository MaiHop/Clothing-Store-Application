package com.example.myapplication.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.myapplication.Model2.KhachHang;
import com.example.myapplication.Presentation.ButtonNavigation.Home;
import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.Presentation.Onboarding.Activity.OnBoarding;
import com.example.myapplication.Presentation.Onboarding.Activity.SplashScreen;
import com.example.myapplication.R;
import com.example.myapplication.SharedPreferences.DataLocalManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TINER = 3000;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_splash_screen);

        new Handler().postDelayed(() ->{
            if(!DataLocalManager.getFirstInstall()){
                Intent intent = new Intent(MainActivity.this, OnBoarding.class);
                startActivity(intent);
                DataLocalManager.setFirstInstall(true);
            }
            else {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if(currentUser !=null){
//                    Intent intent = new Intent(MainActivity.this, Home.class);
//                    startActivity(intent);
                    DocumentReference docRef = db.collection("KhachHang").document(currentUser.getUid());
                    docRef.get().addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()) {

                            KhachHang khachHang = documentSnapshot.toObject(KhachHang.class);

                            // Lưu thông tin vào SharedPreferences
                            DataLocalManager.setUser(khachHang);

                            Intent intent = new Intent(MainActivity.this, Home.class);
                            startActivity(intent);
                            finish();
                        }
                    }).addOnFailureListener(e -> {
                        Toast.makeText(MainActivity.this, "Đã xảy ra lỗi khi truy vấn dữ liệu từ Firestore", Toast.LENGTH_SHORT).show();
                    });
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