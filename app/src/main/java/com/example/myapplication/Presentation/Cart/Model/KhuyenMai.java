package com.example.myapplication.Presentation.Cart.Model;

import java.io.Serializable;

public class KhuyenMai implements Serializable {
    private String TenKhuyenMai, ChiTietKhuyenMai;
    private boolean checked;

    public KhuyenMai() {
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTenKhuyenMai() {
        return TenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        TenKhuyenMai = tenKhuyenMai;
    }

    public String getChiTietKhuyenMai() {
        return ChiTietKhuyenMai;
    }

    public void setChiTietKhuyenMai(String chiTietKhuyenMai) {
        ChiTietKhuyenMai = chiTietKhuyenMai;
    }
}
