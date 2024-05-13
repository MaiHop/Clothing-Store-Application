package com.example.myapplication.Data.Data_Source.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface KhachHang {
    @GET("KhachHang/readAll")
    Call<List<KhachHang>> readallKhachHang();

    @GET("KhachHang/get")
    Call<KhachHang> getKhachHang(@Query("id") int id);

    @POST("KhachHang/create")
    Call<KhachHang> createKhachHang(@Body KhachHang khachhang);

    @PUT("KhachHang/update")
    Call<KhachHang> updateKhachHang(@Body KhachHang khachhang);

    @PUT("KhachHang/delete")
    Call<KhachHang> deleteKhachHang(@Query("id")String id);

}
