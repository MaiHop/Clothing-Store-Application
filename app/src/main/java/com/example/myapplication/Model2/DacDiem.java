package com.example.myapplication.Model2;


import java.io.Serializable;


public class DacDiem implements Serializable {

    private Integer idDacDiem;

    private Integer soLuong =0;

    private Integer soLuongBan=0;


    private KichThuoc kichThuoc =null;

    private Kho kho;

    public Integer getIdDacDiem() {
        return idDacDiem;
    }

    public void setIdDacDiem(Integer idDacDiem) {
        this.idDacDiem = idDacDiem;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(Integer soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public KichThuoc getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(KichThuoc kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public Kho getKho() {
        return kho;
    }

    public void setKho(Kho kho) {
        this.kho = kho;
    }
}
