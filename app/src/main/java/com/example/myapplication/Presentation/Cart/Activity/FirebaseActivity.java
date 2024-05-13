package com.example.myapplication.Presentation.Cart.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.Domain.Model.KieuSP;
import com.example.myapplication.R;

public class FirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mh_activity_firebase);

        KieuSP kieu = new KieuSP();
        kieu.setId("TestRetrofit");
        kieu.setTen("TestRetrofitUpdate");
        Call<KieuSP> req = com.example.myapplication.Data.Data_Source.Api.KieuSP.deleteKieuSP(kieu.getId());
        req.enqueue(new Callback<KieuSP>() {
            @Override
            public void onResponse(Call<KieuSP> call, Response<KieuSP> response) {
                Log.d("UpdateR","OK");
            }

            @Override
            public void onFailure(Call<KieuSP> call, Throwable t) {

            }
        });

    }
}