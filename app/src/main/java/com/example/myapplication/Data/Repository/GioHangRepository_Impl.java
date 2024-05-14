package com.example.myapplication.Data.Repository;

import android.util.Log;

import com.example.myapplication.Data.Data_Source.Api.DonHangChiTiet_api;
import com.example.myapplication.Data.Data_Source.Api.Servicebuilder;
import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Domain.Model.DonHangChiTiet;
import com.example.myapplication.Domain.Repository.GioHangRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHangRepository_Impl implements GioHangRepository {
    private CartRepository cartRepository;
    List<DonHangChiTiet> list_dh = new ArrayList<>();
    public GioHangRepository_Impl() {
        cartRepository = new CartRepository();
    }
    @Override
    public List<DonHangChiTiet> getGioHang() {

        DonHangChiTiet_api api = Servicebuilder.buildService(DonHangChiTiet_api.class);
        Call<List<DonHangChiTiet>> request = api.readallDonHangChiTiet();
        request.enqueue(new Callback<List<DonHangChiTiet>>() {
            @Override
            public void onResponse(Call<List<DonHangChiTiet>> call, Response<List<DonHangChiTiet>> response) {
                if(response.isSuccessful()){
                    list_dh = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<DonHangChiTiet>> call, Throwable t) {
                if (t instanceof IOException){
                    Log.d("Exception", "A connection error occured");
                } else {
                    Log.d("Exception", "Failed to retrieve items");
                }
            }
        });
        return list_dh;
    }

    @Override
    public boolean AddGioHang(DonHangChiTiet dhct) {
        return false;
    }

    @Override
    public boolean UpdateGioHang(DonHangChiTiet dhct) {
        return false;
    }

    @Override
    public boolean DeleteGioHang(String IdDonHang) {
        return false;
    }
}
