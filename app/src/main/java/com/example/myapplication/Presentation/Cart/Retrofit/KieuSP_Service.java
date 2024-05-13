package com.example.myapplication.Presentation.Cart.Retrofit;

import com.example.myapplication.Domain.Model.KieuSP;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface KieuSP_Service {
    @GET("KieuSP/readAll")
    Call<List<KieuSP>> readallKieuSP();

    @GET("KieuSP/get")
    Call<KieuSP> getKieuSP(@Query("id") int id);

    @POST("KieuSP/create")
    Call<KieuSP> createKieuSP(@Body KieuSP kieu);

    @FormUrlEncoded
    @PUT("KieuSP/update")
    Call<KieuSP> updateKieuSP(@Body KieuSP kieu);

    @DELETE("KieuSP/delete")
    Call<Void> deleteIdea(@Query("id")int id);
}
