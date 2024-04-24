package com.example.myapplication.Presentation.Cart.Model;

import java.io.Serializable;
import java.util.Date;

public class KhuyenMai implements Serializable {
    private String IdKhuyenMai,TenKhuyenMai, NoiDung, DieuKien, ToiDaGiam;
    private Date HanSuDung;
    private boolean checked, TrangThai;

    public KhuyenMai() {
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean trangThai) {
        TrangThai = trangThai;
    }

    public String getIdKhuyenMai() {
        return IdKhuyenMai;
    }

    public void setIdKhuyenMai(String idKhuyenMai) {
        IdKhuyenMai = idKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return TenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        TenKhuyenMai = tenKhuyenMai;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getDieuKien() {
        return DieuKien;
    }

    public void setDieuKien(String dieuKien) {
        DieuKien = dieuKien;
    }

    public String getToiDaGiam() {
        return ToiDaGiam;
    }

    public void setToiDaGiam(String toiDaGiam) {
        ToiDaGiam = toiDaGiam;
    }

    public Date getHanSuDung() {
        return HanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        HanSuDung = hanSuDung;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
