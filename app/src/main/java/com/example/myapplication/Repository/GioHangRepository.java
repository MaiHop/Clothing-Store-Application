package com.example.myapplication.Repository;

import com.example.myapplication.Api.DonHangChiTiet_api;
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
        KhachHang_api api = ServiceBuilder.buildService(KhachHang_api.class);
        Call<KhachHang> request = api.getKhachHang(2);
        request.enqueue(new Callback<KhachHang>() {
            @Override
            public void onResponse(Call<KhachHang> call, Response<KhachHang> response) {
                List<DonHang> list_dh = response.body().getListDonHang();
                for(DonHang dh : list_dh){
                    if (dh.getTrangThai().equals("Prepare")){
                        gioHangInterface.getGioHang(dh.getListDonHangChiTiet());
                    }
                }

            }

            @Override
            public void onFailure(Call<KhachHang> call, Throwable t) {

            }
        });
    }

    public interface GioHangInterface{
        void getGioHang(List<DonHangChiTiet> list);
    }

}
