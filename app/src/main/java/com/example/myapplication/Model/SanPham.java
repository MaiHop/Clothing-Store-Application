package com.example.myapplication.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SanPham implements Serializable {
    private String id, idSanPham, imageUrl, tenSanPham, thongTin;
    private double giaban;
    private int soLuong, soLuongBan;
    private NhomSP nhomSanPham = null;
    private LoaiSP loaiSanPham = null;
    private KieuSP kieuSanPham = null;
    private KichThuoc kichThuoc = null;
    private Mau mau= null;
    private Date ngayTao;

    public SanPham() {
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public NhomSP getNhomSanPham() {
        return nhomSanPham;
    }

    public void setNhomSanPham(NhomSP nhomSanPham) {
        this.nhomSanPham = nhomSanPham;
    }

    public LoaiSP getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSP loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public KieuSP getKieuSanPham() {
        return kieuSanPham;
    }

    public void setKieuSanPham(KieuSP kieuSanPham) {
        this.kieuSanPham = kieuSanPham;
    }

    public KichThuoc getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(KichThuoc kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public Mau getMau() {
        return mau;
    }

    public void setMau(Mau mau) {
        this.mau = mau;
    }

}
