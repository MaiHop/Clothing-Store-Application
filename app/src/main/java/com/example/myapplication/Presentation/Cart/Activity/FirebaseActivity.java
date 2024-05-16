package com.example.myapplication.Presentation.Cart.Activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.myapplication.Api.DonHangChiTiet_api;
import com.example.myapplication.Api.SanPham_api;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Model.DonHangChiTiet;
import com.example.myapplication.Model.Mau;
import com.example.myapplication.Model.SanPham;
import com.example.myapplication.Model.YeuThich;
import com.example.myapplication.Presentation.Cart.Apdapter.MauAdapter;
import com.example.myapplication.Presentation.Cart.ViewModel.MauVM;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirebaseActivity extends AppCompatActivity {
    List<DonHangChiTiet> list = new ArrayList<>();
    List<SanPham> list_sp = new ArrayList<>();
    List<Mau> list_m = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mh_activity_firebase);



//        DonHangChiTiet_api api = ServiceBuilder.buildService(DonHangChiTiet_api.class);
//        Call<List<DonHangChiTiet>> request = api.readallDonHangChiTiet();
//        request.enqueue(new Callback<List<DonHangChiTiet>>() {
//            @Override
//            public void onResponse(Call<List<DonHangChiTiet>> call, Response<List<DonHangChiTiet>> response) {
//                list= response.body();
//                MauVM color_vm = new ViewModelProvider((ViewModelStoreOwner) FirebaseActivity.this).get(MauVM.class);
//                color_vm.getListMauProductEditLiveData(list,list.get(0).getSanPham()).observe((LifecycleOwner) FirebaseActivity.this, new Observer<List<Mau>>() {
//                    @Override
//                    public void onChanged(List<Mau> maus) {
//                        for(Mau m : maus){
//                            boolean alreadyExists = false;
//                            for (Mau mau : list_m) {
//                                if (m.getId().equals(mau.getId())) {
//                                    alreadyExists = true;
//                                    break;  // Nếu đã tìm thấy một màu trùng lặp, thoát khỏi vòng lặp
//                                }
//                            }
//                            if (!alreadyExists) {
//                                list_m.add(m);  // Chỉ thêm màu nếu nó chưa tồn tại trong danh sách test
//                            }
//                        }
//                        Log.d("ADSSADASD",String.valueOf(list_m.size()));
//
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(Call<List<DonHangChiTiet>> call, Throwable t) {
//
//            }
//        });
//        callSync.enqueue(new Callback<List<KieuSP>>() {
//            @Override
//            public void onResponse(Call<List<KieuSP>> call, Response<List<KieuSP>> response) {
//                List<KieuSP> list = response.body();
//                Log.d("TestExcute",String.valueOf(list.size()));
//            }
//
//            @Override
//            public void onFailure(Call<List<KieuSP>> call, Throwable t) {
//
//            }
//        });

//        SanPham_api api = ServiceBuilder.buildService(SanPham_api.class);
//        Call<List<SanPham>> request = api.getSanPhambyIdSanPham("Dgwb6Wp73Su8Nr764Uej");
//        request.enqueue(new Callback<List<SanPham>>() {
//            @Override
//            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
//                List<SanPham>list_sp = response.body();
//                for(SanPham sp : list_sp){
//                    if(!list_m.contains(sp.getMau())){
//                        list_m.add(sp.getMau());
//                    }
//                }
//                for(Mau m : list_m){
//                    Log.d("List_Mau",String.valueOf(m.getId()+"_"+m.getTen()));
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<SanPham>> call, Throwable t) {
//
//            }
//        });

//        Mau m1 = new Mau();
//        m1.setId("1");
//        m1.setTen("A");
//
//        Mau m2 = new Mau();
//        m2.setId("1");
//        m2.setTen("A");
//
//        Mau m3 = new Mau();
//        m3.setId("1");
//        m3.setTen("A");
//
//        Mau m4 = new Mau();
//        m4.setId("1");
//        m4.setTen("A");
//
//        Mau m5 = new Mau();
//        m5.setId("1");
//        m5.setTen("A");
//
//        Mau m6 = new Mau();
//        m6.setId("1");
//        m6.setTen("A");
//
//        list_m.add(m1);
//        list_m.add(m2);
//        list_m.add(m3);
//        list_m.add(m4);
//        list_m.add(m5);
//        list_m.add(m6);
//        List<Mau> test = new ArrayList<>();
//
//        for(Mau m : list_m){
//            boolean alreadyExists = false;
//            for (Mau mau : test) {
//                if (m.getId().equals(mau.getId())) {
//                    alreadyExists = true;
//                    break;  // Nếu đã tìm thấy một màu trùng lặp, thoát khỏi vòng lặp
//                }
//            }
//            if (!alreadyExists) {
//                test.add(m);  // Chỉ thêm màu nếu nó chưa tồn tại trong danh sách test
//            }
//        }
//        Log.d("asdsdsfd", String.valueOf(test.size()));

        

    }
}