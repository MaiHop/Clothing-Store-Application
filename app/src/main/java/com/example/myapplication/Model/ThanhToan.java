package com.example.myapplication.Model;

import java.io.Serializable;

public class ThanhToan implements Serializable {
    private String idThanhToan,tenThanhToan, hHanSuDung, cVV, loai, imageUrl;
    private boolean checked;

    public ThanhToan() {
    }

    public String getIdThanhToan() {
        return idThanhToan;
    }

    public void setIdThanhToan(String idThanhToan) {
        this.idThanhToan = idThanhToan;
    }

    public String getTenThanhToan() {
        return tenThanhToan;
    }

    public void setTenThanhToan(String tenThanhToan) {
        this.tenThanhToan = tenThanhToan;
    }

    public String gethHanSuDung() {
        return hHanSuDung;
    }

    public void sethHanSuDung(String hHanSuDung) {
        this.hHanSuDung = hHanSuDung;
    }

    public String getcVV() {
        return cVV;
    }

    public void setcVV(String cVV) {
        this.cVV = cVV;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
