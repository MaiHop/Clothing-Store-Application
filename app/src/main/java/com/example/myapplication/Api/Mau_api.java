package com.example.myapplication.Api;

import com.example.myapplication.Model.Mau;
import com.example.myapplication.Model.Mau;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface Mau_api {
    @GET("Mau/readAll")
    Call<List<Mau>> readallMau();

    @GET("Mau/get")
    Call<Mau> getMau(@Query("id") Integer id);

    @POST("Mau/create")
    Call<Mau> createMau(@Body Mau t);

    @PUT("Mau/update")
    Call<Mau> updateMau(@Body Mau t);

    @PUT("Mau/delete")
    Call<Mau> deleteMau(@Body Mau t);

}
