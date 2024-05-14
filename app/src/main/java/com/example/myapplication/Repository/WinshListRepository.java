package com.example.myapplication.Repository;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Api.YeuThich_api;
import com.example.myapplication.Model.YeuThich;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WinshListRepository {

    WishListInterface wishListInterface;

    public WinshListRepository(WishListInterface wishListInterface){
        this.wishListInterface = wishListInterface;
    }
    public void readallWishList(){

        YeuThich_api yeuThichApi = ServiceBuilder.buildService(YeuThich_api.class);
        Call<List<YeuThich>> request = yeuThichApi.readallYeuThich();
        request.enqueue(new Callback<List<YeuThich>>() {
            @Override
            public void onResponse(Call<List<YeuThich>> call, Response<List<YeuThich>> response) {
                if (response.isSuccessful()){
                    wishListInterface.getWishList(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<YeuThich>> call, Throwable t) {

            }
        });

    }


    public interface WishListInterface{
        void getWishList(List<YeuThich> list);
    }
}
