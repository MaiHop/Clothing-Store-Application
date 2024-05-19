package com.example.myapplication.Api;

import com.example.myapplication.Model2.LoaiSP;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface LoaiSP_api {
    @GET("LoaiSP/readAll")
    Call<List<LoaiSP>> readallLoaiSP();

    @GET("LoaiSP/get")
    Call<LoaiSP> getLoaiSP(@Query("id") Integer id);

    @POST("LoaiSP/create")
    Call<LoaiSP> createLoaiSP(@Body LoaiSP t);

    @PUT("LoaiSP/update")
    Call<LoaiSP> updateLoaiSP(@Body LoaiSP t);

    @PUT("LoaiSP/delete")
    Call<LoaiSP> deleteLoaiSP(@Body LoaiSP t);

}
