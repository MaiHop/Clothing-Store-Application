package com.example.myapplication.Domain.Model;

import java.io.Serializable;

public class YeuThich implements Serializable {
    private String IdYeuThich;
    private KhachHang khachhang;
    private SanPham sanpham;

    public YeuThich() {
    }

    public String getIdYeuThich() {
        return IdYeuThich;
    }

    public void setIdYeuThich(String idYeuThich) {
        IdYeuThich = idYeuThich;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }
}
