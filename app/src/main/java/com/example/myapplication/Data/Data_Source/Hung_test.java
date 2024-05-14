package com.example.myapplication.Data.Data_Source;

import com.example.myapplication.Domain.Model.DiaChi;
import com.example.myapplication.Domain.Model.DonHangChiTiet;
import com.example.myapplication.Domain.Model.KhuyenMai;
import com.example.myapplication.Domain.Model.ThanhToan;
import com.example.myapplication.Domain.Model.VanChuyen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Hung_test {
    public Hung_test() {
    }

    public List<DiaChi> getListDC(){
        List<DiaChi> list = new ArrayList<>();

        // Tạo dữ liệu mẫu cho Địa chỉ
        DiaChi diaChi1 = new DiaChi();
        diaChi1.setTenDiaChi("Địa chỉ 1");
        diaChi1.setNguoiNhan("Người nhận 1");
        diaChi1.setSDT("123456789");
        diaChi1.setDiaChi("123 Đường Hòa Bình, Quận 10, Thành phố HCM");
        diaChi1.setGhiChu("Ghi chú 1");
        list.add(diaChi1);

        DiaChi diaChi2 = new DiaChi();
        diaChi2.setTenDiaChi("Địa chỉ 2");
        diaChi2.setNguoiNhan("Người nhận 2");
        diaChi2.setSDT("987654321");
        diaChi2.setDiaChi("456 Đường E, Quận 2, Thành phố HCM");
        diaChi2.setGhiChu("Ghi chú 2");
        list.add(diaChi2);

        return list;
    }
    public List<VanChuyen> getListVC(){
        List<VanChuyen> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        VanChuyen vanChuyen1 = new VanChuyen();
        vanChuyen1.setTen("Gia Hung");
        vanChuyen1.setNgayGiao("30/11/2002");
//        try {
//            vanChuyen1.setNgayGiao(formatter.parse("11/05/2024"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        list.add(vanChuyen1);

        return list;
    }

    public List<KhuyenMai> getListKM(){
        List<KhuyenMai> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        KhuyenMai khuyenMai1 = new KhuyenMai();
        khuyenMai1.setTenKhuyenMai("Mã chào mừng");
        khuyenMai1.setNoiDung("giảm 50%");
        khuyenMai1.setDieuKien("20DEAL");
        khuyenMai1.setToiDaGiam("Min spend $150");
        try {
            khuyenMai1.setHanSuDung(formatter.parse("11/05/2024"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(khuyenMai1);
        return list;
    }
}
