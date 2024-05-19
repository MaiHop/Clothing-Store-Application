package com.example.myapplication.Model2;

import java.io.Serializable;

public class ThanhToan implements Serializable {

    private Integer idThanhToan;

    private String loai;

    private String trangThai;

    private String imageUrl;


    private KhachHang khachhang = null;

    public Integer getIdThanhToan() {
        return idThanhToan;
    }

    public void setIdThanhToan(Integer idThanhToan) {
        this.idThanhToan = idThanhToan;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }
}
