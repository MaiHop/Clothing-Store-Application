package com.example.myapplication.Presentation.Cart.Activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Api.DonHangChiTiet_api;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Model.DonHangChiTiet;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirebaseActivity extends AppCompatActivity {
    List<DonHangChiTiet> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mh_activity_firebase);



        DonHangChiTiet_api api = ServiceBuilder.buildService(DonHangChiTiet_api.class);
        Call<List<DonHangChiTiet>> request = api.readallDonHangChiTiet();
        request.enqueue(new Callback<List<DonHangChiTiet>>() {
            @Override
            public void onResponse(Call<List<DonHangChiTiet>> call, Response<List<DonHangChiTiet>> response) {
                list= response.body();
                Log.d("TestExcute",String.valueOf(list.get(0).getSanPham().getImageUrl()));
            }

            @Override
            public void onFailure(Call<List<DonHangChiTiet>> call, Throwable t) {

            }
        });
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