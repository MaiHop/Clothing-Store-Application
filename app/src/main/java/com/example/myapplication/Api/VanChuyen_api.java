package com.example.myapplication.Api;

import com.example.myapplication.Model.VanChuyen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface VanChuyen_api {
    @GET("VanChuyen/readAll")
    Call<List<VanChuyen>> readallVanChuyen();

    @GET("VanChuyen/get")
    Call<VanChuyen> getVanChuyen(@Query("id") int id);

    @POST("VanChuyen/create")
    Call<VanChuyen> createVanChuyen(@Body VanChuyen vanchuyen);

    @PUT("VanChuyen/update")
    Call<VanChuyen> updateVanChuyen(@Body VanChuyen vanchuyen);

    @PUT("VanChuyen/delete")
    Call<VanChuyen> deleteVanChuyen(@Query("id")String id);

}
