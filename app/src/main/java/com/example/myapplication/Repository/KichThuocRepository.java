package com.example.myapplication.Repository;

import com.example.myapplication.Api.KichThuoc_api;
import com.example.myapplication.Api.SanPham_api;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Model2.KichThuoc;
import com.example.myapplication.Model2.SanPham;

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
//                    kichThuocInterface.getListKichThuoc(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<KichThuoc>> call, Throwable t) {

            }
        });
    }
    public void readSanPhambyIdSanPham(Integer id){
        SanPham_api api = ServiceBuilder.buildService(SanPham_api.class);
        Call<SanPham> request = api.getSanPham(id);
        request.enqueue(new Callback<SanPham>() {
            @Override
            public void onResponse(Call<SanPham> call, Response<SanPham> response) {
//                kichThuocInterface.getSanPhambyIdSanPham(response.body());
            }

            @Override
            public void onFailure(Call<SanPham> call, Throwable t) {

            }
        });
    }

    public interface KichThuocInterface{

    }

}
