package com.example.myapplication.Model2;

import java.io.Serializable;
import java.util.Date;

public class DanhGia implements Serializable {

    private Integer idDanhGia;

    private String nhanXet;

    private Date ngayDanhGia;

    private Double diemDanhGia;

    private KhachHang khachHang;

    private SanPham sanpham;

    public DanhGia() {
    }

    public Integer getIdDanhGia() {
        return idDanhGia;
    }

    public void setIdDanhGia(Integer idDanhGia) {
        this.idDanhGia = idDanhGia;
    }

    public String getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
    }

    public Date getNgayDanhGia() {
        return ngayDanhGia;
    }

    public void setNgayDanhGia(Date ngayDanhGia) {
        this.ngayDanhGia = ngayDanhGia;
    }

    public Double getDiemDanhGia() {
        return diemDanhGia;
    }

    public void setDiemDanhGia(Double diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }
}
