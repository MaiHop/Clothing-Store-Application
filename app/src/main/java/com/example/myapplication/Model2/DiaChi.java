package com.example.myapplication.Model2;

import java.io.Serializable;

public class DiaChi implements Serializable {

    private Integer idDiaChi;

    private String tenDiaChi;

    private String nguoiNhan;

    private String sDT;

    private String diaChi;

    private String ghiChu;

    private boolean xacDinh;

    private boolean macDinh;

    private KhachHang khachhang;

    public DiaChi() {
    }

    public Integer getIdDiaChi() {
        return idDiaChi;
    }

    public void setIdDiaChi(Integer idDiaChi) {
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

    public boolean isMacDinh() {
        return macDinh;
    }

    public void setMacDinh(boolean macDinh) {
        this.macDinh = macDinh;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }
}
