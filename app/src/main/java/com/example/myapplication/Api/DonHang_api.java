package com.example.myapplication.Api;

import com.example.myapplication.Model2.DonHang;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface DonHang_api {
    @GET("DonHang/readAll")
    Call<List<DonHang>> readallDonHang();

    @GET("DonHang/get")
    Call<DonHang> getDonHang(@Query("id") Integer id);

    @GET("DonHang/findByidKhachHang")
    Call<List<DonHang>> findByidKhachHang(@Query("id") Integer id);
    @POST("DonHang/create")
    Call<DonHang> createDonHang(@Body DonHang t);

    @PUT("DonHang/update")
    Call<DonHang> updateDonHang(@Body DonHang t);

    @PUT("DonHang/delete")
    Call<DonHang> deleteDonHang(@Body DonHang t);

}
