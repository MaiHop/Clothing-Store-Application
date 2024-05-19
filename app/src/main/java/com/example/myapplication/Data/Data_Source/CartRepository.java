//package com.example.myapplication.Data.Data_Source;
//
//import com.example.myapplication.Model.DiaChi;
//import com.example.myapplication.Model.DonHang;
//import com.example.myapplication.Model.DonHangChiTiet;
//import com.example.myapplication.Model.DonHangQuaTrinh;
//import com.example.myapplication.Model.KhachHang;
//import com.example.myapplication.Model.KhuyenMai;
//import com.example.myapplication.Model2.KichThuoc;
//import com.example.myapplication.Model2.KieuSP;
//import com.example.myapplication.Model.LoaiSP;
//import com.example.myapplication.Model2.Mau;
//import com.example.myapplication.Model2.NhomSP;
//import com.example.myapplication.Model2.SanPham;
//import com.example.myapplication.Model.ThanhToan;
//import com.example.myapplication.Model.VanChuyen;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//public class CartRepository {
//    List<NhomSP> listNhomSP;
//    List<LoaiSP> listLoaiSP;
//    List<KieuSP> listKieuSP;
//    List<KichThuoc> listsize;
//    List<Mau> listcolor;
//
//
//    public CartRepository() {
//    }
//    public List<DonHang> getListDH(){
//        List<DonHang> list = new ArrayList<>();
//        List<DiaChi> listdc = getListAddress();
//        List<VanChuyen> listvc = getListDelivery();
//        List<ThanhToan> listtt = getListMP();
//        List<KhuyenMai> listkm = getListKhuyenMai();
//        List<DonHangQuaTrinh> listQT = getListDHQT();
//        List<DonHangChiTiet> listdhct = getGioHang();
//        List<DonHangChiTiet> list_ct1 = new ArrayList<>();
//        List<DonHangChiTiet> list_ct2 = new ArrayList<>();
//        List<DonHangChiTiet> list_ct3 = new ArrayList<>();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//
//        SanPham sp1 = new SanPham();
//        sp1.setTenSanPham("Urban long shirt");
//        sp1.setGiaban(120);
//
//        SanPham sp2 = new SanPham();
//        sp2.setTenSanPham("Tee shirt for summer");
//        sp2.setGiaban(50);
//
//        SanPham sp3 = new SanPham();
//        sp3.setTenSanPham("Short");
//        sp3.setGiaban(100);
//
//        DonHangChiTiet dhct1 = new DonHangChiTiet();
//        dhct1.setSanPham(sp1);
//        list_ct1.add(dhct1);
//
//        DonHangChiTiet dhct2 = new DonHangChiTiet();
//        dhct2.setSanPham(sp2);
//        list_ct2.add(dhct2);
//
//        DonHangChiTiet dhct3 = new DonHangChiTiet();
//        dhct3.setSanPham(sp3);
//        list_ct3.add(dhct3);
//
//        DonHang dh1 = new DonHang();
//        dh1.setListDonHangChiTiet(list_ct1);
//        dh1.setTrangThai("Active");
//        dh1.setphiDichVu(50.0);
//        try {
//            dh1.setNgayThanhToan(formatter.parse("11/05/2024"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        dh1.setDiachi(listdc.get(0));
//        dh1.setVanchuyen(listvc.get(0));
//        dh1.setThanhToan(listtt.get(0));
//        dh1.setKhuyenmai(listkm.get(0));
//        dh1.setListDonHangChiTiet(listdhct);
//        dh1.setPhiGiaoHang(200);
//        dh1.setThue(0.1);
//        dh1.setListdonhangqt(listQT);
//
//        DonHang dh2 = new DonHang();
//        dh2.setListDonHangChiTiet(list_ct2);
//        dh2.setTrangThai("Completed");
//        try {
//            dh2.setNgayThanhToan(formatter.parse("20/03/2024"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        dh2.setDiachi(listdc.get(0));
//        dh2.setVanchuyen(listvc.get(0));
//        dh2.setThanhToan(listtt.get(0));
//        dh2.setKhuyenmai(listkm.get(0));
//        dh2.setListDonHangChiTiet(listdhct);
//        dh2.setPhiGiaoHang(200);
//        dh2.setThue(0.1);
//        dh2.setListdonhangqt(listQT);
//
//        DonHang dh3 = new DonHang();
//        dh3.setListDonHangChiTiet(list_ct3);
//        dh3.setTrangThai("Canceled");
//        try {
//            dh3.setNgayThanhToan(formatter.parse("20/03/2023"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        list.add(dh1);
//        list.add(dh2);
//        list.add(dh3);
//
//        return list;
//    }
//
//    public List<DonHangQuaTrinh> getListDHQT(){
//        List<DonHangQuaTrinh> list = new ArrayList<>();
//        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//
//        DonHangQuaTrinh qt1 = new DonHangQuaTrinh();
//        try {
//            qt1.setNgay(formatter.parse("20/03/2024"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        qt1.setMoTa("08:60 AM");
//        qt1.setTrangThai("Đang giao hàng");
//
//        DonHangQuaTrinh qt2 = new DonHangQuaTrinh();
//        try {
//            qt2.setNgay(formatter.parse("18/03/2024"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        qt2.setMoTa("11:20 AM");
//        qt2.setTrangThai("Đã thanh toán");
//
//        DonHangQuaTrinh qt3 = new DonHangQuaTrinh();
//        try {
//            qt3.setNgay(formatter.parse("17/03/2024"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        qt3.setMoTa("11:30 PM");
//        qt3.setTrangThai("Chưa thanh toán");
//
//        list.add(qt1);
//        list.add(qt2);
//        list.add(qt3);
//        return list;
//    }
//    public List<KichThuoc> getListSize(){
//        List<KichThuoc> list = new ArrayList<>();
//        KichThuoc kt1 = new KichThuoc();
//        kt1.setId("1");
//        kt1.setTen("XS");
//        KichThuoc kt2 = new KichThuoc();
//        kt2.setId("2");
//        kt2.setTen("S");
//        KichThuoc kt3 = new KichThuoc();
//        kt3.setId("3");
//        kt3.setTen("M");
//        KichThuoc kt4 = new KichThuoc();
//        kt4.setId("4");
//        kt4.setTen("L");
//        KichThuoc kt5 = new KichThuoc();
//        kt5.setId("5");
//        kt5.setTen("XL");
//        KichThuoc kt6 = new KichThuoc();
//        kt6.setId("6");
//        kt6.setTen("XXL");
//        list.add(kt1);
//        list.add(kt2);
//        list.add(kt3);
//        list.add(kt4);
//        list.add(kt5);
//        list.add(kt6);
//        return list;
//    }
//    public List<Mau> getListMau(){
//        List<Mau> list = new ArrayList<>();
//        Mau m1 = new Mau();
//        m1.setId("1");
//        m1.setTen("GRAY");
//        m1.setImgUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//
//        Mau m2 = new Mau();
//        m2.setId("2");
//        m2.setTen("DARK GRAY");
//        m2.setImgUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//
//        Mau m3 = new Mau();
//        m3.setId("3");
//        m3.setTen("BLACK");
//        m3.setImgUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//
//        Mau m4 = new Mau();
//        m4.setId("4");
//        m4.setTen("NAVY");
//        m4.setImgUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//
//        Mau m5 = new Mau();
//        m5.setId("5");
//        m5.setTen("RED");
//        m5.setImgUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//
//        Mau m6 = new Mau();
//        m6.setId("6");
//        m6.setTen("BLUE");
//        m6.setImgUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//        list.add(m1);
//        list.add(m2);
//        list.add(m3);
//        list.add(m4);
//        list.add(m5);
//        list.add(m6);
//        return list;
//    }
//    public List<KieuSP> getListKieuSP(){
//        List<KieuSP> list = new ArrayList<>();
//        KieuSP  kieuSP1 = new KieuSP();
//        kieuSP1.setId("1");
//        kieuSP1.setTen("ÁO KHOÁC MIRACLE AIR");
//        KieuSP  kieuSP2 = new KieuSP();
//        kieuSP2.setId("2");
//        kieuSP2.setTen("ÁO KHOÁC & ÁO BLAZER");
//        list.add(kieuSP1);
//        list.add(kieuSP2);
//
//        return list;
//    }
//    public List<LoaiSP> getListLoaiSP(){
//        List<LoaiSP> list = new ArrayList<>();
//        LoaiSP loaiSP = new LoaiSP();
//        loaiSP.setId("1");
//        loaiSP.setTen("Đồ mặc ngoài");
//        loaiSP.setListKieuSP(this.getListKieuSP());
//        list.add(loaiSP);
//        return list;
//    }
//    public List<NhomSP> getListNhomSP(){
//        List<NhomSP> list = new ArrayList<>();
//
//        NhomSP nhomSP = new NhomSP();
//        nhomSP.setId("1");
//        nhomSP.setTen("Nam");
//        nhomSP.setImageURL("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
//        nhomSP.setListLoaiSP(this.getListLoaiSP());
//
//        NhomSP nhomSP1 = new NhomSP();
//        nhomSP1.setId("2");
//        nhomSP1.setTen("Nữ");
//        nhomSP1.setImageURL("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
//        nhomSP1.setListLoaiSP(this.getListLoaiSP());
//
//
//
//        list.add(nhomSP);
//        list.add(nhomSP1);
//
//
//        return list;
//    }
//    public List<SanPham> getSanPham(){
//        List<SanPham> list = new ArrayList<>();
//
//        listNhomSP = this.getListNhomSP();
//        listLoaiSP = this.getListLoaiSP();
//        listKieuSP = this.getListKieuSP();
//        listsize = this.getListSize();
//        listcolor = this.getListMau();
//
//        SanPham sp1 = new SanPham();
//        sp1.setIdSanPham("1");
//        sp1.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
//        sp1.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
//        sp1.setGiaban(120);
//        sp1.setSoLuong(10);
//        sp1.setSoLuongBan(12);
//        sp1.setNhomSanPham(listNhomSP.get(0));
//        sp1.setLoaiSanPham(listLoaiSP.get(0));
//        sp1.setKieuSanPham(listKieuSP.get(0));
//        sp1.setKichThuoc(listsize.get(0));
//        sp1.setMau(listcolor.get(0));
//        sp1.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");
//
//        SanPham sp2 = new SanPham();
//        sp2.setIdSanPham("2");
//        sp2.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
//        sp2.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
//        sp2.setGiaban(121);
//        sp2.setSoLuong(20);
//        sp2.setSoLuongBan(12);
//        sp2.setNhomSanPham(listNhomSP.get(1));
//        sp2.setLoaiSanPham(listLoaiSP.get(0));
//        sp2.setKieuSanPham(listKieuSP.get(0));
//        sp2.setKichThuoc(listsize.get(1));
//        sp2.setMau(listcolor.get(1));
//        sp2.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");
//
//        SanPham sp3 = new SanPham();
//        sp3.setIdSanPham("3");
//        sp3.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
//        sp3.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
//        sp3.setGiaban(122);
//        sp3.setSoLuong(30);
//        sp3.setSoLuongBan(12);
//        sp3.setNhomSanPham(listNhomSP.get(1));
//        sp3.setLoaiSanPham(listLoaiSP.get(0));
//        sp3.setKieuSanPham(listKieuSP.get(0));
//        sp3.setKichThuoc(listsize.get(1));
//        sp3.setMau(listcolor.get(2));
//        sp3.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");
//
//        SanPham sp4 = new SanPham();
//        sp4.setIdSanPham("4");
//        sp4.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
//        sp4.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
//        sp4.setGiaban(123);
//        sp4.setSoLuong(40);
//        sp4.setSoLuongBan(12);
//        sp4.setNhomSanPham(listNhomSP.get(0));
//        sp4.setLoaiSanPham(listLoaiSP.get(0));
//        sp4.setKieuSanPham(listKieuSP.get(0));
//        sp4.setKichThuoc(listsize.get(3));
//        sp4.setMau(listcolor.get(3));
//        sp4.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");
//
//        SanPham sp5 = new SanPham();
//        sp5.setIdSanPham("5");
//        sp5.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
//        sp5.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
//        sp5.setGiaban(124);
//        sp5.setSoLuong(50);
//        sp5.setSoLuongBan(12);
//        sp5.setNhomSanPham(listNhomSP.get(0));
//        sp5.setLoaiSanPham(listLoaiSP.get(0));
//        sp5.setKieuSanPham(listKieuSP.get(0));
//        sp5.setKichThuoc(listsize.get(3));
//        sp5.setMau(listcolor.get(4));
//        sp5.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");
//
//        SanPham sp6 = new SanPham();
//        sp6.setIdSanPham("6");
//        sp6.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
//        sp6.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
//        sp6.setGiaban(125);
//        sp6.setSoLuong(0);
//        sp6.setSoLuongBan(12);
//        sp6.setNhomSanPham(listNhomSP.get(0));
//        sp6.setLoaiSanPham(listLoaiSP.get(0));
//        sp6.setKieuSanPham(listKieuSP.get(0));
//        sp6.setKichThuoc(listsize.get(2));
//        sp6.setMau(listcolor.get(5));
//
//        sp6.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");
//
//        SanPham sp7 = new SanPham();
//        sp7.setIdSanPham("7");
//        sp7.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
//        sp7.setTenSanPham("Z");
//        sp7.setGiaban(126);
//        sp7.setSoLuong(0);
//        sp7.setSoLuongBan(12);
//        sp7.setNhomSanPham(listNhomSP.get(1));
//        sp7.setLoaiSanPham(listLoaiSP.get(0));
//        sp7.setKieuSanPham(listKieuSP.get(1));
//        sp7.setKichThuoc(listsize.get(2));
//        sp7.setMau(listcolor.get(5));
//        sp6.setMau(listcolor.get(1));
//        sp7.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");
//        list.add(sp1);
//        list.add(sp2);
//        list.add(sp3);
//        list.add(sp4);
//        list.add(sp5);
//        list.add(sp6);
//        list.add(sp7);
//        return list;
//    }
//
//    public List<DonHang> getListDonHang(){
//        List<DonHang> list_dh = new ArrayList<>();
//        List<DonHangChiTiet> list = this.getGioHang();
//        KhachHang kh =new KhachHang();
//        kh.setIdKhachHang("1");
//        kh.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLvMEg2PbVb_MVOChlQMhcg2G8A_LtTuXc4wVdqsbEcQ&s");
//        kh.setTen("Mr. Fresh");
//        kh.setEmail("mrfresh@gmail.com");
//        kh.setGioiTinh(0);
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//
//
//        DonHang dh1 = new DonHang();
//        dh1.setIdDonHang("1");
//        dh1.setKhachHang(kh);
//        dh1.setTongSoLuong(5);
//        dh1.setTrangThai("Cart");
//        dh1.setListDonHangChiTiet(list);
//
//        DonHang dh2 = new DonHang();
//        dh2.setIdDonHang("2");
//        dh2.setKhachHang(kh);
//        dh2.setTongSoLuong(0);
//        dh2.setTrangThai("Active");
//        dh2.setListDonHangChiTiet(null);
//
//        DonHang dh3 = new DonHang();
//        dh3.setIdDonHang("3");
//        dh3.setKhachHang(kh);
//        dh3.setTongSoLuong(0);
//        dh3.setTrangThai("Active");
//        dh3.setListDonHangChiTiet(null);
//
//        list_dh.add(dh1);
//        list_dh.add(dh2);
//        list_dh.add(dh3);
//        return list_dh;
//    }
//
//    public  List<DonHangChiTiet> getGioHang(){
//        List<DonHangChiTiet> list = new ArrayList<>();
//        CartRepository res = new CartRepository();
//        List<SanPham> listproduct = res.getSanPham();
//
//        DonHangChiTiet dh1 = new DonHangChiTiet();
//        dh1.setIdDonHang("1");
//        dh1.setSanPham(listproduct.get(0));
//        dh1.setSoLuong(1);
//        dh1.setThanhTien(listproduct.get(0).getGiaban()*dh1.getSoLuong());
//        dh1.setThanhTienKhuyenMai(0);
//        dh1.setChecked(true);
//
//        DonHangChiTiet dh2 = new DonHangChiTiet();
//        dh2.setIdDonHang("1");
//        dh2.setSanPham(listproduct.get(1));
//        dh2.setSoLuong(1);
//        dh2.setThanhTien(listproduct.get(1).getGiaban()*dh1.getSoLuong());
//        dh2.setThanhTienKhuyenMai(0);
//        dh2.setChecked(true);
//
//        DonHangChiTiet dh3 = new DonHangChiTiet();
//        dh3.setIdDonHang("1");
//        dh3.setSanPham(listproduct.get(2));
//        dh3.setSoLuong(1);
//        dh3.setThanhTien(listproduct.get(2).getGiaban()*dh1.getSoLuong());
//        dh3.setThanhTienKhuyenMai(0);
//        dh3.setChecked(true);
//
//        DonHangChiTiet dh4 = new DonHangChiTiet();
//        dh4.setIdDonHang("1");
//        dh4.setSanPham(listproduct.get(3));
//        dh4.setSoLuong(1);
//        dh4.setThanhTien(listproduct.get(3).getGiaban()*dh1.getSoLuong());
//        dh4.setThanhTienKhuyenMai(0);
//        dh4.setChecked(true);
//
//        DonHangChiTiet dh5 = new DonHangChiTiet();
//        dh5.setIdDonHang("1");
//        dh5.setSanPham(listproduct.get(6));
//        dh5.setSoLuong(1);
//        dh5.setThanhTien(listproduct.get(3).getGiaban()*dh1.getSoLuong());
//        dh5.setThanhTienKhuyenMai(0);
//        dh5.setChecked(true);
//
//        list.add(dh1);
//        list.add(dh2);
//        list.add(dh3);
//        list.add(dh4);
//        list.add(dh5);
//
//        return  list;
//    }
//
//     public List<DiaChi> getListAddress(){
//        List<DiaChi> list = new ArrayList<>();
//
//        DiaChi dc1 = new DiaChi();
//        dc1.setIdDiaChi("1");
//        dc1.setTenDiaChi("Home");
//        dc1.setDiaChiChinh(true);
//        dc1.setNguoiNhan("Trung Hậu");
//        dc1.setsDT("0765328458");
//        dc1.setDiaChi("155/33 Nguyễn Trãi");
//        dc1.setXacDinh(true);
//        dc1.setChecked(false);
//
//         DiaChi dc2 = new DiaChi();
//         dc2.setIdDiaChi("2");
//         dc2.setTenDiaChi("CC1");
//         dc2.setDiaChiChinh(false);
//         dc2.setNguoiNhan("Trung Hậu");
//         dc2.setsDT("0765328458");
//         dc2.setDiaChi("155/33 Nguyễn Trãi");
//         dc2.setXacDinh(true);
//         dc2.setChecked(false);
//
//         DiaChi dc3 = new DiaChi();
//         dc3.setIdDiaChi("3");
//         dc3.setTenDiaChi("CC2");
//         dc3.setDiaChiChinh(false);
//         dc3.setNguoiNhan("Trung Hậu");
//         dc3.setsDT("0765328458");
//         dc3.setDiaChi("155/33 Nguyễn Trãi");
//         dc3.setXacDinh(true);
//         dc3.setChecked(false);
//
//         list.add(dc1);
//         list.add(dc2);
//         list.add(dc3);
//         return list;
//     }
//
//     public List<VanChuyen> getListDelivery(){
//        List<VanChuyen> list = new ArrayList<>();
//
//        VanChuyen vc1 = new VanChuyen();
//        vc1.setId("1");
//        vc1.setTen("J&T Express");
//        vc1.setImageURL("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//        vc1.setNgayGiao("23 - 25 tháng 10 2024");
//        vc1.setGia(10);
//        vc1.setChecked(false);
//
//        VanChuyen vc2 = new VanChuyen();
//         vc2.setId("2");
//         vc2.setTen("J&T Express");
//         vc2.setImageURL("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//         vc2.setNgayGiao("23 - 25 tháng 10 2024");
//         vc2.setGia(10);
//         vc2.setChecked(false);
//
//        VanChuyen vc3 = new VanChuyen();
//         vc3.setId("3");
//         vc3.setTen("J&T Express");
//         vc3.setImageURL("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//         vc3.setNgayGiao("23 - 25 tháng 10 2024");
//         vc3.setGia(10);
//         vc3.setChecked(false);
//
//        list.add(vc1);
//        list.add(vc2);
//        list.add(vc3);
//
//        return list;
//     }
//
//     public List<ThanhToan> getListMP(){
//        List<ThanhToan> list = new ArrayList<>();
//
//        ThanhToan tt1 = new ThanhToan();
//        tt1.setIdThanhToan("1");
//        tt1.setTenThanhToan("Paypal");
//        tt1.setLoai("VISA");
//        tt1.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//        tt1.setChecked(false);
//
//        ThanhToan tt2 = new ThanhToan();
//        tt2.setIdThanhToan("2");
//        tt2.setTenThanhToan("Paypal");
//        tt2.setLoai("VISA");
//        tt2.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//        tt2.setChecked(false);
//
//        ThanhToan tt3 = new ThanhToan();
//        tt3.setIdThanhToan("3");
//        tt3.setTenThanhToan("Paypal");
//        tt3.setLoai("VISA");
//        tt3.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//        tt3.setChecked(false);
//
//        list.add(tt1);
//        list.add(tt2);
//        list.add(tt3);
//        return list;
//     }
//
//     public List<KhuyenMai> getListKhuyenMai(){
//        List<KhuyenMai> list = new ArrayList<>();
//
//        KhuyenMai km1 = new KhuyenMai();
//        km1.setIdKhuyenMai("1");
//        km1.setTenKhuyenMai("Deal hè");
//        km1.setNoiDung("Tặng 1 cái quần xì");
//        km1.setDieuKien("Mua 2 cái áo");
//        km1.setToiDaGiam("100");
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//         try {
//             km1.setHanSuDung(formatter.parse("10/02/2024"));
//         } catch (ParseException e) {
//             throw new RuntimeException(e);
//         }
//        km1.setTrangThai(false);
//        km1.setChecked(false);
//
//         KhuyenMai km2 = new KhuyenMai();
//         km2.setIdKhuyenMai("2");
//         km2.setTenKhuyenMai("Deal hè");
//         km2.setNoiDung("Tặng 1 cái quần xì");
//         km2.setDieuKien("Mua 2 cái áo");
//         km2.setToiDaGiam("200");
//
//         try {
//             km2.setHanSuDung(formatter.parse("10/02/2024"));
//         } catch (ParseException e) {
//             throw new RuntimeException(e);
//         }
//         km2.setTrangThai(false);
//         km2.setChecked(false);
//
//         KhuyenMai km3 = new KhuyenMai();
//         km3.setIdKhuyenMai("3");
//         km3.setTenKhuyenMai("Deal hè");
//         km3.setNoiDung("Tặng 1 cái quần xì");
//         km3.setDieuKien("Mua 2 cái áo");
//         km3.setToiDaGiam("300");
//
//         try {
//             km3.setHanSuDung(formatter.parse("10/02/2024"));
//         } catch (ParseException e) {
//             throw new RuntimeException(e);
//         }
//         km3.setTrangThai(false);
//         km3.setChecked(false);
//
//        list.add(km1);
//        list.add(km2);
//        list.add(km3);
//
//        return list;
//     }
//
//
//}
package com.example.myapplication.Data.Data_Source;

import com.example.myapplication.Model2.DiaChi;
import com.example.myapplication.Model2.DonHang;
import com.example.myapplication.Model2.DonHangChiTiet;
import com.example.myapplication.Model2.DonHangQuaTrinh;
import com.example.myapplication.Model2.KhachHang;
import com.example.myapplication.Model2.KhuyenMai;
import com.example.myapplication.Model2.KichThuoc;
import com.example.myapplication.Model2.KieuSP;
import com.example.myapplication.Model2.LoaiSP;
import com.example.myapplication.Model2.Mau;
import com.example.myapplication.Model2.NhomSP;
import com.example.myapplication.Model2.SanPham;
import com.example.myapplication.Model2.ThanhToan;
import com.example.myapplication.Model2.VanChuyen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartRepository {
    List<NhomSP> listNhomSP;
    List<LoaiSP> listLoaiSP;
    List<KieuSP> listKieuSP;
    List<KichThuoc> listsize;
    List<Mau> listcolor;


    public CartRepository() {
    }

    public List<KichThuoc> getListSize(){
        List<KichThuoc> list = new ArrayList<>();
        KichThuoc kt1 = new KichThuoc();
        kt1.setIdKichThuoc(1);
        kt1.setTen("XS");
        KichThuoc kt2 = new KichThuoc();
        kt2.setIdKichThuoc(2);
        kt2.setTen("S");
        KichThuoc kt3 = new KichThuoc();
        kt3.setIdKichThuoc(3);
        kt3.setTen("M");
        KichThuoc kt4 = new KichThuoc();
        kt4.setIdKichThuoc(4);
        kt4.setTen("L");
        KichThuoc kt5 = new KichThuoc();
        kt5.setIdKichThuoc(5);
        kt5.setTen("XL");
        KichThuoc kt6 = new KichThuoc();
        kt6.setIdKichThuoc(6);
        kt6.setTen("XXL");
        list.add(kt1);
        list.add(kt2);
        list.add(kt3);
        list.add(kt4);
        list.add(kt5);
        list.add(kt6);
        return list;
    }
    public List<Mau> getListMau(){
        List<Mau> list = new ArrayList<>();
        Mau m1 = new Mau();
        m1.setIdMau(1);
        m1.setTen("GRAY");
        m1.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");

        Mau m2 = new Mau();
        m2.setIdMau(2);
        m2.setTen("DARK GRAY");
        m2.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");

        Mau m3 = new Mau();
        m3.setIdMau(3);
        m3.setTen("BLACK");
        m3.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");

        Mau m4 = new Mau();
        m4.setIdMau(4);
        m4.setTen("NAVY");
        m4.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");

        Mau m5 = new Mau();
        m5.setIdMau(5);
        m5.setTen("RED");
        m5.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");

        Mau m6 = new Mau();
        m6.setIdMau(6);
        m6.setTen("BLUE");
        m6.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
        list.add(m6);
        return list;
    }
    public List<KieuSP> getListKieuSP(){
        List<KieuSP> list = new ArrayList<>();
        KieuSP  kieuSP1 = new KieuSP();
        kieuSP1.setIdKieuSP(1);
        kieuSP1.setTen("ÁO KHOÁC MIRACLE AIR");
        KieuSP  kieuSP2 = new KieuSP();
        kieuSP2.setIdKieuSP(2);
        kieuSP2.setTen("ÁO KHOÁC & ÁO BLAZER");
        list.add(kieuSP1);
        list.add(kieuSP2);

        return list;
    }
    public List<LoaiSP> getListLoaiSP(){
        List<LoaiSP> list = new ArrayList<>();
        LoaiSP loaiSP = new LoaiSP();
        loaiSP.setIdLoaiSP(1);
        loaiSP.setTen("Đồ mặc ngoài");
        loaiSP.setListKieuSP(this.getListKieuSP());
        list.add(loaiSP);
        return list;
    }
    public List<NhomSP> getListNhomSP(){
        List<NhomSP> list = new ArrayList<>();

        NhomSP nhomSP = new NhomSP();
        nhomSP.setIdNhomSP(1);
        nhomSP.setTen("Nam");
        nhomSP.setImageURL("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
        nhomSP.setListLoaiSP(this.getListLoaiSP());

        NhomSP nhomSP1 = new NhomSP();
        nhomSP1.setIdNhomSP(2);
        nhomSP1.setTen("Nữ");
        nhomSP1.setImageURL("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
        nhomSP1.setListLoaiSP(this.getListLoaiSP());



        list.add(nhomSP);
        list.add(nhomSP1);


        return list;
    }
    public List<SanPham> getSanPham(){
        List<SanPham> list = new ArrayList<>();

        listNhomSP = this.getListNhomSP();
        listLoaiSP = this.getListLoaiSP();
        listKieuSP = this.getListKieuSP();
        listsize = this.getListSize();
        listcolor = this.getListMau();

        SanPham sp1 = new SanPham();
        sp1.setIdSanPham(1);
//        sp1.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
        sp1.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
//        sp1.setGiaban(120);
//        sp1.setSoLuong(10);
//        sp1.setSoLuongBan(12);
        sp1.setNhomSanPham(listNhomSP.get(0));
        sp1.setLoaiSanPham(listLoaiSP.get(0));
        sp1.setKieuSanPham(listKieuSP.get(0));
//        sp1.setKichThuoc(listsize.get(0));
//        sp1.setMau(listcolor.get(0));
        sp1.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");

        SanPham sp2 = new SanPham();
        sp2.setIdSanPham(2);
//        sp2.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
        sp2.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
//        sp2.setGiaban(121);
//        sp2.setSoLuong(20);
//        sp2.setSoLuongBan(12);
        sp2.setNhomSanPham(listNhomSP.get(1));
        sp2.setLoaiSanPham(listLoaiSP.get(0));
        sp2.setKieuSanPham(listKieuSP.get(0));
//        sp2.setKichThuoc(listsize.get(1));
//        sp2.setMau(listcolor.get(1));
        sp2.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");

        SanPham sp3 = new SanPham();
        sp3.setIdSanPham(4);
//        sp3.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
        sp3.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
//        sp3.setGiaban(122);
//        sp3.setSoLuong(30);
//        sp3.setSoLuongBan(12);
        sp3.setNhomSanPham(listNhomSP.get(1));
        sp3.setLoaiSanPham(listLoaiSP.get(0));
        sp3.setKieuSanPham(listKieuSP.get(0));
//        sp3.setKichThuoc(listsize.get(1));
//        sp3.setMau(listcolor.get(2));
        sp3.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");

        SanPham sp4 = new SanPham();
        sp4.setIdSanPham(4);
//        sp4.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
        sp4.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
//        sp4.setGiaban(123);
//        sp4.setSoLuong(40);
//        sp4.setSoLuongBan(12);
        sp4.setNhomSanPham(listNhomSP.get(0));
        sp4.setLoaiSanPham(listLoaiSP.get(0));
        sp4.setKieuSanPham(listKieuSP.get(0));
//        sp4.setKichThuoc(listsize.get(3));
//        sp4.setMau(listcolor.get(3));
        sp4.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");

        SanPham sp5 = new SanPham();
        sp5.setIdSanPham(5);
//        sp5.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
        sp5.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
//        sp5.setGiaban(124);
//        sp5.setSoLuong(50);
//        sp5.setSoLuongBan(12);
        sp5.setNhomSanPham(listNhomSP.get(0));
        sp5.setLoaiSanPham(listLoaiSP.get(0));
        sp5.setKieuSanPham(listKieuSP.get(0));
//        sp5.setKichThuoc(listsize.get(3));
//        sp5.setMau(listcolor.get(4));
        sp5.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");

        SanPham sp6 = new SanPham();
        sp6.setIdSanPham(6);
//        sp6.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
        sp6.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
//        sp6.setGiaban(125);
//        sp6.setSoLuong(0);
//        sp6.setSoLuongBan(12);
        sp6.setNhomSanPham(listNhomSP.get(0));
        sp6.setLoaiSanPham(listLoaiSP.get(0));
        sp6.setKieuSanPham(listKieuSP.get(0));
//        sp6.setKichThuoc(listsize.get(2));
//        sp6.setMau(listcolor.get(5));

        sp6.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");

        SanPham sp7 = new SanPham();
        sp7.setIdSanPham(7);
//        sp7.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
        sp7.setTenSanPham("Z");
//        sp7.setGiaban(126);
//        sp7.setSoLuong(0);
//        sp7.setSoLuongBan(12);
        sp7.setNhomSanPham(listNhomSP.get(1));
        sp7.setLoaiSanPham(listLoaiSP.get(0));
        sp7.setKieuSanPham(listKieuSP.get(1));
//        sp7.setKichThuoc(listsize.get(2));
//        sp7.setMau(listcolor.get(5));
//        sp6.setMau(listcolor.get(1));
        sp7.setThongTin("Chất liệu vải nhẹ, co giãn và nhanh khô mang lại sự thoải mái đáng kinh ngạc. Kiểu dáng đẹp mắt cho bất kỳ dịp nào.");
        list.add(sp1);
        list.add(sp2);
        list.add(sp3);
        list.add(sp4);
        list.add(sp5);
        list.add(sp6);
        list.add(sp7);
        return list;
    }



}
