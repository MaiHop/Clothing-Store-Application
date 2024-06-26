package com.example.myapplication.Api;

import com.example.myapplication.Model2.KhachHang;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface KhachHang_api {
    @GET("KhachHang/readAll")
    Call<List<KhachHang>> readallKhachHang();

    @GET("KhachHang/get")
    Call<KhachHang> getKhachHang(@Query("id") Integer id);

    @GET("KhachHang/getbyUID")
    Call<KhachHang> findKhachHangbyUID(@Query("uid") String id);

    @POST("KhachHang/create")
    Call<KhachHang> createKhachHang(@Body KhachHang t);

    @PUT("KhachHang/update")
    Call<KhachHang> updateKhachHang(@Path("id") int id, @Body KhachHang t);

    @PUT("KhachHang/delete")
    Call<KhachHang> deleteKhachHang(@Body KhachHang t);

}
