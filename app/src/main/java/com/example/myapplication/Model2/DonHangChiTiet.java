package com.example.myapplication.Model2;

import java.io.Serializable;

public class DonHangChiTiet implements Serializable {

    private Integer id;

    private Integer soLuong;

    private Double thanhTien ;

    private Double thanhTienKhuyenMai;


    private DonHang  donhang;

    private SanPham sanPham;

    public DonHangChiTiet() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Double getThanhTienKhuyenMai() {
        return thanhTienKhuyenMai;
    }

    public void setThanhTienKhuyenMai(Double thanhTienKhuyenMai) {
        this.thanhTienKhuyenMai = thanhTienKhuyenMai;
    }

    public DonHang getDonhang() {
        return donhang;
    }

    public void setDonhang(DonHang donhang) {
        this.donhang = donhang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
