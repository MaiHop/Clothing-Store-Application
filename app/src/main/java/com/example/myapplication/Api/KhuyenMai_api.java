package com.example.myapplication.Api;

import com.example.myapplication.Model2.KhuyenMai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface KhuyenMai_api {
    @GET("KhuyenMai/readAll")
    Call<List<KhuyenMai>> readallKhuyenMai();

    @GET("KhuyenMai/get")
    Call<KhuyenMai> getKhuyenMai(@Query("id") Integer id);

    @POST("KhuyenMai/create")
    Call<KhuyenMai> createKhuyenMai(@Body KhuyenMai t);

    @PUT("KhuyenMai/update")
    Call<KhuyenMai> updateKhuyenMai(@Body KhuyenMai t);

    @PUT("KhuyenMai/delete")
    Call<KhuyenMai> deleteKhuyenMai(@Body KhuyenMai t);

}
