package com.example.myapplication.Model2;

import java.io.Serializable;
import java.util.Date;

public class KhuyenMai implements Serializable {

    private Integer idKhuyenMai;

    private String tenKhuyenMai;

    private String noiDung;

    private String dieuKien;

    private String toiDaGiam;

    private Date hanSuDung;

    private boolean trangThai= true;

    private boolean trangThaiSD=false;



    private SanPham sanpham;


    private DonHang donhang;

    private KhachHang khachhang;

    public Integer getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(Integer idKhuyenMai) {
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

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public DonHang getDonhang() {
        return donhang;
    }

    public void setDonhang(DonHang donhang) {
        this.donhang = donhang;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }
}
