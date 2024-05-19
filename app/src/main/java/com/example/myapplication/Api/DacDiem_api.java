package com.example.myapplication.Api;

import com.example.myapplication.Model2.DacDiem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface DacDiem_api {
    @GET("DacDiem/readAll")
    Call<List<DacDiem>> readallDacDiem();

    @GET("DacDiem/get")
    Call<DacDiem> getDacDiem(@Query("id") Integer id);

    @POST("DacDiem/create")
    Call<DacDiem> createDacDiem(@Body DacDiem t);

    @PUT("DacDiem/update")
    Call<DacDiem> updateDacDiem(@Body DacDiem t);

    @PUT("DacDiem/delete")
    Call<DacDiem> deleteDacDiem(@Body DacDiem t);

}
