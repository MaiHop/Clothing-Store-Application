package com.example.myapplication.Api;

import com.example.myapplication.Model2.DonHangChiTiet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface DonHangChiTiet_api {
    @GET("DonHangChiTiet/readAll")
    Call<List<DonHangChiTiet>> readallDonHangChiTiet();

    @GET("DonHangChiTiet/get")
    Call<DonHangChiTiet> getDonHangChiTiet(@Query("id") Integer id);

    @POST("DonHangChiTiet/create")
    Call<DonHangChiTiet> createDonHangChiTiet(@Body DonHangChiTiet t);

    @PUT("DonHangChiTiet/update")
    Call<DonHangChiTiet> updateDonHangChiTiet(@Body DonHangChiTiet t);

    @PUT("DonHangChiTiet/delete")
    Call<DonHangChiTiet> deleteDonHangChiTiet(@Body DonHangChiTiet t);

}
