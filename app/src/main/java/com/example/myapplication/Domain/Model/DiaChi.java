package com.example.myapplication.Domain.Model;

import java.io.Serializable;

public class DiaChi implements Serializable {
    private String idDiaChi, tenDiaChi,nguoiNhan, sDT, diaChi, ghiChu;
    private boolean xacDinh, checked, diaChiChinh;

    public DiaChi() {
    }

    public String getIdDiaChi() {
        return idDiaChi;
    }

    public void setIdDiaChi(String idDiaChi) {
        this.idDiaChi = idDiaChi;
    }

    public String getTenDiaChi() {
        return tenDiaChi;
    }

    public void setTenDiaChi(String tenDiaChi) {
        this.tenDiaChi = tenDiaChi;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isXacDinh() {
        return xacDinh;
    }

    public void setXacDinh(boolean xacDinh) {
        this.xacDinh = xacDinh;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isDiaChiChinh() {
        return diaChiChinh;
    }

    public void setDiaChiChinh(boolean diaChiChinh) {
        this.diaChiChinh = diaChiChinh;
    }
}
