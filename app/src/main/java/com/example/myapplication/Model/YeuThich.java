package com.example.myapplication.Model;

import java.io.Serializable;
import java.util.List;

public class YeuThich implements Serializable {
    private String IdYeuThich;
    private KhachHang khachhang;
    private List<SanPham> listsanpham;

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

    public List<SanPham> getListsanpham() {
        return listsanpham;
    }

    public void setListsanpham(List<SanPham> listsanpham) {
        this.listsanpham = listsanpham;
    }
}
