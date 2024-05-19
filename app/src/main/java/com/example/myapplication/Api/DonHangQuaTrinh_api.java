    package com.example.myapplication.Api;

import com.example.myapplication.Model2.DonHangQuaTrinh;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface DonHangQuaTrinh_api {
    @GET("DonHangQuaTrinh/readAll")
    Call<List<DonHangQuaTrinh>> readallDonHangQuaTrinh();

    @GET("DonHangQuaTrinh/get")
    Call<DonHangQuaTrinh> getDonHangQuaTrinh(@Query("id") Integer id);

    @POST("DonHangQuaTrinh/create")
    Call<DonHangQuaTrinh> createDonHangQuaTrinh(@Body DonHangQuaTrinh t);

    @PUT("DonHangQuaTrinh/update")
    Call<DonHangQuaTrinh> updateDonHangQuaTrinh(@Body DonHangQuaTrinh t);

    @PUT("DonHangQuaTrinh/delete")
    Call<DonHangQuaTrinh> deleteDonHangQuaTrinh(@Body DonHangQuaTrinh t);

}
