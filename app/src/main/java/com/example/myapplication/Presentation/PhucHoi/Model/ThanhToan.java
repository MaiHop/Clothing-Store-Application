package com.example.myapplication.Presentation.PhucHoi.Model;

import java.io.Serializable;

public class ThanhToan implements Serializable {
    private String IdThanhToan,TenThanhToan, HanSuDung, CVV, Loai, ImageUrl;
    private boolean checked;

    public ThanhToan() {
    }

    public String getIdThanhToan() {
        return IdThanhToan;
    }

    public void setIdThanhToan(String idThanhToan) {
        IdThanhToan = idThanhToan;
    }

    public String getTenThanhToan() {
        return TenThanhToan;
    }

    public void setTenThanhToan(String tenThanhToan) {
        TenThanhToan = tenThanhToan;
    }

    public String getHanSuDung() {
        return HanSuDung;
    }

    public void setHanSuDung(String hanSuDung) {
        HanSuDung = hanSuDung;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
