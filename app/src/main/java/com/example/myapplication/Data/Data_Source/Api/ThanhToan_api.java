package com.example.myapplication.Data.Data_Source.Api;

import com.example.myapplication.Domain.Model.ThanhToan;

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
    Call<ThanhToan> getThanhToan(@Query("id") int id);

    @POST("ThanhToan/create")
    Call<ThanhToan> createThanhToan(@Body ThanhToan thanhtoan);

    @PUT("ThanhToan/update")
    Call<ThanhToan> updateThanhToan(@Body ThanhToan thanhtoan);

    @PUT("ThanhToan/delete")
    Call<ThanhToan> deleteThanhToan(@Query("id")String id);

}
