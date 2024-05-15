package com.example.myapplication.Repository;

import com.example.myapplication.Api.DonHangChiTiet_api;
import com.example.myapplication.Api.KichThuoc_api;
import com.example.myapplication.Api.SanPham_api;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Model.DonHangChiTiet;
import com.example.myapplication.Model.KichThuoc;
import com.example.myapplication.Model.SanPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KichThuocRepository {
    KichThuocInterface kichThuocInterface;
    List<KichThuoc> list = new ArrayList<>();

    public KichThuocRepository(KichThuocInterface kichThuocInterface) {
        this.kichThuocInterface = kichThuocInterface;
    }

    public void readKichThuoc(){
        KichThuoc_api api = ServiceBuilder.buildService(KichThuoc_api.class);
        Call<List<KichThuoc>> request = api.readallKichThuoc();
        request.enqueue(new Callback<List<KichThuoc>>() {
            @Override
            public void onResponse(Call<List<KichThuoc>> call, Response<List<KichThuoc>> response) {
                if(response.isSuccessful()){
                    kichThuocInterface.getListKichThuoc(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<KichThuoc>> call, Throwable t) {

            }
        });
    }
    public void readSanPhambyIdSanPham(String id){
        SanPham_api api = ServiceBuilder.buildService(SanPham_api.class);
        Call<List<SanPham>> request = api.getSanPhambyIdSanPham(id);
        request.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                kichThuocInterface.getSanPhambyIdSanPham(response.body());
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {

            }
        });
    }

    public interface KichThuocInterface{
        void getListKichThuoc(List<KichThuoc> list);
        void getSanPhambyIdSanPham(List<SanPham> list);
    }

}
