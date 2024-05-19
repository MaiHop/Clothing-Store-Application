package com.example.myapplication.Model2;

import java.io.Serializable;
import java.util.Date;

public class VanChuyen implements Serializable {

    private Integer idVanChuyen;

    private String ten;

    private Date ngayGiao;

    private String imageURL;

    private Double gia;

    public VanChuyen() {
    }

    public Integer getIdVanChuyen() {
        return idVanChuyen;
    }

    public void setIdVanChuyen(Integer idVanChuyen) {
        this.idVanChuyen = idVanChuyen;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }
}
