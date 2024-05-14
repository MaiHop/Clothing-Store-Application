package com.example.myapplication.Data.Data_Source;

import com.example.myapplication.Domain.Model.DiaChi;
import com.example.myapplication.Domain.Model.DonHangChiTiet;
import com.example.myapplication.Domain.Model.KhuyenMai;
import com.example.myapplication.Domain.Model.ThanhToan;
import com.example.myapplication.Domain.Model.VanChuyen;

import java.util.ArrayList;
import java.util.List;

public class Hung_test {
    List<DiaChi> listDiaChi;
    List<VanChuyen> listVanChuyen;
    List<ThanhToan> listThanhToan;
    List<KhuyenMai> listKhuyenMai;

    public Hung_test() {
        listDiaChi = new ArrayList<>();
        listVanChuyen = new ArrayList<>();
        listThanhToan = new ArrayList<>();
        listKhuyenMai = new ArrayList<>();

        // Tạo dữ liệu mẫu cho Địa chỉ
        DiaChi diaChi1 = new DiaChi();
        diaChi1.setTenDiaChi("Địa chỉ 1");
        diaChi1.setNguoiNhan("Người nhận 1");
        diaChi1.setSDT("123456789");
        diaChi1.setDiaChi("123 Đường ABC, Quận XYZ, Thành phố HCM");
        diaChi1.setGhiChu("Ghi chú 1");
        listDiaChi.add(diaChi1);

        DiaChi diaChi2 = new DiaChi();
        diaChi2.setTenDiaChi("Địa chỉ 2");
        diaChi2.setNguoiNhan("Người nhận 2");
        diaChi2.setSDT("987654321");
        diaChi2.setDiaChi("456 Đường DEF, Quận UVW, Thành phố HCM");
        diaChi2.setGhiChu("Ghi chú 2");
        listDiaChi.add(diaChi2);

        // Tạo dữ liệu mẫu cho Đơn vị vận chuyển
        VanChuyen vanChuyen1 = new VanChuyen();
        vanChuyen1.setTen("Đơn vị vận chuyển 1");
        vanChuyen1.setNgayGiao("Ngày giao 1");
        vanChuyen1.setGia(100000);
        listVanChuyen.add(vanChuyen1);

        VanChuyen vanChuyen2 = new VanChuyen();
        vanChuyen2.setTen("Đơn vị vận chuyển 2");
        vanChuyen2.setNgayGiao("Ngày giao 2");
        vanChuyen2.setGia(200000);
        listVanChuyen.add(vanChuyen2);

    }
}

