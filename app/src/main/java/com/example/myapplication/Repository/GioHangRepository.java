package com.example.myapplication.Repository;

import com.example.myapplication.Api.DonHangChiTiet_api;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Model.DonHangChiTiet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHangRepository  {
    GioHangInterface gioHangInterface;
    List<DonHangChiTiet> list = new ArrayList<>();

    public GioHangRepository(GioHangInterface gioHangInterface) {
        this.gioHangInterface = gioHangInterface;
    }

    public void readGioHang(){
        DonHangChiTiet_api api = ServiceBuilder.buildService(DonHangChiTiet_api.class);
        Call<List<DonHangChiTiet>> request = api.readallDonHangChiTiet();
        request.enqueue(new Callback<List<DonHangChiTiet>>() {
            @Override
            public void onResponse(Call<List<DonHangChiTiet>> call, Response<List<DonHangChiTiet>> response) {
                if(response.isSuccessful()){
                    gioHangInterface.getGioHang(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<DonHangChiTiet>> call, Throwable t) {

            }
        });
    }

    public interface GioHangInterface{
        void getGioHang(List<DonHangChiTiet> list);
    }

}
