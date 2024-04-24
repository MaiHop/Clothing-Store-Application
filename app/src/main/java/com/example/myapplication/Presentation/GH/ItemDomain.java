package com.example.myapplication.Presentation.GH;

import java.io.Serializable;

public class ItemDomain implements Serializable {
    private String date;
    private int pic;
    private String title;
    private String price;

    public ItemDomain(String date, int pic, String title, String price) {
        this.date = date;
        this.pic = pic;
        this.title = title;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
