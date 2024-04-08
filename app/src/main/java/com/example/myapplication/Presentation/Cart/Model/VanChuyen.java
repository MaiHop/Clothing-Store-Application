package com.example.myapplication.Presentation.Cart.Model;

import java.io.Serializable;

public class VanChuyen implements Serializable {
    private String TenDonVI, ThoiGian;
    private double GiaTien;
    private boolean checked;
    private int logo;

    public boolean isChecked() {
        return checked;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public VanChuyen() {
    }

    public String getTenDonVI() {
        return TenDonVI;
    }

    public void setTenDonVI(String tenDonVI) {
        TenDonVI = tenDonVI;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }

    public double getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(double giaTien) {
        GiaTien = giaTien;
    }
}
