package com.example.myapplication.Presentation.Cart.Model;

import java.io.Serializable;

public class DiaChi implements Serializable {
    private String id, TenDiaChi,NguoiNhan, SDT, DiaChi;
    private boolean XacDinh, checked, DiaChiChinh;

    public DiaChi() {
    }

    public boolean isDiaChiChinh() {
        return DiaChiChinh;
    }

    public void setDiaChiChinh(boolean diaChiChinh) {
        DiaChiChinh = diaChiChinh;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDiaChi() {
        return TenDiaChi;
    }

    public void setTenDiaChi(String tenDiaChi) {
        TenDiaChi = tenDiaChi;
    }

    public String getNguoiNhan() {
        return NguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        NguoiNhan = nguoiNhan;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public boolean isXacDinh() {
        return XacDinh;
    }

    public void setXacDinh(boolean xacDinh) {
        XacDinh = xacDinh;
    }
}
