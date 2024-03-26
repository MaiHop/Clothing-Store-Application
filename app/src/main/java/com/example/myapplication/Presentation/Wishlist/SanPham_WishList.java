package com.example.myapplication.Presentation.Wishlist;

public class SanPham_WishList {
    private String tenSP;
    private String gia;
    private int hinh;

    public SanPham_WishList(String tenSP, String gia, int hinh) {
        this.tenSP = tenSP;
        this.gia = gia;
        this.hinh = hinh;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
