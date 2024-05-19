package com.example.myapplication.Model2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KieuSP implements Serializable {

    private Integer idKieuSP;

    private String ten;


    private List<LoaiSP> listLoaiSP = new ArrayList<>();

    public Integer getIdKieuSP() {
        return idKieuSP;
    }

    public void setIdKieuSP(Integer idKieuSP) {
        this.idKieuSP = idKieuSP;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<LoaiSP> getListLoaiSP() {
        return listLoaiSP;
    }

    public void setListLoaiSP(List<LoaiSP> listLoaiSP) {
        this.listLoaiSP = listLoaiSP;
    }
}
