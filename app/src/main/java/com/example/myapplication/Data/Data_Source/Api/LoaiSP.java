package com.example.myapplication.Data.Data_Source.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface LoaiSP {
    @GET("LoaiSP/readAll")
    Call<List<LoaiSP>> readallLoaiSP();

    @GET("LoaiSP/get")
    Call<LoaiSP> getLoaiSP(@Query("id") int id);

    @POST("LoaiSP/create")
    Call<LoaiSP> createLoaiSP(@Body LoaiSP loai);

    @PUT("LoaiSP/update")
    Call<LoaiSP> updateLoaiSP(@Body LoaiSP loai);

    @PUT("LoaiSP/delete")
    Call<LoaiSP> deleteLoaiSP(@Query("id")String id);

}
