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
    List<ThanhToan> ListThanhToan;
    List<KhuyenMai> ListKhuyenMai;

    public Hung_test() {
    }

    public List<DiaChi> getListDiaChi() {
        DiaChi dc1 = new DiaChi();
        dc1.setTenDiaChi("Home");
        dc1.setNguoiNhan("Hùng");
        dc1.setSDT("123456789");
        dc1.setDiaChi("457 Hậu Giang");
        return listDiaChi;
    }
}
