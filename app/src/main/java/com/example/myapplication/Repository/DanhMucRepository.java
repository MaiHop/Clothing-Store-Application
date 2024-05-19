package com.example.myapplication.Repository;

import com.example.myapplication.Api.NhomSP_api;
import com.example.myapplication.Api.SanPham_api;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Model.NhomSP;
import com.example.myapplication.Model.SanPham;
//import com.example.myapplication.Presentation.PhucHoi.Activity.DanhMuc;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhMucRepository {
    DanhMucInterface danhMucInterface;
    List<NhomSP> list = new ArrayList<>();

    public DanhMucRepository(DanhMucInterface danhMucInterface) {
        this.danhMucInterface = danhMucInterface;
    }

    public void readNhomSP(){
        NhomSP_api api = ServiceBuilder.buildService(NhomSP_api.class);
        Call<List<NhomSP>> request = api.readallNhomSP();
        request.enqueue(new Callback<List<NhomSP>>() {
            @Override
            public void onResponse(Call<List<NhomSP>> call, Response<List<NhomSP>> response) {
                danhMucInterface.getListNhomSP(response.body());
            }

            @Override
            public void onFailure(Call<List<NhomSP>> call, Throwable t) {

            }
        });
    }

    public interface DanhMucInterface{
        void getListNhomSP(List<NhomSP> list);
//        void getSanPhambyIdSanPham(List<SanPham> list);
    }

}
