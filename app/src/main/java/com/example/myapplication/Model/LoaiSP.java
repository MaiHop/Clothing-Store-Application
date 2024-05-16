package com.example.myapplication.Model;

import java.io.Serializable;
import java.util.List;

public class LoaiSP implements Serializable {
    private String id, ten, imageURL;
    private List<KieuSP> listKieuSP;
    public LoaiSP() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
