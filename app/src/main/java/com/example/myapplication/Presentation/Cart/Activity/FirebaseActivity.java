package com.example.myapplication.Presentation.Cart.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Model.DacDiem;
import com.example.myapplication.Model.DonHangChiTiet;
import com.example.myapplication.Model.Kho;
import com.example.myapplication.Model.KichThuoc;
import com.example.myapplication.Model.Mau;
import com.example.myapplication.Model.SanPham;
import com.example.myapplication.Model.SanPham_V2;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FirebaseActivity extends AppCompatActivity {
    List<DonHangChiTiet> list = new ArrayList<>();
    List<Mau> list_m;
    List<Kho> list_k = new ArrayList<>();
    List<SanPham> list_sp = new ArrayList<>();
    List<SanPham_V2> list_sp2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mh_activity_firebase);


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestore db1 = FirebaseFirestore.getInstance();

        db.collection("SanPham").whereEqualTo("idSanPham","rCiDI8qvYpdzaj9nzg1T").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> list_doc = queryDocumentSnapshots.getDocuments();
                    for(DocumentSnapshot doc : list_doc){
                        SanPham sp = doc.toObject(SanPham.class);
                        sp.setId(doc.getId());
                        list_sp.add(sp);
                    }
                    list_m = new ArrayList<>();
                    //Có danh sách sản phẩm
                    for(SanPham sp : list_sp){
                        boolean alreadyExists = false;
                        for (Mau m : list_m) {
                            if (sp.getMau().getId().equals(m.getId())) {
                                alreadyExists = true;
                                break;  // Nếu đã tìm thấy một màu trùng lặp, thoát khỏi vòng lặp
                            }
                        }
                        if (!alreadyExists) {
                            list_m.add(sp.getMau());
                            //Tạo kho
                            Kho k = new Kho();
                            k.setImageURL(sp.getImageUrl());
                            k.setGiaBan(sp.getGiaban());
                            k.setMau(sp.getMau());

                            //Tạo list Đặc điểm
                            List<DacDiem> list_dd = new ArrayList<>();
                            list_dd.add(new DacDiem(100,0,new KichThuoc("1","XS")));
                            list_dd.add(new DacDiem(100,0,new KichThuoc("2","S")));
                            list_dd.add(new DacDiem(100,0,new KichThuoc("3","M")));
                            list_dd.add(new DacDiem(100,0,new KichThuoc("4","L")));
                            list_dd.add(new DacDiem(100,0,new KichThuoc("5","XL")));
                            list_dd.add(new DacDiem(100,0,new KichThuoc("6","XXL")));

                            k.setListDacDiem(list_dd);
                            list_k.add(k);  // Chỉ thêm màu nếu nó chưa tồn tại trong danh sách test
                        }
                    }

                    SanPham_V2 sp2 = new SanPham_V2();
                    sp2.setId(list_sp.get(0).getId());
                    sp2.setIdSanPham(list_sp.get(0).getIdSanPham());
                    sp2.setTenSanPham(list_sp.get(0).getTenSanPham());
                    sp2.setNhomSanPham(list_sp.get(0).getNhomSanPham());
                    sp2.setLoaiSanPham(list_sp.get(0).getLoaiSanPham());
                    sp2.setThongTin(list_sp.get(0).getThongTin());
                    sp2.setNgayTao(list_sp.get(0).getNgayTao());
                    sp2.setListKho(list_k);

                    db1.collection("SanPham_V2").add(sp2).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(FirebaseActivity.this, "OK", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

//                Log.d("TEstdadas",String.valueOf(list_sp.size()));
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