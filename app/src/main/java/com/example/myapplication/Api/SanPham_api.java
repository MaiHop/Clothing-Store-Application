package com.example.myapplication.Api;

import com.example.myapplication.Model2.SanPham;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface SanPham_api {
    @GET("SanPham/readAll")
    Call<List<SanPham>> readallSanPham();

    @GET("SanPham/get")
    Call<SanPham> getSanPham(@Query("id") Integer id);

    @POST("SanPham/create")
    Call<SanPham> createSanPham(@Body SanPham t);

    @PUT("SanPham/update")
    Call<SanPham> updateSanPham(@Body SanPham t);

    @PUT("SanPham/delete")
    Call<SanPham> deleteSanPham(@Body SanPham t);

}
