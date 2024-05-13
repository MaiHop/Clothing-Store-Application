package com.example.myapplication.Data.Data_Source.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface DanhGia {
    @GET("DanhGia/readAll")
    Call<List<DanhGia>> readallDanhGia();

    @GET("DanhGia/get")
    Call<DanhGia> getDanhGia(@Query("id") int id);

    @POST("DanhGia/create")
    Call<DanhGia> createDanhGia(@Body DanhGia danhgia);

    @PUT("DanhGia/update")
    Call<DanhGia> updateDanhGia(@Body DanhGia danhgia);

    @PUT("DanhGia/delete")
    Call<DanhGia> deleteDanhGia(@Query("id")String id);

}
