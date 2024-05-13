package com.example.myapplication.Domain.Model;

import java.io.Serializable;
import java.util.List;

public class SanPham implements Serializable {
    private  String Id;
    private String IdSanPham, ImageUrl, TenSanPham, ThongTin;
    private double Giaban;
    private int SoLuong, SoLuongBan;
    private NhomSP NhomSanPham = null;
    private LoaiSP LoaiSanPham = null;
    private KieuSP KieuSanPham = null;
    private KichThuoc KichThuoc = null;
    private Mau Mau= null;
    private List<DanhGia> ListDanhGia= null;
    private List<KhuyenMai> ListKhuyenMai= null;

    public SanPham() {
    }

    public LoaiSP getLoaiSanPham() {
        return LoaiSanPham;
    }

    public void setLoaiSanPham(LoaiSP loaiSanPham) {
        LoaiSanPham = loaiSanPham;
    }

    public KieuSP getKieuSanPham() {
        return KieuSanPham;
    }

    public void setKieuSanPham(KieuSP kieuSanPham) {
        KieuSanPham = kieuSanPham;
    }

    public com.example.myapplication.Domain.Model.KichThuoc getKichThuoc() {
        return KichThuoc;
    }

    public void setKichThuoc(com.example.myapplication.Domain.Model.KichThuoc kichThuoc) {
        KichThuoc = kichThuoc;
    }

    public String getIdSanPham() {
        return IdSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        IdSanPham = idSanPham;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public String getThongTin() {
        return ThongTin;
    }

    public void setThongTin(String thongTin) {
        ThongTin = thongTin;
    }

    public double getGiaban() {
        return Giaban;
    }

    public void setGiaban(double giaban) {
        Giaban = giaban;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getSoLuongBan() {
        return SoLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        SoLuongBan = soLuongBan;
    }

    public NhomSP getNhomSanPham() {
        return NhomSanPham;
    }

    public void setNhomSanPham(NhomSP nhomSanPham) {
        NhomSanPham = nhomSanPham;
    }

    public com.example.myapplication.Domain.Model.Mau getMau() {
        return Mau;
    }

    public void setMau(com.example.myapplication.Domain.Model.Mau mau) {
        Mau = mau;
    }

    public List<DanhGia> getListDanhGia() {
        return ListDanhGia;
    }

    public void setListDanhGia(List<DanhGia> listDanhGia) {
        ListDanhGia = listDanhGia;
    }

    public List<KhuyenMai> getListKhuyenMai() {
        return ListKhuyenMai;
    }

    public void setListKhuyenMai(List<KhuyenMai> listKhuyenMai) {
        ListKhuyenMai = listKhuyenMai;
    }
}
