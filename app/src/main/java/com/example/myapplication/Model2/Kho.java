package com.example.myapplication.Model2;

import java.io.Serializable;
import java.util.List;

public class Kho implements Serializable {

    private Integer idKho;

    private String imageURL;

    private Double giaBan ;

    private Double giaKhuyenMai ;


    private SanPham sanpham = null;


    private Mau mau = null;



    private List<DacDiem> listDacDiem = null;

    public Integer getIdKho() {
        return idKho;
    }

    public void setIdKho(Integer idKho) {
        this.idKho = idKho;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Double getGiaKhuyenMai() {
        return giaKhuyenMai;
    }

    public void setGiaKhuyenMai(Double giaKhuyenMai) {
        this.giaKhuyenMai = giaKhuyenMai;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
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
