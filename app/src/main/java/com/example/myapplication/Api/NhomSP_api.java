package com.example.myapplication.Api;

import com.example.myapplication.Model2.NhomSP;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface NhomSP_api {
    @GET("NhomSP/readAll")
    Call<List<NhomSP>> readallNhomSP();

    @GET("NhomSP/get")
    Call<NhomSP> getNhomSP(@Query("id") Integer id);

    @POST("NhomSP/create")
    Call<NhomSP> createNhomSP(@Body NhomSP t);

    @PUT("NhomSP/update")
    Call<NhomSP> updateNhomSP(@Body NhomSP t);

    @PUT("NhomSP/delete")
    Call<NhomSP> deleteNhomSP(@Body NhomSP t);

}
