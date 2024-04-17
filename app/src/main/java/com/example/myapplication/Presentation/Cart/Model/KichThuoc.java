package com.example.myapplication.Presentation.Cart.Model;

import java.io.Serializable;

public class KichThuoc implements Serializable {
    private String id, Ten;

    public KichThuoc() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }
}
