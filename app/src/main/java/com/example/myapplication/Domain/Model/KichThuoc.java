package com.example.myapplication.Domain.Model;

import java.io.Serializable;

public class KichThuoc implements Serializable {
    private String id, Ten;
    private boolean Checked, Able;
    public KichThuoc() {
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
