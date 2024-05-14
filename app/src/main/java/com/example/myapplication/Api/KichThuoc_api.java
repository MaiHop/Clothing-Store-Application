package com.example.myapplication.Api;

import com.example.myapplication.Model.KichThuoc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface KichThuoc_api {
    @GET("KichThuoc/readAll")
    Call<List<KichThuoc>> readallKichThuoc();

    @GET("KichThuoc/get")
    Call<KichThuoc> getKichThuoc(@Query("id") String id);

    @POST("KichThuoc/create")
    Call<KichThuoc> createKichThuoc(@Body KichThuoc kichthuoc);

    @PUT("KichThuoc/update")
    Call<KichThuoc> updateKichThuoc(@Body KichThuoc kichthuoc);

    @PUT("KichThuoc/delete")
    Call<KichThuoc> deleteKichThuoc(@Query("id")String id);

}
