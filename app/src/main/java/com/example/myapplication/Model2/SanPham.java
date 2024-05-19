package com.example.myapplication.Model2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SanPham implements Serializable {

    private Integer idSanPham;

    private String tenSanPham;

    private String thongTin;


    private Date ngayTao;



    private NhomSP nhomSanPham;



    private LoaiSP loaiSanPham;



    private KieuSP kieuSanPham;



    private List<Kho> listKho;


    private List<KhachHang> listKhachHang = new ArrayList<>();

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
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

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
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

    public List<Kho> getListKho() {
        return listKho;
    }

    public void setListKho(List<Kho> listKho) {
        this.listKho = listKho;
    }

    public List<KhachHang> getListKhachHang() {
        return listKhachHang;
    }

    public void setListKhachHang(List<KhachHang> listKhachHang) {
        this.listKhachHang = listKhachHang;
    }
}
