package com.example.myapplication.Repository;

import com.example.myapplication.Api.DonHangChiTiet_api;
import com.example.myapplication.Api.SanPham_api;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Model.DonHangChiTiet;
import com.example.myapplication.Model.SanPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SanPhamRepository {
    SanPhamInterface sanPhamInterface;
    List<SanPham> list = new ArrayList<>();

    public SanPhamRepository(SanPhamInterface sanPhamInterface) {
        this.sanPhamInterface = sanPhamInterface;
    }

    public void readSanPham(){
        SanPham_api api = ServiceBuilder.buildService(SanPham_api.class);
        Call<List<SanPham>> request = api.readallSanPham();
        request.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                sanPhamInterface.getListSanPham(response.body());
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {

            }
        });
    }

    public void readSanPhambyIdSanPham(String id){
        SanPham_api api = ServiceBuilder.buildService(SanPham_api.class);
        Call<List<SanPham>> request = api.getSanPhambyIdSanPham(id);
        request.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                sanPhamInterface.getSanPhambyIdSanPham(response.body());
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {

            }
        });
    }

    public interface SanPhamInterface{
        void getListSanPham(List<SanPham> list);
        void getSanPhambyIdSanPham(List<SanPham> list);
    }

}
