package com.example.myapplication.Domain.Model;

import java.io.Serializable;

public class DonHangChiTiet implements Serializable {
    private String  idDonHang;
    private SanPham sanPham;
    private int soLuong;
    private double thanhTien, thanhTienKhuyenMai;
    private boolean checked;

    public DonHangChiTiet() {
    }

    public String getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(String idDonHang) {
        this.idDonHang = idDonHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double getThanhTienKhuyenMai() {
        return thanhTienKhuyenMai;
    }

    public void setThanhTienKhuyenMai(double thanhTienKhuyenMai) {
        this.thanhTienKhuyenMai = thanhTienKhuyenMai;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
