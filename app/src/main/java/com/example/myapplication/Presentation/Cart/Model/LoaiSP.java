package com.example.myapplication.Presentation.Cart.Model;

import java.io.Serializable;
import java.util.List;

public class LoaiSP implements Serializable {
    private String id, ten;
    private List<KieuSP> ListKieuSP;
    public LoaiSP() {
    }

    public List<KieuSP> getListKieuSP() {
        return ListKieuSP;
    }

    public void setListKieuSP(List<KieuSP> listKieuSP) {
        ListKieuSP = listKieuSP;
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
