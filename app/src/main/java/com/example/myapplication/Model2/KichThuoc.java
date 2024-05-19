package com.example.myapplication.Model2;

import java.io.Serializable;

public class KichThuoc implements Serializable {
    private Integer idKichThuoc;

    private String ten;

    public Integer getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(Integer idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
