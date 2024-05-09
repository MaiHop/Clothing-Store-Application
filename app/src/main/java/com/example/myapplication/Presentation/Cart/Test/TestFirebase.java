package com.example.myapplication.Presentation.Cart.Test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Domain.Model.KichThuoc;
import com.example.myapplication.Domain.Model.KieuSP;
import com.example.myapplication.Domain.Model.LoaiSP;
import com.example.myapplication.Domain.Model.Mau;
import com.example.myapplication.Domain.Model.NhomSP;
import com.example.myapplication.Domain.Model.SanPham;
import com.example.myapplication.Presentation.Cart.ViewModel.CartVM;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.protobuf.Any;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TestFirebase extends AppCompatActivity {
    List<KieuSP> list_kieusp = new ArrayList<>();
    List<LoaiSP> list_loaisp = new ArrayList<>();
    List<NhomSP> list_nhomsp = new ArrayList<>();
    List<KichThuoc> list_kt = new ArrayList<>();
    List<Mau> list_mau = new ArrayList<>();
    KieuSP sp2 = new KieuSP();
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_firebase);


        getNhomSanPham();
        getListMau();

//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        FirebaseFirestore db1 = FirebaseFirestore.getInstance();
//
//        db1.collection("NhomSanPham").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                if (!queryDocumentSnapshots.isEmpty()) {
//                    List<DocumentSnapshot> list_doc = queryDocumentSnapshots.getDocuments();
//                    for (DocumentSnapshot doc : list_doc) {
//                        NhomSP nhom = doc.toObject(NhomSP.class);
//                        list_nhomsp.add(nhom);
//                    }
//                }
//                List<SanPham> list_sp = new ArrayList<>();
//                db.collection("SanPham").whereEqualTo("tenSanPham", "Quần Dài Xếp Ly Ống Rộng").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        if (!queryDocumentSnapshots.isEmpty()) {
//                            List<DocumentSnapshot> list_doc = queryDocumentSnapshots.getDocuments();
//                            String id = FirebaseFirestore.getInstance().collection("SanPham").document().getId();
//                            for (DocumentSnapshot doc : list_doc) {
//                                java.util.Date date = new java.util.Date();
//                                SanPham sanpham = doc.toObject(SanPham.class);
//                                sanpham.setNgayTao(date);
//                                sanpham.setNhomSanPham(list_nhomsp.get(0));
//                                sanpham.setLoaiSanPham(list_nhomsp.get(0).getListLoaiSP().get(8));
//                                sanpham.setKieuSanPham(list_nhomsp.get(0).getListLoaiSP().get(8).getListKieuSP().get(7));
//
//                                FirebaseFirestore.getInstance().collection("SanPham").add(sanpham).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                    @Override
//                                    public void onSuccess(DocumentReference documentReference) {
//                                        Toast.makeText(TestFirebase.this, "OK", Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//                            }
//                        }
//                    }
//                });
//            }
//        });










    }

    private void getNhomSanPham() {
        FirebaseFirestore.getInstance().collection("NhomSanPham").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> list_doc = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot doc : list_doc) {
                        NhomSP nhom = doc.toObject(NhomSP.class);
                        list_nhomsp.add(nhom);
                    }
                }
                getListKichThuoc();
            }
        });
    }

    private void getListKichThuoc() {
        FirebaseFirestore.getInstance().collection("KichThuoc").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> list_doc = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot doc : list_doc) {
                        KichThuoc kt = new KichThuoc();
                        kt.setId(doc.getId());
                        kt.setTen(doc.getString("Ten"));
                        list_kt.add(kt);
                    }
                }
                addSanPham();
            }
        });
    }

    private void getListMau() {
        Mau m1 = new Mau();
        m1.setId("00");
        m1.setTen("White");
        m1.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F00_White.jpg?alt=media&token=e292099f-dc37-4564-a0c4-bac4321ccaa9");

        Mau m2 = new Mau();
        m2.setId("09");
        m2.setTen("Black");
        m2.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F09_Black.jpg?alt=media&token=4340cb1d-d378-4eb8-9d8c-c2e9b37f8815");
//
        Mau m3 = new Mau();
        m3.setId("05");
        m3.setTen("Gray");
        m3.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F05_Gray.jpg?alt=media&token=c1aa326c-0049-437b-b4f3-f00e74880b8f");

        Mau m4 = new Mau();
        m4.setId("56");
        m4.setTen("Olive");
        m4.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F56_Olive.jpg?alt=media&token=936438bf-3a72-457e-b0ec-d99d4c5e552e");

//        Mau m5 = new Mau();
//        m5.setId("69");
//        m5.setTen("Blue");
//        m5.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F69_Blue.jpg?alt=media&token=a1e96b92-faab-4607-9cb1-d7e05a6bcfe7");

//        Mau m6 = new Mau();
//        m6.setId("70");
//        m6.setTen("Navy");
//        m6.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F70_Navy.jpg?alt=media&token=348d12a0-1086-45a4-9346-2b3a66ef1e8e");
//
//        Mau m7 = new Mau();
//        m7.setId("38");
//        m7.setTen("Dark Brown");
//        m7.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F38_DarkBrown.jpg?alt=media&token=fdbd61e5-2f6a-4caf-826e-6e1307d175d9");
//
//        Mau m8 = new Mau();
//        m8.setId("59");
//        m8.setTen("Dark Green");
//        m8.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F59_DarkGreen.jpg?alt=media&token=6b4e7033-0dd8-4452-aa18-e419e998ac7b");
//
//        Mau m9 = new Mau();
//        m9.setId("62");
//        m9.setTen("Blue");
//        m9.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F62_Blue.jpg?alt=media&token=0f4ff010-e9fc-47b5-bfa0-cc042d35ce2c");

//        Mau m10 = new Mau();
//        m10.setId("66");
//        m10.setTen("Blue");
//        m10.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F66_Blue.jpg?alt=media&token=03f04723-205a-4b59-aa5f-1af1b5f940a3");
//
//        Mau m11 = new Mau();
//        m11.setId("67");
//        m11.setTen("Blue");
//        m11.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F67_Blue.jpg?alt=media&token=543e8afd-e524-4acf-9bc5-dda1511823d8");

        list_mau.add(m1);
        list_mau.add(m2);
        list_mau.add(m3);
        list_mau.add(m4);
//        list_mau.add(m5);
//        list_mau.add(m6);
//        list_mau.add(m7);
//        list_mau.add(m8);
//        list_mau.add(m9);
//        list_mau.add(m10);
//        list_mau.add(m11);
    }


    private void addSanPham() {
        List<String> list_img = new ArrayList<>();
        list_img.add("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/sanpham%2Fvngoods_01_464148.jpg?alt=media&token=ef205cc0-a94e-4b43-90f8-07559b238a03");
        list_img.add("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/sanpham%2Fvngoods_09_464148.jpg?alt=media&token=64fb1180-7e71-475d-b984-84e276cf75ea");
        list_img.add("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/sanpham%2Fvngoods_05_464148.jpg?alt=media&token=6353a24b-f011-4c90-a3fd-b6952233ab79");
        list_img.add("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/sanpham%2Fvngoods_56_464148.jpg?alt=media&token=374a3d56-74d7-45c7-bb31-2291ef2ed70d");
        String id = FirebaseFirestore.getInstance().collection("SanPham").document().getId();
        for(int i =0 ; i<list_img.size();i++){
            for (KichThuoc kts : list_kt) {
                java.util.Date date = new java.util.Date();

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                SanPham sanpham = new SanPham();
                sanpham.setIdSanPham(id);
                sanpham.setImageUrl(list_img.get(i));
                sanpham.setTenSanPham("Quần Leggings Siêu Co Giãn");
                sanpham.setGiaban(588);
                sanpham.setSoLuong(100);
                sanpham.setSoLuongBan(0);
                sanpham.setThongTin("Chất liệu:\nVẢI\n" +
                        "[01 OFF WHITE] 52% Bông, 33% Polyeste, 15% Elastan [05 GRAY, 09 BLACK, 34 BROWN, 56 OLIVE, 58 DARK GREEN] 51% Bông, 33% Polyeste, 16% Elastan\n" +
                        "HƯỚNG DẪN GIẶT\n" +
                        "Giặt máy nước lạnh, Giặt khô, Không sấy khô\n" +
                        "- Những hình ảnh sản phẩm có thể bao gồm những màu không có sẵn.\n" +
                        "- Được nâng cấp lên loại vải mềm, siêu co giãn để mang lại sự thoải mái và tự do khi vận động.\n" +
                        "- Thiết kế thời trang với các nút bấm, đường may và kích thước túi sau được thiết kế tỉ mỉ.\n" +
                        "- Thắt lưng co giãn hoàn toàn.\n" +
                        "- Có vòng đai để đeo thắt lưng.");
                sanpham.setNgayTao(date);
                sanpham.setNhomSanPham(list_nhomsp.get(0));
                sanpham.setLoaiSanPham(list_nhomsp.get(0).getListLoaiSP().get(8));
                sanpham.setKieuSanPham(list_nhomsp.get(0).getListLoaiSP().get(8).getListKieuSP().get(6));
                sanpham.setMau(list_mau.get(i));

                sanpham.setKichThuoc(kts);
                db.collection("SanPham").add(sanpham).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(TestFirebase.this, "OK", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }



    }


}