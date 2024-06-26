package com.example.myapplication.Api;

import com.example.myapplication.Model2.ThanhToan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ThanhToan_api {
    @GET("ThanhToan/readAll")
    Call<List<ThanhToan>> readallThanhToan();

    @GET("ThanhToan/get")
    Call<ThanhToan> getThanhToan(@Query("id") Integer id);

    @POST("ThanhToan/create")
    Call<ThanhToan> createThanhToan(@Body ThanhToan t);

    @PUT("ThanhToan/update")
    Call<ThanhToan> updateThanhToan(@Body ThanhToan t);

    @PUT("ThanhToan/delete")
    Call<ThanhToan> deleteThanhToan(@Body ThanhToan t);

}
