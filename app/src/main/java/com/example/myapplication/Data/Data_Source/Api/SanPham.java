package com.example.myapplication.Data.Data_Source.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface SanPham {
    @GET("SanPham/readAll")
    Call<List<SanPham>> readallSanPham();

    @GET("SanPham/get")
    Call<SanPham> getSanPham(@Query("id") int id);

    @POST("SanPham/create")
    Call<SanPham> createSanPham(@Body SanPham sanpham);

    @PUT("SanPham/update")
    Call<SanPham> updateSanPham(@Body SanPham sanpham);

    @PUT("SanPham/delete")
    Call<SanPham> deleteSanPham(@Query("id")String id);

}
