package com.example.myapplication.Presentation.Homepage.phuchoi.Model;

import java.io.Serializable;

public class KieuSP implements Serializable {
    private String id, ten;

    public KieuSP() {
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
