package com.example.myapplication.Model2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoaiSP implements Serializable {

    private Integer idLoaiSP;

    private String ten;


    private String imageURL;

    public Integer getIdLoaiSP() {
        return idLoaiSP;
    }

    public void setIdLoaiSP(Integer idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public List<KieuSP> getListKieuSP() {
        return listKieuSP;
    }

    public void setListKieuSP(List<KieuSP> listKieuSP) {
        this.listKieuSP = listKieuSP;
    }

    public List<NhomSP> getListNhomSP() {
        return listNhomSP;
    }

    public void setListNhomSP(List<NhomSP> listNhomSP) {
        this.listNhomSP = listNhomSP;
    }

    private List<KieuSP> listKieuSP = new ArrayList<>();


    private List<NhomSP> listNhomSP = new ArrayList<>();
}
