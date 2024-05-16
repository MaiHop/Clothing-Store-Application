package com.example.myapplication.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SanPham_V2 implements Serializable {

    private String id, idSanPham, tenSanPham, thongTin;
    private NhomSP nhomSanPham = null;
    private LoaiSP loaiSanPham = null;
    private KieuSP kieuSanPham = null;
    private Mau mau= null;
    private KichThuoc kichThuoc = null;
    private Date ngayTao;
    private List<Kho> listKho;

    public SanPham_V2() {
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

    public Mau getMau() {
        return mau;
    }

    public void setMau(Mau mau) {
        this.mau = mau;
    }

    public KichThuoc getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(KichThuoc kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public List<Kho> getListKho() {
        return listKho;
    }

    public void setListKho(List<Kho> listKho) {
        this.listKho = listKho;
    }

}
