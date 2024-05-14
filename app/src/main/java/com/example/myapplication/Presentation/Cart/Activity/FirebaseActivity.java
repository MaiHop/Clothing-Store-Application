package com.example.myapplication.Presentation.Cart.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.Api.KieuSP_api;
import com.example.myapplication.Api.Servicebuilder;
import com.example.myapplication.Model.KieuSP;
import com.example.myapplication.R;

import java.util.List;

import retrofit2.Call;

public class FirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mh_activity_firebase);

        KieuSP_api kieuSPService = Servicebuilder.buildService(KieuSP_api.class);
        Call<List<KieuSP>> callSync = kieuSPService.readallKieuSP();

        try {
            List<KieuSP> list = callSync.execute().body();
            Log.d("TestExcute",String.valueOf(list.size()));
        }catch (Exception e){
            e.printStackTrace();
        }
//        callSync.enqueue(new Callback<List<KieuSP>>() {
//            @Override
//            public void onResponse(Call<List<KieuSP>> call, Response<List<KieuSP>> response) {
//                List<KieuSP> list = response.body();
//                Log.d("TestExcute",String.valueOf(list.size()));
//            }
//
//            @Override
//            public void onFailure(Call<List<KieuSP>> call, Throwable t) {
//
//            }
//        });

    }
}