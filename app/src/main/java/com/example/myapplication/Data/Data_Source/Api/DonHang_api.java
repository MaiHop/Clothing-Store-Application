package com.example.myapplication.Data.Data_Source.Api;

import com.example.myapplication.Domain.Model.DonHang;

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
    Call<DonHang> getDonHang(@Query("id") int id);

    @POST("DonHang/create")
    Call<DonHang> createDonHang(@Body DonHang donhang);

    @PUT("DonHang/update")
    Call<DonHang> updateDonHang(@Body DonHang donhang);

    @PUT("DonHang/delete")
    Call<DonHang> deleteDonHang(@Query("id")String id);

}
