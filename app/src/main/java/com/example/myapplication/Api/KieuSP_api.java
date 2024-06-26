package com.example.myapplication.Api;

import com.example.myapplication.Model2.KieuSP;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface KieuSP_api {
    @GET("KieuSP/readAll")
    Call<List<KieuSP>> readallKieuSP();

    @GET("KieuSP/get")
    Call<KieuSP> getKieuSP(@Query("id") Integer id);

    @POST("KieuSP/create")
    Call<KieuSP> createKieuSP(@Body KieuSP t);

    @PUT("KieuSP/update")
    Call<KieuSP> updateKieuSP(@Body KieuSP t);

    @PUT("KieuSP/delete")
    Call<KieuSP> deleteKieuSP(@Body KieuSP t);

}
