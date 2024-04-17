package com.example.myapplication.Presentation.Cart.Model;

import java.io.Serializable;

public class Mau implements Serializable {
    private String Id, Ten, ImgUrl;

    public Mau() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }
}
