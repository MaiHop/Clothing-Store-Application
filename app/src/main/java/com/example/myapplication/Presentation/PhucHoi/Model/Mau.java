package com.example.myapplication.Presentation.PhucHoi.Model;

import java.io.Serializable;

public class Mau implements Serializable {
    private String Id, Ten, ImgUrl;
    private boolean Checked, Able = true;
    public Mau() {
    }

    public boolean isAble() {
        return Able;
    }

    public void setAble(boolean able) {
        Able = able;
    }

    public boolean isChecked() {
        return Checked;
    }

    public void setChecked(boolean checked) {
        Checked = checked;
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
