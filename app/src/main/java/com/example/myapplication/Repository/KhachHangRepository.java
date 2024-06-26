package com.example.myapplication.Repository;

import com.example.myapplication.Api.KhachHang_api;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Model2.KhachHang;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KhachHangRepository {

    private KhachHangInterface khachHangInterface;

    public KhachHangRepository(KhachHangInterface khachHangInterface) {
        this.khachHangInterface = khachHangInterface;
    }

    public void createKhachHang(KhachHang khachHang) {
        KhachHang_api khachHangApi = ServiceBuilder.buildService(KhachHang_api.class);
        Call<KhachHang> request = khachHangApi.createKhachHang(khachHang);

        request.enqueue(new Callback<KhachHang>() {
            @Override
            public void onResponse(Call<KhachHang> call, Response<KhachHang> response) {
                if (response.isSuccessful()) {
                    khachHangInterface.onKhachHangCreated(response.body());
                }
            }

            @Override
            public void onFailure(Call<KhachHang> call, Throwable t) {
                khachHangInterface.onError(t);
            }
        });
    }
    public void updateKhachHang(int id, KhachHang khachHang) {
        KhachHang_api khachHangApi = ServiceBuilder.buildService(KhachHang_api.class);
        Call<KhachHang> request = khachHangApi.updateKhachHang(id, khachHang);

        request.enqueue(new Callback<KhachHang>() {
            @Override
            public void onResponse(Call<KhachHang> call, Response<KhachHang> response) {
                if (response.isSuccessful()) {
                    khachHangInterface.onKhachHangUpdated(response.body());
                }
            }

            @Override
            public void onFailure(Call<KhachHang> call, Throwable t) {
                khachHangInterface.onError(t);
            }
        });
    }
    public void readAllKhachHang() {
        KhachHang_api khachHangApi = ServiceBuilder.buildService(KhachHang_api.class);
        Call<List<KhachHang>> request = khachHangApi.readallKhachHang();

        request.enqueue(new Callback<List<KhachHang>>() {
            @Override
            public void onResponse(Call<List<KhachHang>> call, Response<List<KhachHang>> response) {
                if (response.isSuccessful()) {
                    khachHangInterface.onAllKhachHangRead(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<KhachHang>> call, Throwable t) {
                khachHangInterface.onError(t);
            }
        });
    }
    public void getKhachHang(String uid) {
        KhachHang_api khachHangApi = ServiceBuilder.buildService(KhachHang_api.class);
        Call<KhachHang> request = khachHangApi.findKhachHangbyUID(uid);

        request.enqueue(new Callback<KhachHang>() {
            @Override
            public void onResponse(Call<KhachHang> call, Response<KhachHang> response) {
                if (response.isSuccessful()) {
                    khachHangInterface.onKhachHangReceived(response.body());
                } else {
                    khachHangInterface.onError(new Throwable("Failed to fetch KhachHang with UID: " + uid));
                }
            }

            @Override
            public void onFailure(Call<KhachHang> call, Throwable t) {
                khachHangInterface.onError(t);
            }
        });
    }

    public KhachHang getUidKhachHang(String uid) {
        KhachHang_api khachHangApi = ServiceBuilder.buildService(KhachHang_api.class);
        Call<KhachHang> request = khachHangApi.findKhachHangbyUID(uid);

        request.enqueue(new Callback<KhachHang>() {
            @Override
            public void onResponse(Call<KhachHang> call, Response<KhachHang> response) {
                if (response.isSuccessful()) {
                    khachHangInterface.onKhachHangReceived(response.body());
                } else {
                    khachHangInterface.onError(new Throwable("Failed to fetch KhachHang with UID: " + uid));
                }
            }

            @Override
            public void onFailure(Call<KhachHang> call, Throwable t) {
                khachHangInterface.onError(t);
            }
        });
        return (KhachHang) request;
    }


    public interface KhachHangInterface {
        void onKhachHangCreated(KhachHang khachHang);
        void onKhachHangUpdated(KhachHang khachHang);
        void onAllKhachHangRead(List<KhachHang> khachHangList);
        void onError(Throwable t);

        void onKhachHangReceived(KhachHang body);
    }
}
