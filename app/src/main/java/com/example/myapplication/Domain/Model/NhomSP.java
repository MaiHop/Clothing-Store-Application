package com.example.myapplication.Domain.Model;

import java.io.Serializable;
import java.util.List;

public class NhomSP implements Serializable {
    private String id, ten;
    private List<LoaiSP> listLoaiSP;
    public NhomSP() {
    }

    public List<LoaiSP> getListLoaiSP() {
        return listLoaiSP;
    }

    public void setListLoaiSP(List<LoaiSP> listLoaiSP) {
        this.listLoaiSP = listLoaiSP;
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
