package com.example.myapplication.Domain.Model;

import java.io.Serializable;

public class VanChuyen implements Serializable {
    private String Id, Ten, NgayGiao, ImageURL;
    private double Gia;
    private boolean checked;

    public VanChuyen() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getNgayGiao() {
        return NgayGiao;
    }

    public void setNgayGiao(String ngayGiao) {
        NgayGiao = ngayGiao;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double gia) {
        Gia = gia;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
