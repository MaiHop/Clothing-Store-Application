package com.example.myapplication.Presentation.Cart.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Domain.Model.KieuSP;
import com.example.myapplication.R;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestRetrofit extends AppCompatActivity {
    List<KieuSP>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_retrofit);

        KieuSP_Service kieuSPService =ServiceBuilder.buildService(KieuSP_Service.class);
//        Call<List<KieuSP>> req = kieuSPService.readallKieuSP();
//        req.enqueue(new Callback<List<KieuSP>>() {
//            @Override
//            public void onResponse(Call<List<KieuSP>> call, Response<List<KieuSP>> response) {
//                list = response.body();
//                Log.d("Test Retrofit", String.valueOf(list.size()));
//
//            }
//
//            @Override
//            public void onFailure(Call<List<KieuSP>> call, Throwable t) {
//                if (t instanceof IOException){
//                    Toast.makeText(TestRetrofit.this, "A connection error occured", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(TestRetrofit.this, "Failed to retrieve items", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
        KieuSP kieu = new KieuSP();
        kieu.setId("TestRetrofit");
        kieu.setTen("TestRetrofitUpdate");
        Call<KieuSP> req = kieuSPService.deleteKieuSP(kieu.getId());
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