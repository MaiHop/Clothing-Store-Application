package com.example.myapplication.Model;

import java.util.Date;

public class DonHangQuaTrinh {
    private String trangThai, moTa;

    public DonHangQuaTrinh(String trangThai, String moTa, Date ngay) {
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.ngay = ngay;
    }

    private Date ngay;

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
}
