package com.example.myapplication.Api;

import com.example.myapplication.Model.DanhGia;
import com.example.myapplication.Model.DanhGia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface DanhGia_api {
    @GET("DanhGia/readAll")
    Call<List<DanhGia>> readallDanhGia();

    @GET("DanhGia/get")
    Call<DanhGia> getDanhGia(@Query("id") Integer id);

    @POST("DanhGia/create")
    Call<DanhGia> createDanhGia(@Body DanhGia t);

    @PUT("DanhGia/update")
    Call<DanhGia> updateDanhGia(@Body DanhGia t);

    @PUT("DanhGia/delete")
    Call<DanhGia> deleteDanhGia(@Body DanhGia t);

}
