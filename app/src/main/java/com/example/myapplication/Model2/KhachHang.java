package com.example.myapplication.Model2;

import java.io.Serializable;
import java.util.List;

public class KhachHang implements Serializable {

    private Integer idKhachHang;

    private String uid;

    private String imageUrl;

    private String ten;

    private String email;

    private Integer gioiTinh;

    private List<DiaChi> listDiaChi = null;


    private List<ThanhToan> listThanhToan = null;


    private List<SanPham> listYeuThich = null;


    private List<DonHang> listDonHang = null;

    public KhachHang() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
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

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
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

    public List<SanPham> getListYeuThich() {
        return listYeuThich;
    }

    public void setListYeuThich(List<SanPham> listYeuThich) {
        this.listYeuThich = listYeuThich;
    }

    public List<DonHang> getListDonHang() {
        return listDonHang;
    }

    public void setListDonHang(List<DonHang> listDonHang) {
        this.listDonHang = listDonHang;
    }
}
