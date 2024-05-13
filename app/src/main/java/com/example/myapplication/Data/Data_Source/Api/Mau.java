package com.example.myapplication.Data.Data_Source.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface Mau {
    @GET("Mau/readAll")
    Call<List<Mau>> readallMau();

    @GET("Mau/get")
    Call<Mau> getMau(@Query("id") int id);

    @POST("Mau/create")
    Call<Mau> createMau(@Body Mau mau);

    @PUT("Mau/update")
    Call<Mau> updateMau(@Body Mau mau);

    @PUT("Mau/delete")
    Call<Mau> deleteMau(@Query("id")String id);

}
