package com.example.myapplication.Presentation.Cart.Test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Domain.Model.DonHangChiTiet;
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


//        getNhomSanPham();
//        getListMau();
        List<SanPham> list_sp = new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestore db1 = FirebaseFirestore.getInstance();
        db.collection("SanPham").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> list_doc = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot doc : list_doc) {
                        SanPham sp = doc.toObject(SanPham.class);
                        sp.setId(doc.getId());
                        list_sp.add(sp);
                    }
                }
                List<DonHangChiTiet> list= new ArrayList<>();
                DonHangChiTiet ct1 = new DonHangChiTiet();
                ct1.setSanPham(list_sp.get(0));
                ct1.setSoLuong(2);
                ct1.setThanhTien(list_sp.get(0).getGiaban()*ct1.getSoLuong());
                ct1.setThanhTienKhuyenMai(0);

                DonHangChiTiet ct2 = new DonHangChiTiet();
                ct2.setSanPham(list_sp.get(1));
                ct2.setSoLuong(2);
                ct2.setThanhTien(list_sp.get(1).getGiaban()*ct1.getSoLuong());
                ct2.setThanhTienKhuyenMai(0);

                DonHangChiTiet ct3 = new DonHangChiTiet();
                ct3.setSanPham(list_sp.get(2));
                ct3.setSoLuong(2);
                ct3.setThanhTien(list_sp.get(2).getGiaban()*ct1.getSoLuong());
                ct3.setThanhTienKhuyenMai(0);

                DonHangChiTiet ct4 = new DonHangChiTiet();
                ct4.setSanPham(list_sp.get(3));
                ct4.setSoLuong(2);
                ct4.setThanhTien(list_sp.get(3).getGiaban()*ct1.getSoLuong());
                ct4.setThanhTienKhuyenMai(0);

                DonHangChiTiet ct5 = new DonHangChiTiet();
                ct5.setSanPham(list_sp.get(4));
                ct5.setSoLuong(2);
                ct5.setThanhTien(list_sp.get(4).getGiaban()*ct1.getSoLuong());
                ct5.setThanhTienKhuyenMai(0);

                list.add(ct1);
                list.add(ct2);
                list.add(ct3);
                list.add(ct4);
                list.add(ct5);

                for(DonHangChiTiet ct : list){
                    db1.collection("DonHangChiTiet").add(ct).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(TestFirebase.this, "OK", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

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
//                NhomSP nhomSP = list_nhomsp.get(1);
//                LoaiSP loaiSP = list_nhomsp.get(1).getListLoaiSP().get(3);
//                KieuSP kieuSP = list_nhomsp.get(1).getListLoaiSP().get(3).getListKieuSP().get(7);
//                FirebaseFirestore db = FirebaseFirestore.getInstance();
//                FirebaseFirestore db1 = FirebaseFirestore.getInstance();
//                db.collection("SanPham").whereEqualTo("kieuSanPham.ten",kieuSP.getTen()).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        if (!queryDocumentSnapshots.isEmpty()) {
//                            List<DocumentSnapshot> list_doc = queryDocumentSnapshots.getDocuments();
//                            for (DocumentSnapshot doc : list_doc) {
//                                java.util.Date date = new java.util.Date();
//                                SanPham sp = doc.toObject(SanPham.class);
//                                sp.setNhomSanPham(nhomSP);
//                                sp.setLoaiSanPham(loaiSP);
//                                sp.setKieuSanPham(kieuSP);
//                                sp.setNgayTao(date);
//                                db1.collection("SanPham").add(sp).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                    @Override
//                                    public void onSuccess(DocumentReference documentReference) {
//                                            Toast.makeText(TestFirebase.this,"OK", Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//
//                            }
//                        }
//                    }
//                });
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
                addSanPham_V2();
            }
        });
    }

    private  void addSanPham_V2(){
        NhomSP nhomSP = list_nhomsp.get(3);
        LoaiSP loaiSP = list_nhomsp.get(3).getListLoaiSP().get(1);
        KieuSP kieuSP = list_nhomsp.get(3).getListLoaiSP().get(1).getListKieuSP().get(4);


//        List<Mau> list_m_1 = new ArrayList<>();
////        list_m_1.add(new Mau("00","White","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F00_White.jpg?alt=media&token=e292099f-dc37-4564-a0c4-bac4321ccaa9"));
////        list_m_1.add(new Mau("09","Black","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F09_Black.jpg?alt=media&token=4340cb1d-d378-4eb8-9d8c-c2e9b37f8815"));
////        list_m_1.add(new Mau("01","Gray","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F01_Gray.jpg?alt=media&token=12a52472-0553-44ea-a2a2-1aa5d1e62534"));
////        list_m_1.add(new Mau("38","Brown","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F38_Brown.jpg?alt=media&token=cad41440-5780-473c-9aa3-ec0f5f8f39ca"));
////        list_m_1.add(new Mau("41","Yellow","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F45_Yellow.jpg?alt=media&token=9fd2bfa8-4aa0-47d7-a494-b2857fccc238"));
//        list_m_1.add(new Mau("34","Khaki","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F34_Khaki.jpg?alt=media&token=0b4eb3f5-14ed-44e2-b437-41fa2a6d93ce"));
//        list_m_1.add(new Mau("70","Blue","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F70_Blue.jpg?alt=media&token=ea1561a6-1b93-4e5e-ab64-ca99a06dfe82"));
//        List<String> list_img_1 = new ArrayList<>();
//        list_img_1.add("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/sanpham%2Fgoods_33_471166001.jpg?alt=media&token=3ac59403-8030-4770-8d7a-d12ae12e4bc1");
//        list_img_1.add("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/sanpham%2Fgoods_69_471166001.jpg?alt=media&token=74958ee3-3e86-426e-b333-caf9bcbfc6ad");
//        String ten_sp_1 ="Áo Thun In Họa Tiết Ngắn Tay";
//        double giaban_1 =196;
//        String thongtin_1 =
//        "Chất liệu:\nVẢI\n" +
//        "Thân: 100% Bông/ Bo: 73% Bông, 27% Polyeste\n" +
//                "HƯỚNG DẪN GIẶT\n" +
//                "Giặt máy nước lạnh, Không giặt khô, Sấy khô ở nhiệt độ thấp\n" +
//                "- Những hình ảnh sản phẩm có thể bao gồm những màu không có sẵn.\n" +
//        "UNIQLO and Marimekko are pleased to announce the new limited-edition collection just in time for a joyful summer sun. The new collection offers a wide array of breezy, comfortable dress, cut and sewn and skirt made in cotton and linen, along with hats, shoes, and bags for easy coordination. This collection features Marimekko’s world-renowned prints: Melooni (melon), Ruukku (pot) by Maija Isola, Lirinä (sound of gurgling water), Asema (station) by Pentti Rinta, along with Demeter by Katsuji Wakisaka and Galleria (gallery) by Vuokko Eskolin-Nurmesniemi. These vibrant and colorful patterns, full of the feeling of summer fun, are available for women, kids, and babies.\n" +
//                "\n" +
//                "- Hypoallergenic plastic snap-fasteners. *Note: May not protect against all allergies.\n" +
//                "- Comfortable, soft fabric.\n" +
//                "- Quality care label inside the garment on the left side.\n" +
//                "- Combines Marimekko’s signature bold print with an easy-to-wear silhouette.\n" +
//                "- 70-90 cm sizes have snap button openings at the shoulders.\n" +
//                "- 100-110 cm sizes do not have snap buttons at the shoulders.";
//        SaveToFireStore("1",list_img_1,list_m_1,list_kt,ten_sp_1,giaban_1,thongtin_1,nhomSP,loaiSP,kieuSP);

//        List<Mau> list_m_2 = new ArrayList<>();
//        list_m_2.add(new Mau("00","White","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F00_White.jpg?alt=media&token=e292099f-dc37-4564-a0c4-bac4321ccaa9"));
////        list_m_2.add(new Mau("09","Black","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F09_Black.jpg?alt=media&token=4340cb1d-d378-4eb8-9d8c-c2e9b37f8815"));
////        list_m_2.add(new Mau("08","Dark Gray", "https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F08_DrarkGray.jpg?alt=media&token=240e25ac-d00b-4965-ae6a-0bb63a3ea5fd"));
////        list_m_2.add(new Mau("30","Natural","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F30_Natural.jpg?alt=media&token=47f82600-755b-481b-a8d3-acf304ccbd9b"));
////        list_m_2.add(new Mau("56","Olive","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F56_Olive.jpg?alt=media&token=936438bf-3a72-457e-b0ec-d99d4c5e552e"));
//        List<String> list_img_2 = new ArrayList<>();
//        list_img_2.add("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/sanpham%2Fgoods_00_464637.jpg?alt=media&token=313f1062-8a70-4299-aa06-59f815814bd7");
//        String ten_sp_2 ="Áo Lót Ba Lỗ Vải Cotton Mắt Lưới 2 Chiếc";
//        double giaban_2 =195;
//        String thongtin_2 =
//                "Chất liệu:\nVẢI\n" +
//                "100% Bông\n" +
//                "HƯỚNG DẪN GIẶT\n" +
//                "Giặt máy nước lạnh, Không giặt khô, Sấy khô ở nhiệt độ thấp\n" +
//                "- Những hình ảnh sản phẩm có thể bao gồm những màu không có sẵn.\n" +
//                "- Chất liệu vải 100% cotton được làm từ những sợi siêu mịn mang lại cảm giác mềm mại, nhẹ nhàng.\n" +
//                        "- Lưới thoáng khí với kết cấu bền bỉ có thể chịu được việc giặt nhiều lần.\n" +
//                        "- Đường may phẳng nhẹ nhàng trên làn da mỏng manh của bé.\n" +
//                        "- Đường khâu màu bên trong đường viền cổ áo giúp giữ mặt phải của trang phục.\n" +
//                        "- Bộ 2 màu trơn tiện lợi.";
//        SaveToFireStore("2",list_img_2,list_m_2,list_kt,ten_sp_2,giaban_2,thongtin_2,nhomSP,loaiSP,kieuSP);

        List<Mau> list_m_3 = new ArrayList<>();
        list_m_3.add(new Mau("00","White","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F00_White.jpg?alt=media&token=e292099f-dc37-4564-a0c4-bac4321ccaa9"));
//        list_m_3.add(new Mau("09","Black","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F09_Black.jpg?alt=media&token=4340cb1d-d378-4eb8-9d8c-c2e9b37f8815"));
//        list_m_3.add(new Mau("41","Yellow","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F41_Yellow.jpg?alt=media&token=f81e92ed-dd50-496e-bb97-5f6bdb77b5c7"));
        list_m_3.add(new Mau("69","Navy","https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F69_Navy.jpg?alt=media&token=f6b5529d-2575-4372-9679-14939b3fb623"));
        List<String> list_img_3 = new ArrayList<>();
        list_img_3.add("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/sanpham%2Fgoods_00_454969.jpg?alt=media&token=1f38d22d-f167-4948-a731-e2bb24724331");
        list_img_3.add("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/sanpham%2Fgoods_68_454969.jpg?alt=media&token=cada6655-e2ae-4b98-bd23-e2677b9cc389");
        String ten_sp_3 ="AIRism Áo Khoác Chống UV Dài Tay (Chống Nắng)";
        double giaban_3 =391;
        String thongtin_3 =
                "Chất liệu:\nVẢI\n" +
                        "Thân: 70% Bông, 30% Polyeste/ Bo: 55% Bông, 45% Polyeste\n" +
                        "HƯỚNG DẪN GIẶT\n" +
                        "Giặt máy nước lạnh, Giặt khô, Không sấy khô\n" +
                        "- Những hình ảnh sản phẩm có thể bao gồm những màu không có sẵn.\n" +
                        "- 'AIRism' cho cảm giác thoải mái tươi mát lâu dài.\n" +
                        "- Công nghệ chống tia cực tím.\n" +
                        "- Vải lưới thoáng khí.\n" +
                        "- Bao gồm một miếng bảo vệ cằm để bảo vệ mặt khỏi dây kéo.\n" +
                        "- Có nhãn tên và móc treo ở cổ.\n" +
                        "- Nhãn chăm sóc chất lượng bên trong quần áo ở phía bên trái.\n" +
                        "- Vải lưới UV 'AIRism' nhẹ và chống nhăn.\n" +
                        "- UPF40.";
        SaveToFireStore("3",list_img_3,list_m_3,list_kt,ten_sp_3,giaban_3,thongtin_3,nhomSP,loaiSP,kieuSP);

    }
    private void SaveToFireStore(String num,List<String> list_img ,List<Mau> list_m, List<KichThuoc> list_k, String ten_sp, double giaban, String thongtin, NhomSP nhomSP, LoaiSP loaiSP, KieuSP kieuSP){
        String id = FirebaseFirestore.getInstance().collection("SanPham").document().getId();
        for(int i =0 ; i<list_img.size();i++){
            for (KichThuoc kts : list_k) {
                java.util.Date date = new java.util.Date();

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                SanPham sanpham = new SanPham();
                sanpham.setIdSanPham(id);
                sanpham.setImageUrl(list_img.get(i));
                sanpham.setTenSanPham(ten_sp);
                sanpham.setGiaban(giaban);
                sanpham.setSoLuong(100);
                sanpham.setSoLuongBan(0);
                sanpham.setThongTin(thongtin);
                sanpham.setNgayTao(date);
                sanpham.setNhomSanPham(nhomSP);
                sanpham.setLoaiSanPham(loaiSP);
                sanpham.setKieuSanPham(kieuSP);
                sanpham.setMau(list_m.get(i));

                sanpham.setKichThuoc(kts);
                db.collection("SanPham").add(sanpham).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(TestFirebase.this, "OK "+num, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }
    }

    private void addSanPham() {
        List<String> list_img = new ArrayList<>();
        list_img.add("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/sanpham%2Fvngoods_09_467544.jpg?alt=media&token=667d1c54-13d9-42ba-aee5-4e6e7187b627");
        list_img.add("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/sanpham%2Fvngoods_02_467544.jpg?alt=media&token=85a29324-ea87-4cb0-ac86-a61362b7568e");
        list_img.add("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/sanpham%2Fvngoods_56_467544.jpg?alt=media&token=3f0f3b71-21af-4a3f-a397-95fc1be07fe0");
        String id = FirebaseFirestore.getInstance().collection("SanPham").document().getId();
        for(int i =0 ; i<list_img.size();i++){
            for (KichThuoc kts : list_kt) {
                java.util.Date date = new java.util.Date();

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                SanPham sanpham = new SanPham();
                sanpham.setIdSanPham(id);
                sanpham.setImageUrl(list_img.get(i));
                sanpham.setTenSanPham("DRY-EX Áo Thun Ngắn Tay");
                sanpham.setGiaban(391);
                sanpham.setSoLuong(100);
                sanpham.setSoLuongBan(0);
                sanpham.setThongTin("Chất liệu:\nVẢI\n" +
                        "100% Polyeste ( 100% Sử Dụng Sợi Polyeste Tái Chế )\n" +
                        "HƯỚNG DẪN GIẶT\n" +
                        "Giặt máy nước lạnh, Giặt khô, Không sấy khô\n" +
                        "- Những hình ảnh sản phẩm có thể bao gồm những màu không có sẵn.\n" +
                        "- Áo thun cổ tròn ngắn tay nam được làm từ những sợi vải mảnh, mỏng nhẹ, thoáng khí, mang lại cảm giác mịn màng và nhẹ hơn so với áo thun DRY-EX thông thường.\n" +
                        "- Chất liệu vải dệt kim thoáng khí với họa tiết sọc dọc giúp lưu thông khí, mang lại cảm giác thoải mái, khô thoáng suốt cả ngày.\n" +
                        "- Ngoài ra, chất liệu vải của chiếc áo thun này còn có khả năng nhanh chóng thấm hút mồ hôi, tạo cảm giác khô ráo và mịn màng, kéo dài suốt ngày.\n" +
                        "- Tay áo được thiết kế đặc biệt, mang lại cảm giác mượt mà cùng đường may tinh tế\n" +
                        "- Cổ áo thun nam này được may kỹ càng để tạo sự thoải mái, không gây gò bó cho người sử dụng.");
                sanpham.setNgayTao(date);
                sanpham.setNhomSanPham(list_nhomsp.get(1));
                sanpham.setLoaiSanPham(list_nhomsp.get(0).getListLoaiSP().get(1));
                sanpham.setKieuSanPham(list_nhomsp.get(0).getListLoaiSP().get(1).getListKieuSP().get(1));
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