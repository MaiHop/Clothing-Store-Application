package com.example.myapplication.Presentation.Cart.Activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.myapplication.Api.DonHangChiTiet_api;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mh_activity_firebase);


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestore db1 = FirebaseFirestore.getInstance();
        db.collection("SanPham").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(!queryDocumentSnapshots.isEmpty()){
                    List<DocumentSnapshot> list_doc = queryDocumentSnapshots.getDocuments();
                    for(DocumentSnapshot doc : list_doc){
                        SanPham sp = doc.toObject(SanPham.class);
                        sp.setId(doc.getId());
                        list_sp.add(sp);
                    }
                }
                YeuThich l = new YeuThich();
                List<SanPham> listsp= new ArrayList<>();
                listsp.add(list_sp.get(0));
                listsp.add(list_sp.get(2));
                listsp.add(list_sp.get(4));
                listsp.add(list_sp.get(7));
                listsp.add(list_sp.get(9));
                l.setListsanpham(listsp);
                db1.collection("YeuThich").add(l).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("SADASDAS","OK");
                    }
                });
            }
        });
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
//                        List<Mau> listMau_temp = new ArrayList<>();
////                        for(Mau m : maus){
////                            Log.d("ListMau",String.valueOf(m.getTen()+ m.getId()));
////                        }
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



    }
}