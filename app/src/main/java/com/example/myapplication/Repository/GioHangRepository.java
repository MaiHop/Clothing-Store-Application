package com.example.myapplication.Repository;

import com.example.myapplication.Api.DonHangChiTiet_api;
import com.example.myapplication.Api.DonHang_api;
import com.example.myapplication.Api.KhachHang_api;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Model2.DonHang;
import com.example.myapplication.Model2.DonHangChiTiet;
import com.example.myapplication.Model2.KhachHang;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHangRepository  {
    GioHangInterface gioHangInterface;

    public GioHangRepository(GioHangInterface gioHangInterface) {
        this.gioHangInterface = gioHangInterface;
    }

    public void readGioHang(){
        DonHang_api api = ServiceBuilder.buildService(DonHang_api.class);
        Call<List<DonHang>> request = api.findByidKhachHang(2);
        request.enqueue(new Callback<List<DonHang>>() {
            @Override
            public void onResponse(Call<List<DonHang>> call, Response<List<DonHang>> response) {
                for(DonHang dh : response.body()){
                    if(dh.getTrangThai().equals("Prepare")){
                        gioHangInterface.getGioHang(dh.getListDonHangChiTiet());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<DonHang>> call, Throwable t) {

            }
        });
    }

    public interface GioHangInterface{
        void getGioHang(List<DonHangChiTiet> list);
    }

}
