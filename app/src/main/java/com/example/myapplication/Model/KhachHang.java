package com.example.myapplication.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class KhachHang implements Serializable {
    private String idKhachHang, imageUrl, ten, email;
    private int gioiTinh;
    private List<DiaChi> listDiaChi = null;
    private List<ThanhToan> listThanhToan = null;
    private List<SanPham_V2> listYeuThich = null;
    private List<DonHang> listDonHang = null;

    public KhachHang() {
    }

    public List<SanPham_V2> getListYeuThich() {
        return listYeuThich;
    }

    public void setListYeuThich(List<SanPham_V2> listYeuThich) {
        this.listYeuThich = listYeuThich;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public List<DiaChi> getListDiaChi() {
        return listDiaChi;
    }

    public void setListDiaChi(List<DiaChi> listDiaChi) {
        this.listDiaChi = listDiaChi;
    }

    public List<ThanhToan> getListThanhToan() {
        return listThanhToan;
    }

    public void setListThanhToan(List<ThanhToan> listThanhToan) {
        this.listThanhToan = listThanhToan;
    }


    public List<DonHang> getListDonHang() {
        return listDonHang;
    }

    public void setListDonHang(List<DonHang> listDonHang) {
        this.listDonHang = listDonHang;
    }
}
