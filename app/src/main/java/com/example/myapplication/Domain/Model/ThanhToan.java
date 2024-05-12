package com.example.myapplication.Domain.Model;

import java.io.Serializable;

public class ThanhToan implements Serializable {
    private String IdThanhToan, Loai, ImageUrl, TrangThai;
    private KhachHang khachHang;
    private boolean checked;

    public ThanhToan() {
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getIdThanhToan() {
        return IdThanhToan;
    }

    public void setIdThanhToan(String idThanhToan) {
        IdThanhToan = idThanhToan;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
