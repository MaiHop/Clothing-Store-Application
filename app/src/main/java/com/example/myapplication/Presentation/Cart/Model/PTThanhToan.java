package com.example.myapplication.Presentation.Cart.Model;

import java.io.Serializable;

public class PTThanhToan implements Serializable {
    private String TenPhuongThuc, SoThe;
    private boolean checked;
    private int logo;

    public PTThanhToan() {
    }

    public String getSoThe() {
        return SoThe;
    }

    public void setSoThe(String soThe) {
        SoThe = soThe;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTenPhuongThuc() {
        return TenPhuongThuc;
    }

    public void setTenPhuongThuc(String tenPhuongThuc) {
        TenPhuongThuc = tenPhuongThuc;
    }
}
