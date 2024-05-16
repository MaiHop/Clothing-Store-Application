package com.example.myapplication.Model;

import java.io.Serializable;
import java.util.List;

public class Kho implements Serializable {
    private String imageURL;
    private double giaBan=0, giaKhuyenMai=0;
    private Mau mau=null;
    private List<DacDiem> listDacDiem =null;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaKhuyenMai() {
        return giaKhuyenMai;
    }

    public void setGiaKhuyenMai(double giaKhuyenMai) {
        this.giaKhuyenMai = giaKhuyenMai;
    }

    public Mau getMau() {
        return mau;
    }

    public void setMau(Mau mau) {
        this.mau = mau;
    }

    public List<DacDiem> getListDacDiem() {
        return listDacDiem;
    }

    public void setListDacDiem(List<DacDiem> listDacDiem) {
        this.listDacDiem = listDacDiem;
    }
}
