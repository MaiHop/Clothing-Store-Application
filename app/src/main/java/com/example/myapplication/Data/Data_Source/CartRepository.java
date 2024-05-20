package com.example.myapplication.Data.Data_Source;

import com.example.myapplication.Model.DiaChi;
import com.example.myapplication.Model.DonHang;
import com.example.myapplication.Model.DonHangChiTiet;
import com.example.myapplication.Model.DonHangQuaTrinh;
import com.example.myapplication.Model.KhachHang;
import com.example.myapplication.Model.KhuyenMai;
import com.example.myapplication.Model.KichThuoc;
import com.example.myapplication.Model.KieuSP;
import com.example.myapplication.Model.LoaiSP;
import com.example.myapplication.Model.Mau;
import com.example.myapplication.Model.NhomSP;
import com.example.myapplication.Model.SanPham;
import com.example.myapplication.Model.ThanhToan;
import com.example.myapplication.Model.VanChuyen;

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
    public List<DonHang> getListDH(){
        List<DonHang> list = new ArrayList<>();
        List<DiaChi> listdc = getListAddress();
        List<VanChuyen> listvc = getListDelivery();
        List<ThanhToan> listtt = getListMP();
        List<KhuyenMai> listkm = getListKhuyenMai();
        List<DonHangQuaTrinh> listQT = getListDHQT();
        List<DonHangChiTiet> listdhct = getGioHang();
        List<DonHangChiTiet> list_ct1 = new ArrayList<>();
        List<DonHangChiTiet> list_ct2 = new ArrayList<>();
        List<DonHangChiTiet> list_ct3 = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        SanPham sp1 = new SanPham();
        sp1.setTenSanPham("Urban long shirt");
        sp1.setGiaban(120);

        SanPham sp2 = new SanPham();
        sp2.setTenSanPham("Tee shirt for summer");
        sp2.setGiaban(50);

        SanPham sp3 = new SanPham();
        sp3.setTenSanPham("Short");
        sp3.setGiaban(100);

        DonHangChiTiet dhct1 = new DonHangChiTiet();
        dhct1.setSanPham(sp1);
        list_ct1.add(dhct1);

        DonHangChiTiet dhct2 = new DonHangChiTiet();
        dhct2.setSanPham(sp2);
        list_ct2.add(dhct2);

        DonHangChiTiet dhct3 = new DonHangChiTiet();
        dhct3.setSanPham(sp3);
        list_ct3.add(dhct3);

        DonHang dh1 = new DonHang();
        dh1.setListDonHangChiTiet(list_ct1);
        dh1.setTrangThai("Active");
        dh1.setphiDichVu(50.0);
        try {
            dh1.setNgayThanhToan(formatter.parse("11/05/2024"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dh1.setDiachi(listdc.get(0));
        dh1.setVanchuyen(listvc.get(0));
        dh1.setThanhToan(listtt.get(0));
        dh1.setKhuyenmai(listkm.get(0));
        dh1.setListDonHangChiTiet(listdhct);
        dh1.setPhiGiaoHang(200);
        dh1.setThue(0.1);
        dh1.setListdonhangqt(listQT);

        DonHang dh2 = new DonHang();
        dh2.setListDonHangChiTiet(list_ct2);
        dh2.setTrangThai("Completed");
        try {
            dh2.setNgayThanhToan(formatter.parse("20/03/2024"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dh2.setDiachi(listdc.get(0));
        dh2.setVanchuyen(listvc.get(0));
        dh2.setThanhToan(listtt.get(0));
        dh2.setKhuyenmai(listkm.get(0));
        dh2.setListDonHangChiTiet(listdhct);
        dh2.setPhiGiaoHang(200);
        dh2.setThue(0.1);
        dh2.setListdonhangqt(listQT);

        DonHang dh3 = new DonHang();
        dh3.setListDonHangChiTiet(list_ct3);
        dh3.setTrangThai("Canceled");
        try {
            dh3.setNgayThanhToan(formatter.parse("20/03/2023"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        list.add(dh1);
        list.add(dh2);
        list.add(dh3);

        return list;
    }

    public List<DonHangQuaTrinh> getListDHQT(){
        List<DonHangQuaTrinh> list = new ArrayList<>();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        DonHangQuaTrinh qt1 = new DonHangQuaTrinh();
        try {
            qt1.setNgay(formatter.parse("20/03/2024"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        qt1.setMoTa("08:60 AM");
        qt1.setTrangThai("Đang giao hàng");

        DonHangQuaTrinh qt2 = new DonHangQuaTrinh();
        try {
            qt2.setNgay(formatter.parse("18/03/2024"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        qt2.setMoTa("11:20 AM");
        qt2.setTrangThai("Đã thanh toán");

        DonHangQuaTrinh qt3 = new DonHangQuaTrinh();
        try {
            qt3.setNgay(formatter.parse("17/03/2024"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        qt3.setMoTa("11:30 PM");
        qt3.setTrangThai("Chưa thanh toán");

        list.add(qt1);
        list.add(qt2);
        list.add(qt3);
        return list;
    }
    public List<KichThuoc> getListSize(){
        List<KichThuoc> list = new ArrayList<>();
        KichThuoc kt1 = new KichThuoc();
        kt1.setId("1");
        kt1.setTen("XS");
        KichThuoc kt2 = new KichThuoc();
        kt2.setId("2");
        kt2.setTen("S");
        KichThuoc kt3 = new KichThuoc();
        kt3.setId("3");
        kt3.setTen("M");
        KichThuoc kt4 = new KichThuoc();
        kt4.setId("4");
        kt4.setTen("L");
        KichThuoc kt5 = new KichThuoc();
        kt5.setId("5");
        kt5.setTen("XL");
        KichThuoc kt6 = new KichThuoc();
        kt6.setId("6");
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
        m1.setId("1");
        m1.setTen("GRAY");
        m1.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F09_Black.jpg?alt=media&token=4340cb1d-d378-4eb8-9d8c-c2e9b37f8815");

        Mau m2 = new Mau();
        m2.setId("2");
        m2.setTen("DARK GRAY");
        m2.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F08_DrarkGray.jpg?alt=media&token=240e25ac-d00b-4965-ae6a-0bb63a3ea5fd");

        Mau m3 = new Mau();
        m3.setId("3");
        m3.setTen("BLACK");
        m3.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F09_Black.jpg?alt=media&token=4340cb1d-d378-4eb8-9d8c-c2e9b37f8815");

        Mau m4 = new Mau();
        m4.setId("4");
        m4.setTen("NAVY");
        m4.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F69_Navy.jpg?alt=media&token=f6b5529d-2575-4372-9679-14939b3fb623");

        Mau m5 = new Mau();
        m5.setId("5");
        m5.setTen("RED");
        m5.setImgUrl("https://cdn.photoroom.com/v1/assets-cached.jpg?path=backgrounds_v3/red/image_93_color4.jpg");

        Mau m6 = new Mau();
        m6.setId("6");
        m6.setTen("BLUE");
        m6.setImgUrl("https://vitachem.vn/wp-content/uploads/2019/05/mau-tong-hop-xanh-duong-brilliant-blue-e133-blue-1-color-shade-220x220.jpg");

        Mau m7 = new Mau();
        m7.setId("7");
        m7.setTen("BEIGE");
        m7.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F31_Beige.jpg?alt=media&token=5aa967cf-0d7b-4bf5-a80a-9d309c31e76c");



        Mau m8 = new Mau();
        m8.setId("8");
        m8.setTen("White");
        m8.setImgUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/mau%2F00_White.jpg?alt=media&token=e292099f-dc37-4564-a0c4-bac4321ccaa9");

        list.add(m8);

         list.add(m1);

        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
        list.add(m6);
        list.add(m7);
        return list;
    }
    public List<KieuSP> getListKieuSP(){
        List<KieuSP> list = new ArrayList<>();
        KieuSP  kieuSP1 = new KieuSP();
        kieuSP1.setId("1");
        kieuSP1.setTen("ÁO KHOÁC MIRACLE AIR");
        KieuSP  kieuSP2 = new KieuSP();
        kieuSP2.setId("2");
        kieuSP2.setTen("ÁO KHOÁC & ÁO BLAZER");

        KieuSP  kieuSP3 = new KieuSP();
        kieuSP3.setId("3");
        kieuSP3.setTen("ÁO THUN");
        KieuSP  kieuSP4 = new KieuSP();
        kieuSP4.setId("4");
        kieuSP4.setTen("ÁO LEN");


        list.add(kieuSP1);
        list.add(kieuSP2);

        list.add(kieuSP3);
        list.add(kieuSP4);

        return list;
    }
    public List<LoaiSP> getListLoaiSP(){
        List<LoaiSP> list = new ArrayList<>();
        LoaiSP loaiSP = new LoaiSP();
        loaiSP.setId("1");
        loaiSP.setTen("Đồ mặc ngoài");
        loaiSP.setListKieuSP(this.getListKieuSP());
        list.add(loaiSP);
        return list;
    }
    public List<NhomSP> getListNhomSP(){
        List<NhomSP> list = new ArrayList<>();

        NhomSP nhomSP = new NhomSP();
        nhomSP.setId("1");
        nhomSP.setTen("Nam");
        nhomSP.setImageURL("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/471281/item/vngoods_09_471281.jpg?width=750");
        nhomSP.setListLoaiSP(this.getListLoaiSP());

        NhomSP nhomSP1 = new NhomSP();
        nhomSP1.setId("2");
        nhomSP1.setTen("Nữ");
        nhomSP1.setImageURL("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/465756/item/vngoods_00_465756.jpg?width=750s");
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
        sp1.setIdSanPham("1");
        sp1.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/468671/item/vngoods_05_468671.jpg?width=750");
        sp1.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
        sp1.setGiaban(120);
        sp1.setSoLuong(10);
        sp1.setSoLuongBan(12);
        sp1.setNhomSanPham(listNhomSP.get(0));
        sp1.setLoaiSanPham(listLoaiSP.get(0));
        sp1.setKieuSanPham(listKieuSP.get(0));
        sp1.setKichThuoc(listsize.get(0));
        sp1.setMau(listcolor.get(0));
        sp1.setThongTin("- Chất liệu nhẹ, co giãn, nhanh khô (giặt nhanh, thấm mồ hôi nhanh) do Toray và UNIQLO cùng phát triển nhưng vẫn có bề ngoài giống len.\n" +
                "- Được làm bằng chất liệu vải co giãn 2 chiều.\n" +
                "- Có thể giặt bằng máy.\n" +
                "- Kiểu dáng đẹp vừa vặn.\n" +
                "- Áo khoác đa năng với kiểu dáng bo tròn tự nhiên từ vai đến tay áo.\n" +
                "- Họa tiết răng cưa nhỏ trông như một màu đơn sắc.");

        SanPham sp2 = new SanPham();
        sp2.setIdSanPham("2");
        sp2.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/467537/item/vngoods_69_467537.jpg?width=750");
        sp2.setTenSanPham("Miracle Air Áo Blazer (AirSense Áo Blazer)");
        sp2.setGiaban(150);
        sp2.setSoLuong(20);
        sp2.setSoLuongBan(12);
        sp2.setNhomSanPham(listNhomSP.get(0));
        sp2.setLoaiSanPham(listLoaiSP.get(0));
        sp2.setKieuSanPham(listKieuSP.get(0));
        sp2.setKichThuoc(listsize.get(1));
        sp2.setMau(listcolor.get(3));
        sp2.setThongTin("- Chất liệu nhẹ, co giãn và nhanh khô (giặt nhanh, thấm mồ hôi nhanh) do Toray và UNIQLO hợp tác phát triển.\n" +
                "- Được làm bằng chất liệu vải co giãn 2 chiều.\n" +
                "- Vừa vặn với vòng eo cơ thể.\n" +
                "- Ve áo dày hơn một chút trông tuyệt vời với mọi phong cách từ giản dị đến tinh tế.\n" +
                "- Có 2 nút kim loại ở mặt trước và 4 nút ở tay áo.\n" +
                "- Kết hợp hình thức và tính năng.\n" +
                "- Thiết kế mang tính biểu tượng của UNIQLO, được làm mới bằng chất liệu vải nhẹ.");

        SanPham sp3 = new SanPham();
        sp3.setIdSanPham("3");
        sp3.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/448034/item/vngoods_05_448034.jpg?width=750");
        sp3.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác) (Wool Like)");
        sp3.setGiaban(122);
        sp3.setSoLuong(30);
        sp3.setSoLuongBan(12);
        sp3.setNhomSanPham(listNhomSP.get(0));
        sp3.setLoaiSanPham(listLoaiSP.get(0));
        sp3.setKieuSanPham(listKieuSP.get(0));
        sp3.setKichThuoc(listsize.get(1));
        sp3.setMau(listcolor.get(0));
        sp3.setThongTin("- Chiếc áo khoác hiệu suất cao với chất liệu nhẹ, co giãn và nhanh khô nhờ loại vải độc đáo do Toray và UNIQLO đồng phát triển.\n" +
                "- Chất thun co giãn 2 chiều.\n" +
                "- Với công nghệ DRY khô nhanh.\n" +
                "- Kiểu dáng đẹp vừa vặn, thiết kế ít gò bó hơn ở phần eo.\n" +
                "- Áo khoác đa năng với kiểu dáng bo tròn tự nhiên từ vai đến tay áo.");


        SanPham sp4 = new SanPham();
        sp4.setIdSanPham("4");
        sp4.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/470993/item/vngoods_08_470993.jpg?width=750");
        sp4.setTenSanPham("Miracle Air Áo Khoác Kiểu Sơ Mi (AirSense Áo Khoác Kiểu Sơ Mi) (Wool Like)");
        sp4.setGiaban(170);
        sp4.setSoLuong(40);
        sp4.setSoLuongBan(12);
        sp4.setNhomSanPham(listNhomSP.get(0));
        sp4.setLoaiSanPham(listLoaiSP.get(0));
        sp4.setKieuSanPham(listKieuSP.get(0));
        sp4.setKichThuoc(listsize.get(3));
        sp4.setMau(listcolor.get(1));
        sp4.setThongTin("- Áo khoác kiểu sơ mi hiệu suất cao với chất liệu vải nhẹ, co giãn và nhanh khô nhờ chất liệu vải độc đáo do Toray và UNIQLO cùng phát triển.\n" +
                "- Đường khâu tối thiểu mang lại vẻ ngoài gọn gàng.\n" +
                "- Các túi ở đường may bên hông giúp đựng được nhiều vật dụng cá nhân của bạn.");

        SanPham sp5 = new SanPham();
        sp5.setIdSanPham("5");
        sp5.setImageUrl("https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/462028/item/goods_30_462028.jpg?width=750https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/444557/item/vngoods_32_444557.jpg?width=750");
        sp5.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác)");
        sp5.setGiaban(133);
        sp5.setSoLuong(50);
        sp5.setSoLuongBan(12);
        sp5.setNhomSanPham(listNhomSP.get(0));
        sp5.setLoaiSanPham(listLoaiSP.get(0));
        sp5.setKieuSanPham(listKieuSP.get(1));
        sp5.setKichThuoc(listsize.get(3));
        sp5.setMau(listcolor.get(6));
        sp5.setThongTin("- Chiếc áo khoác hiệu suất cao với chất liệu nhẹ, co giãn và nhanh khô nhờ loại vải độc đáo do Toray và UNIQLO đồng phát triển.\n" +
                "- Chất thun co giãn 2 chiều.\n" +
                "- Với công nghệ DRY khô nhanh.\n" +
                "- Kiểu dáng đẹp vừa vặn, thiết kế ít gò bó hơn ở phần eo.\n" +
                "- Áo khoác đa năng với kiểu dáng bo tròn tự nhiên từ vai đến tay áo.");

        SanPham sp6 = new SanPham();
        sp6.setIdSanPham("6");
        sp6.setImageUrl("https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/449631/item/goods_09_449631.jpg?width=750");
        sp6.setTenSanPham("Ultra Light Down Áo Khoác Siêu Nhẹ (3D Cut)");
        sp6.setGiaban(167);
        sp6.setSoLuong(50);
        sp6.setSoLuongBan(12);
        sp6.setNhomSanPham(listNhomSP.get(0));
        sp6.setLoaiSanPham(listLoaiSP.get(0));
        sp6.setKieuSanPham(listKieuSP.get(1));
        sp6.setKichThuoc(listsize.get(3));
        sp6.setMau(listcolor.get(6));
        sp6.setThongTin("- Chiếc áo khoác hiệu suất cao với chất liệu nhẹ, co giãn và nhanh khô nhờ loại vải độc đáo do Toray và UNIQLO đồng phát triển.\n" +
                "- Chất thun co giãn 2 chiều.\n" +
                "- Với công nghệ DRY khô nhanh.\n" +
                "- Kiểu dáng đẹp vừa vặn, thiết kế ít gò bó hơn ở phần eo.\n" +
                "- Áo khoác đa năng với kiểu dáng bo tròn tự nhiên từ vai đến tay áo.");

        SanPham sp7 = new SanPham();
        sp7.setIdSanPham("7");
        sp7.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/450195/item/vngoods_01_450195.jpg?width=320");
        sp7.setTenSanPham("Miracle Air Áo Khoác (AirSense Áo Khoác)");
        sp7.setGiaban(140);
        sp7.setSoLuong(50);
        sp7.setSoLuongBan(12);
        sp7.setNhomSanPham(listNhomSP.get(0));
        sp7.setLoaiSanPham(listLoaiSP.get(0));
        sp7.setKieuSanPham(listKieuSP.get(1));
        sp7.setKichThuoc(listsize.get(3));
        sp7.setMau(listcolor.get(3));
        sp7.setThongTin("- Chiếc áo khoác hiệu suất cao với chất liệu nhẹ, co giãn và nhanh khô nhờ loại vải độc đáo do Toray và UNIQLO đồng phát triển.\n" +
                "- Chất thun co giãn 2 chiều.\n" +
                "- Với công nghệ DRY khô nhanh.\n" +
                "- Kiểu dáng đẹp vừa vặn, thiết kế ít gò bó hơn ở phần eo.\n" +
                "- Áo khoác đa năng với kiểu dáng bo tròn tự nhiên từ vai đến tay áo.");


        SanPham sp8 = new SanPham();
        sp8.setIdSanPham("7");
        sp8.setImageUrl("https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/470050/item/goods_08_470050.jpg?width=750");
        sp8.setTenSanPham("Áo Khoác Thoải Mái 2B");
        sp8.setGiaban(140);
        sp8.setSoLuong(50);
        sp8.setSoLuongBan(12);
        sp8.setNhomSanPham(listNhomSP.get(0));
        sp8.setLoaiSanPham(listLoaiSP.get(0));
        sp8.setKieuSanPham(listKieuSP.get(1));
        sp8.setKichThuoc(listsize.get(3));
        sp8.setMau(listcolor.get(3));
        sp8.setThongTin("Xin lưu ý mã số nhận diện của sản phẩm có thể có sự khác biệt, kể cả khi đó là cùng một mặt hàng.\n" +
                "VẢI\n" +
                "Vải Chính: 66% Polyeste, 34% Bông ( 31% Sử Dụng Sợi Polyeste Tái Chế )/ Lớp Lót: 100% Polyeste/ Vải Túi: 100% Polyeste\n" +
                "HƯỚNG DẪN GIẶT\n" +
                "Giặt tay nước lạnh, Giặt khô, Không sấy khô\n" +
                "- Những hình ảnh sản phẩm có thể bao gồm những màu không có sẵn.\n");

        SanPham sp9 = new SanPham();
        sp9.setIdSanPham("9");
        sp9.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/466361/item/vngoods_15_466361.jpg?width=750");
        sp9.setTenSanPham("Áo Cardigan Ren Cổ Tròn Rộng Dáng Ngắn Dài Tay");
        sp9.setGiaban(170);
        sp9.setSoLuong(50);
        sp9.setSoLuongBan(12);
        sp9.setNhomSanPham(listNhomSP.get(1));
        sp9.setLoaiSanPham(listLoaiSP.get(0));
        sp9.setKieuSanPham(listKieuSP.get(3));
        sp9.setKichThuoc(listsize.get(3));
        sp9.setMau(listcolor.get(4));
        sp9.setThongTin("Một tủ quần áo hiện đại dành riêng cho bạn đến từ nhà thiết kế nổi tiếng người Anh Clare Waight Keller, được biết đến là một nhà thết kế được các hãng thời trang hàng đầu trên thế giới, giới mộ điệu đánh giá cao.\n" +
                "\n" +
                "- Vải cotton-nylon có họa tiết.\n" +
                "- Ren đan. *Sản phẩm này nên được cất giữ ở dạng gấp vì hình dạng và kích thước có thể thay đổi nếu treo trên móc.\n" +
                "- Chiều dài đã được thu gọn.\n" +
                "- Kiểu dáng vừa vặn.\n" +
                "- Cổ tròn.");

        list.add(sp9);

        SanPham sp10 = new SanPham();
        sp10.setIdSanPham("10");
        sp10.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/461090/item/vngoods_31_461090.jpg?width=750");
        sp10.setTenSanPham("TÁo Len Dệt 3D Vải Cotton Dài Tay");
        sp10.setGiaban(200);
        sp10.setSoLuong(0);
        sp10.setSoLuongBan(0);
        sp10.setNhomSanPham(listNhomSP.get(1));
        sp10.setLoaiSanPham(listLoaiSP.get(0));
        sp10.setKieuSanPham(listKieuSP.get(3));
        sp10.setKichThuoc(listsize.get(3));
        sp10.setMau(listcolor.get(2));
        sp10.setThongTin("- Chất liệu 100% cotton mềm mịn. *Sản phẩm này nên được cất giữ ở dạng gấp vì hình dạng và kích thước có thể thay đổi nếu treo trên móc treo.\n" +
                "- Đường dệt kim 3D liền mạch tạo cảm giác vừa vặn thoải mái. *Thẻ và nhãn chăm sóc chất lượng có đường nối.\n" +
                "- Đan liền mạch mang lại vẻ ngoài tinh tế.\n" +
                "- Cắt thoải mái.\n" +
                "- Tay áo thẳng, không bó sát.\n" +
                "- Thiết kế đa năng có thể được tạo kiểu theo nhiều cách khác nhau.");

        list.add(sp10);

        SanPham sp11 = new SanPham();
        sp11.setIdSanPham("11");
        sp11.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/467393/item/vngoods_61_467393.jpg?width=750");
        sp11.setTenSanPham("Áo Len Dệt 3D Gân Cổ Tròn Dài Tay");
        sp11.setGiaban(250);
        sp11.setSoLuong(0);
        sp11.setSoLuongBan(0);
        sp11.setNhomSanPham(listNhomSP.get(1));
        sp11.setLoaiSanPham(listLoaiSP.get(0));
        sp11.setKieuSanPham(listKieuSP.get(3));
        sp11.setKichThuoc(listsize.get(4));
        sp11.setMau(listcolor.get(5));
        sp11.setThongTin("The final chapter of the collaboration with Ines de la Fressange, synonymous with the timeless appeal of French chic.\n" +
                "\n" +
                "- Smooth and comfortable 100% cotton.\n" +
                "- 3D knit creates a flattering silhouette.");

        list.add(sp11);
        SanPham sp12 = new SanPham();
        sp12.setIdSanPham("12");
        sp12.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/467407/item/vngoods_09_467407.jpg?width=750");
        sp12.setTenSanPham("Áo Len Dệt 3D Cổ Tròn Tay Lỡ Có Thể Giặt Máy (Họa Tiết Kẻ Sọc)");
        sp12.setGiaban(220);
        sp12.setSoLuong(0);
        sp12.setSoLuongBan(0);
        sp12.setNhomSanPham(listNhomSP.get(1));
        sp12.setLoaiSanPham(listLoaiSP.get(0));
        sp12.setKieuSanPham(listKieuSP.get(3));
        sp12.setKichThuoc(listsize.get(2));
        sp12.setMau(listcolor.get(2));
        sp12.setThongTin("New LifeWear that combines UNIQLO’s focus on design, fit, fabric, and functionality with JW ANDERSON’s focus on traditional British apparel into innovative designs.\n" +
                "\n" +
                "- Smooth cotton-rayon blend.\n" +
                "- Machine-washable. *We recommend washing this item inside out in a mesh laundry bag. *Shape to dry after washing.\n" +
                "- Sleek skipper neck.\n" +
                "- Two accent stripes at the collar.\n" +
                "- This season’s colorways are inspired by the iconic Robin Day chair.\n" +
                "- JW Anderson embroidery at the hem.");

        list.add(sp12);
        SanPham sp13 = new SanPham();
        sp13.setIdSanPham("13");
        sp13.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/466970/item/vngoods_14_466970.jpg?width=750");
        sp13.setTenSanPham("Áo Polo Len Ngắn Tay");
        sp13.setGiaban(130);
        sp13.setSoLuong(0);
        sp13.setSoLuongBan(0);
        sp13.setNhomSanPham(listNhomSP.get(0));
        sp13.setLoaiSanPham(listLoaiSP.get(0));
        sp13.setKieuSanPham(listKieuSP.get(3));
        sp13.setKichThuoc(listsize.get(3));
        sp13.setMau(listcolor.get(4));
        sp13.setThongTin("New LifeWear that combines UNIQLO’s focus on design, fit, fabric, and functionality with JW ANDERSON’s focus on traditional British apparel into innovative designs.\n" +
                "\n" +
                "- Smooth cotton-rayon blend.\n" +
                "- Machine-washable. *We recommend washing this item inside out in a mesh laundry bag. *Shape to dry after washing.\n" +
                "- Sleek skipper neck.\n" +
                "- Two accent stripes at the collar.\n" +
                "- This season’s colorways are inspired by the iconic Robin Day chair.\n" +
                "- JW Anderson embroidery at the hem.");
        list.add(sp13);

        SanPham sp14 = new SanPham();
        sp14.setIdSanPham("14");
        sp14.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/468625/item/vngoods_61_468625.jpg?width=750");
        sp14.setTenSanPham("Áo Thun Cổ Thuyền Không Tay");
        sp14.setGiaban(140);
        sp14.setSoLuong(0);
        sp14.setSoLuongBan(0);
        sp14.setNhomSanPham(listNhomSP.get(1));
        sp14.setLoaiSanPham(listLoaiSP.get(0));
        sp14.setKieuSanPham(listKieuSP.get(2));
        sp14.setKichThuoc(listsize.get(2));
        sp14.setMau(listcolor.get(5));
        sp14.setThongTin("- Áo thun tay cộc cổ thuyền có chất liệu từ vải gân cotton, tạo cảm giác vừa vặn, thoải mái.\n" +
                "- Thiết kế cổ thuyền thanh lịch với độ ôm vừa phải, áo thun giúp tôn lên vóc dáng người mặc.\n" +
                "- Đặc biệt, chiếc áo thun không tay này vừa mới được cải tiến phần dưới cánh tay áo để che chắn nhiều hơn, giúp bạn thêm phần tự tin.\n" +
                "- Chiều dài áo thun cũng được thiết kế dài hơn một chút, phù hợp để sơ vin hoặc mặc ngoài.\n" +
                "- Chiếc áo thun tay cộc cổ thuyền này được lấy cảm hứng từ phong cách thời trang thập niên năm 90.");
        list.add(sp14);

        SanPham sp15 = new SanPham();
        sp15.setIdSanPham("15");
        sp15.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/467047/item/vngoods_31_467047.jpg?width=750");
        sp15.setTenSanPham("Áo Thun Xếp Nếp Không Tay");
        sp15.setGiaban(0);
        sp15.setSoLuong(0);
        sp15.setSoLuongBan(0);
        sp15.setNhomSanPham(listNhomSP.get(1));
        sp15.setLoaiSanPham(listLoaiSP.get(0));
        sp15.setKieuSanPham(listKieuSP.get(2));
        sp15.setKichThuoc(listsize.get(3));
        sp15.setMau(listcolor.get(6));
        sp15.setThongTin("Các nếp gấp tỉ mỉ.\n" +
                "- Cổ thuyền.\n" +
                "- Dễ dàng sử dụng và phối đồ. *Được đóng gói đặc biệt để giữ nguyên hình dạng của nếp gấp. (Cuộn theo chiều dọc.) *Có thể loại bỏ các nếp nhăn nhẹ khi giặt.");

        list.add(sp15);

        SanPham sp16 = new SanPham();
        sp16.setIdSanPham("16");
        sp16.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/465756/item/vngoods_00_465756.jpg?width=750");
        sp16.setTenSanPham("Áo Thun Cổ Tròn Vải Gân Mềm Ngắn Tay");
        sp16.setGiaban(290);
        sp16.setSoLuong(0);
        sp16.setSoLuongBan(0);
        sp16.setNhomSanPham(listNhomSP.get(1));
        sp16.setLoaiSanPham(listLoaiSP.get(0));
        sp16.setKieuSanPham(listKieuSP.get(2));
        sp16.setKichThuoc(listsize.get(3));
        sp16.setMau(listcolor.get(7));
        sp16.setThongTin("- Chất thun gân cotton co giãn.\n" +
                "- Chiều dài dài hơn tạo nên dáng người mảnh mai. Dễ dàng mặc lên hoặc cởi ra.");

        list.add(sp16);

        SanPham sp17 = new SanPham();
        sp17.setIdSanPham("17");
        sp17.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/465763/item/vngoods_30_465763.jpg?width=750");
        sp17.setTenSanPham("Áo Ba Lỗ Vải Gân Mềm");
        sp17.setGiaban(220);
        sp17.setSoLuong(0);
        sp17.setSoLuongBan(0);
        sp17.setNhomSanPham(listNhomSP.get(1));
        sp17.setLoaiSanPham(listLoaiSP.get(0));
        sp17.setKieuSanPham(listKieuSP.get(2));
        sp17.setKichThuoc(listsize.get(2));
        sp17.setMau(listcolor.get(6));
        sp17.setThongTin("- Chất thun gân cotton co giãn.\n" +
                "- Chiều dài dài hơn tạo nên dáng người mảnh mai. Dễ dàng mặc lên hoặc cởi ra.\n");

        list.add(sp17);


        SanPham sp18 = new SanPham();
        sp18.setIdSanPham("18");
        sp18.setImageUrl("https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/465601/item/vngoods_33_465601.jpg?width=750");
        sp18.setTenSanPham("AIRism Cotton Áo Polo Vải Gân");
        sp18.setGiaban(300);
        sp18.setSoLuong(0);
        sp18.setSoLuongBan(0);
        sp18.setNhomSanPham(listNhomSP.get(1));
        sp18.setLoaiSanPham(listLoaiSP.get(0));
        sp18.setKieuSanPham(listKieuSP.get(2));
        sp18.setKichThuoc(listsize.get(1));
        sp18.setMau(listcolor.get(3));
        sp18.setThongTin("- Vải 'AIRism' gân.\n" +
                "- Kiểu dáng vừa vặn.\n" +
                "- Cổ cài nút.\n" +
                "- Ôm gọn tôn dáng.");

        list.add(sp18);

        list.add(sp1);
        list.add(sp2);
        list.add(sp3);
        list.add(sp4);
        list.add(sp5);
        list.add(sp6);
        list.add(sp7);
        list.add(sp8);



        return list;
    }

    public List<DonHang> getListDonHang(){
        List<DonHang> list_dh = new ArrayList<>();
        List<DonHangChiTiet> list = this.getGioHang();
        KhachHang kh =new KhachHang();
        kh.setIdKhachHang("1");
        kh.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLvMEg2PbVb_MVOChlQMhcg2G8A_LtTuXc4wVdqsbEcQ&s");
        kh.setTen("Mr. Fresh");
        kh.setEmail("mrfresh@gmail.com");
        kh.setGioiTinh(0);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


        DonHang dh1 = new DonHang();
        dh1.setIdDonHang("1");
        dh1.setKhachHang(kh);
        dh1.setTongSoLuong(5);
        dh1.setTrangThai("Cart");
        dh1.setListDonHangChiTiet(list);

        DonHang dh2 = new DonHang();
        dh2.setIdDonHang("2");
        dh2.setKhachHang(kh);
        dh2.setTongSoLuong(0);
        dh2.setTrangThai("Active");
        dh2.setListDonHangChiTiet(null);

        DonHang dh3 = new DonHang();
        dh3.setIdDonHang("3");
        dh3.setKhachHang(kh);
        dh3.setTongSoLuong(0);
        dh3.setTrangThai("Active");
        dh3.setListDonHangChiTiet(null);

        list_dh.add(dh1);
        list_dh.add(dh2);
        list_dh.add(dh3);
        return list_dh;
    }

    public  List<DonHangChiTiet> getGioHang(){
        List<DonHangChiTiet> list = new ArrayList<>();
        CartRepository res = new CartRepository();
        List<SanPham> listproduct = res.getSanPham();

        DonHangChiTiet dh1 = new DonHangChiTiet();
        dh1.setIdDonHang("1");
        dh1.setSanPham(listproduct.get(0));
        dh1.setSoLuong(1);
        dh1.setThanhTien(listproduct.get(0).getGiaban()*dh1.getSoLuong());
        dh1.setThanhTienKhuyenMai(0);
        dh1.setChecked(true);

        DonHangChiTiet dh2 = new DonHangChiTiet();
        dh2.setIdDonHang("1");
        dh2.setSanPham(listproduct.get(1));
        dh2.setSoLuong(1);
        dh2.setThanhTien(listproduct.get(1).getGiaban()*dh1.getSoLuong());
        dh2.setThanhTienKhuyenMai(0);
        dh2.setChecked(true);

        DonHangChiTiet dh3 = new DonHangChiTiet();
        dh3.setIdDonHang("1");
        dh3.setSanPham(listproduct.get(2));
        dh3.setSoLuong(1);
        dh3.setThanhTien(listproduct.get(2).getGiaban()*dh1.getSoLuong());
        dh3.setThanhTienKhuyenMai(0);
        dh3.setChecked(true);

        DonHangChiTiet dh4 = new DonHangChiTiet();
        dh4.setIdDonHang("1");
        dh4.setSanPham(listproduct.get(3));
        dh4.setSoLuong(1);
        dh4.setThanhTien(listproduct.get(3).getGiaban()*dh1.getSoLuong());
        dh4.setThanhTienKhuyenMai(0);
        dh4.setChecked(true);

        DonHangChiTiet dh5 = new DonHangChiTiet();
        dh5.setIdDonHang("1");
        dh5.setSanPham(listproduct.get(6));
        dh5.setSoLuong(1);
        dh5.setThanhTien(listproduct.get(3).getGiaban()*dh1.getSoLuong());
        dh5.setThanhTienKhuyenMai(0);
        dh5.setChecked(true);

        list.add(dh1);
        list.add(dh2);
        list.add(dh3);
        list.add(dh4);
        list.add(dh5);

        return  list;
    }

    public List<DiaChi> getListAddress(){
        List<DiaChi> list = new ArrayList<>();

        DiaChi dc1 = new DiaChi();
        dc1.setIdDiaChi("1");
        dc1.setTenDiaChi("Home");
        dc1.setDiaChiChinh(true);
        dc1.setNguoiNhan("Trung Hậu");
        dc1.setsDT("0765328458");
        dc1.setDiaChi("155/33 Nguyễn Trãi");
        dc1.setXacDinh(true);
        dc1.setChecked(false);

        DiaChi dc2 = new DiaChi();
        dc2.setIdDiaChi("2");
        dc2.setTenDiaChi("CC1");
        dc2.setDiaChiChinh(false);
        dc2.setNguoiNhan("Trung Hậu");
        dc2.setsDT("0765328458");
        dc2.setDiaChi("155/33 Nguyễn Trãi");
        dc2.setXacDinh(true);
        dc2.setChecked(false);

        DiaChi dc3 = new DiaChi();
        dc3.setIdDiaChi("3");
        dc3.setTenDiaChi("CC2");
        dc3.setDiaChiChinh(false);
        dc3.setNguoiNhan("Trung Hậu");
        dc3.setsDT("0765328458");
        dc3.setDiaChi("155/33 Nguyễn Trãi");
        dc3.setXacDinh(true);
        dc3.setChecked(false);

        list.add(dc1);
        list.add(dc2);
        list.add(dc3);
        return list;
    }

    public List<VanChuyen> getListDelivery(){
        List<VanChuyen> list = new ArrayList<>();

        VanChuyen vc1 = new VanChuyen();
        vc1.setId("1");
        vc1.setTen("J&T Express");
        vc1.setImageURL("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
        vc1.setNgayGiao("23 - 25 tháng 10 2024");
        vc1.setGia(10);
        vc1.setChecked(false);

        VanChuyen vc2 = new VanChuyen();
        vc2.setId("2");
        vc2.setTen("J&T Express");
        vc2.setImageURL("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
        vc2.setNgayGiao("23 - 25 tháng 10 2024");
        vc2.setGia(10);
        vc2.setChecked(false);

        VanChuyen vc3 = new VanChuyen();
        vc3.setId("3");
        vc3.setTen("J&T Express");
        vc3.setImageURL("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
        vc3.setNgayGiao("23 - 25 tháng 10 2024");
        vc3.setGia(10);
        vc3.setChecked(false);

        list.add(vc1);
        list.add(vc2);
        list.add(vc3);

        return list;
    }

    public List<ThanhToan> getListMP(){
        List<ThanhToan> list = new ArrayList<>();

        ThanhToan tt1 = new ThanhToan();
        tt1.setIdThanhToan("1");
        tt1.setTenThanhToan("Paypal");
        tt1.setLoai("VISA");
        tt1.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
        tt1.setChecked(false);

        ThanhToan tt2 = new ThanhToan();
        tt2.setIdThanhToan("2");
        tt2.setTenThanhToan("Paypal");
        tt2.setLoai("VISA");
        tt2.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
        tt2.setChecked(false);

        ThanhToan tt3 = new ThanhToan();
        tt3.setIdThanhToan("3");
        tt3.setTenThanhToan("Paypal");
        tt3.setLoai("VISA");
        tt3.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
        tt3.setChecked(false);

        list.add(tt1);
        list.add(tt2);
        list.add(tt3);
        return list;
    }

    public List<KhuyenMai> getListKhuyenMai(){
        List<KhuyenMai> list = new ArrayList<>();

        KhuyenMai km1 = new KhuyenMai();
        km1.setIdKhuyenMai("1");
        km1.setTenKhuyenMai("Deal hè");
        km1.setNoiDung("Tặng 1 cái quần xì");
        km1.setDieuKien("Mua 2 cái áo");
        km1.setToiDaGiam("100");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            km1.setHanSuDung(formatter.parse("10/02/2024"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        km1.setTrangThai(false);
        km1.setChecked(false);

        KhuyenMai km2 = new KhuyenMai();
        km2.setIdKhuyenMai("2");
        km2.setTenKhuyenMai("Deal hè");
        km2.setNoiDung("Tặng 1 cái quần xì");
        km2.setDieuKien("Mua 2 cái áo");
        km2.setToiDaGiam("200");

        try {
            km2.setHanSuDung(formatter.parse("10/02/2024"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        km2.setTrangThai(false);
        km2.setChecked(false);

        KhuyenMai km3 = new KhuyenMai();
        km3.setIdKhuyenMai("3");
        km3.setTenKhuyenMai("Deal hè");
        km3.setNoiDung("Tặng 1 cái quần xì");
        km3.setDieuKien("Mua 2 cái áo");
        km3.setToiDaGiam("300");

        try {
            km3.setHanSuDung(formatter.parse("10/02/2024"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        km3.setTrangThai(false);
        km3.setChecked(false);

        list.add(km1);
        list.add(km2);
        list.add(km3);

        return list;
    }


}
