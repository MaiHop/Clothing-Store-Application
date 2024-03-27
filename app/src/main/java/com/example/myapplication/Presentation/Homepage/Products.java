package com.example.myapplication.Presentation.Homepage;

import java.io.Serializable;

public class Products implements Serializable {
    private String tilte;
    private int picture;
    private String price;
    private String core;

    public Products(String tilte, int picture, String price, String core) {
        this.tilte = tilte;
        this.picture = picture;
        this.price = price;
        this.core = core;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }
}
