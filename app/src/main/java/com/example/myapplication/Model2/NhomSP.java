package com.example.myapplication.Model2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NhomSP implements Serializable {
    private Integer idNhomSP;

    private String ten;


    public Integer getIdNhomSP() {
        return idNhomSP;
    }

    public void setIdNhomSP(Integer idNhomSP) {
        this.idNhomSP = idNhomSP;
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

    public List<LoaiSP> getListLoaiSP() {
        return listLoaiSP;
    }

    public void setListLoaiSP(List<LoaiSP> listLoaiSP) {
        this.listLoaiSP = listLoaiSP;
    }

    private String imageURL;


    private List<LoaiSP> listLoaiSP = new ArrayList<>();
}
