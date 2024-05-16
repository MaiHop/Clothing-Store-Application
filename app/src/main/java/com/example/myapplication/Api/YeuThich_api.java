package com.example.myapplication.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface YeuThich_api {
    @GET("YeuThich/readAll")
    Call<List<YeuThich>> readallYeuThich();

    @GET("YeuThich/get")
    Call<YeuThich> getYeuThich(@Query("id") String id);

    @POST("YeuThich/create")
    Call<YeuThich> createYeuThich(@Body YeuThich yeuthich);

    @PUT("YeuThich/update")
    Call<YeuThich> updateYeuThich(@Body YeuThich yeuthich);

    @PUT("YeuThich/delete")
    Call<YeuThich> deleteYeuThich(@Query("id")String id);

}
