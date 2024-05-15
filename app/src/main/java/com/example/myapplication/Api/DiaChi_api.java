package com.example.myapplication.Api;

import com.example.myapplication.Model.DiaChi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface DiaChi_api {
    @GET("DiaChi/readAll")
    Call<List<DiaChi>> readallDiaChi();

    @GET("DiaChi/get")
    Call<DiaChi> getDiaChi(@Query("id") String id);

    @POST("DiaChi/create")
    Call<DiaChi> createDiaChi(@Body DiaChi diachi);

    @PUT("DiaChi/update")
    Call<DiaChi> updateDiaChi(@Body DiaChi diachi);

    @PUT("DiaChi/delete")
    Call<DiaChi> deleteDiaChi(@Query("id")String id);

}
