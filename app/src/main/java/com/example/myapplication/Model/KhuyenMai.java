package com.example.myapplication.Model;

import java.io.Serializable;
import java.util.Date;

public class KhuyenMai implements Serializable {
    private String idKhuyenMai,tenKhuyenMai, noiDung, dieuKien, toiDaGiam;
    private Date hanSuDung;
    private boolean checked, trangThai= true,trangThaiSD=false;

    public KhuyenMai() {
    }

    public String getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(String idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(String dieuKien) {
        this.dieuKien = dieuKien;
    }

    public String getToiDaGiam() {
        return toiDaGiam;
    }

    public void setToiDaGiam(String toiDaGiam) {
        this.toiDaGiam = toiDaGiam;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isTrangThaiSD() {
        return trangThaiSD;
    }

    public void setTrangThaiSD(boolean trangThaiSD) {
        this.trangThaiSD = trangThaiSD;
    }
}
