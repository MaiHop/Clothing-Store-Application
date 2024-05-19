package com.example.myapplication.Api;

import com.example.myapplication.Model.KhachHang;
import com.example.myapplication.Model.KhachHang;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface KhachHang_api {
    @GET("KhachHang/readAll")
    Call<List<KhachHang>> readallKhachHang();

    @GET("KhachHang/get")
    Call<KhachHang> getKhachHang(@Query("id") Integer id);

    @POST("KhachHang/create")
    Call<KhachHang> createKhachHang(@Body KhachHang t);

    @PUT("KhachHang/update")
    Call<KhachHang> updateKhachHang(@Body KhachHang t);

    @PUT("KhachHang/delete")
    Call<KhachHang> deleteKhachHang(@Body KhachHang t);

}
