package com.example.myapplication.Domain.Model;

import java.io.Serializable;

public class DonHangChiTiet implements Serializable {
    private String  IdDonHang;
    private SanPham SanPham;
    private int SoLuong=1;
    private double ThanhTien=0, ThanhTienKhuyenMai=0;
    private boolean checked;

    public DonHangChiTiet() {
    }

    public String getIdDonHang() {
        return IdDonHang;
    }

    public void setIdDonHang(String idDonHang) {
        IdDonHang = idDonHang;
    }

    public com.example.myapplication.Domain.Model.SanPham getSanPham() {
        return SanPham;
    }

    public void setSanPham(com.example.myapplication.Domain.Model.SanPham sanPham) {
        SanPham = sanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double thanhTien) {
        ThanhTien = thanhTien;
    }

    public double getThanhTienKhuyenMai() {
        return ThanhTienKhuyenMai;
    }

    public void setThanhTienKhuyenMai(double thanhTienKhuyenMai) {
        ThanhTienKhuyenMai = thanhTienKhuyenMai;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
