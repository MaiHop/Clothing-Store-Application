package com.example.myapplication.Presentation.phuchoi.Model;

import java.io.Serializable;

public class DiaChi implements Serializable {
    private String IdDiaChi, TenDiaChi,NguoiNhan, SDT, DiaChi, GhiChu;
    private boolean XacDinh, checked, DiaChiChinh;

    public DiaChi() {
    }

    public String getIdDiaChi() {
        return IdDiaChi;
    }

    public void setIdDiaChi(String idDiaChi) {
        IdDiaChi = idDiaChi;
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

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public boolean isXacDinh() {
        return XacDinh;
    }

    public void setXacDinh(boolean xacDinh) {
        XacDinh = xacDinh;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isDiaChiChinh() {
        return DiaChiChinh;
    }

    public void setDiaChiChinh(boolean diaChiChinh) {
        DiaChiChinh = diaChiChinh;
    }
}
