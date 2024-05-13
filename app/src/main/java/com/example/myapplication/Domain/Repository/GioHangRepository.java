package com.example.myapplication.Domain.Repository;

import com.example.myapplication.Domain.Model.DonHangChiTiet;

import java.util.List;

public interface GioHangRepository {
    public List<DonHangChiTiet> getGioHang();
    public boolean AddGioHang(DonHangChiTiet dhct);
    public boolean UpdateGioHang(DonHangChiTiet dhct);
    public boolean DeleteGioHang(String IdDonHang);
}
