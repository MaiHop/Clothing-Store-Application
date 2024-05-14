package com.example.myapplication.Domain.Model;

import java.io.Serializable;
import java.util.List;

public class LoaiSP implements Serializable {
    private String id, ten;
    private List<KieuSP> listKieuSP;
    public LoaiSP() {
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
