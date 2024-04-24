package com.example.myapplication.Presentation.Homepage.phuchoi.Model;

import java.io.Serializable;
import java.util.List;

public class DonHang implements Serializable {
    private String IdDonHang, TrangThai;
    private KhachHang KhachHang= null;
    private DiaChi diachi = null;
    private VanChuyen vanchuyen= null;
    private ThanhToan thanhToan = null;
    private KhuyenMai khuyenmai= null;
    private int TongSoLuong;
    private double ThanhTien =0, PhiPhucVu=0, PhiGiaoHang=0, Thue=0, TienKhuyenMai=0, TongTien=0;
    private List<DonHangChiTiet> ListDonHangChiTiet = null;
    private List<KhuyenMai> ListKhuyenMai = null;

    public DonHang() {
    }

    public String getIdDonHang() {
        return IdDonHang;
    }

    public void setIdDonHang(String idDonHang) {
        IdDonHang = idDonHang;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public com.example.myapplication.Presentation.Homepage.phuchoi.Model.KhachHang getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(com.example.myapplication.Presentation.Homepage.phuchoi.Model.KhachHang khachHang) {
        KhachHang = khachHang;
    }

    public DiaChi getDiachi() {
        return diachi;
    }

    public void setDiachi(DiaChi diachi) {
        this.diachi = diachi;
    }

    public VanChuyen getVanchuyen() {
        return vanchuyen;
    }

    public void setVanchuyen(VanChuyen vanchuyen) {
        this.vanchuyen = vanchuyen;
    }

    public ThanhToan getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(ThanhToan thanhToan) {
        this.thanhToan = thanhToan;
    }

    public KhuyenMai getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(KhuyenMai khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    public int getTongSoLuong() {
        return TongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        TongSoLuong = tongSoLuong;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double thanhTien) {
        ThanhTien = thanhTien;
    }

    public double getPhiPhucVu() {
        return PhiPhucVu;
    }

    public void setPhiPhucVu(double phiPhucVu) {
        PhiPhucVu = phiPhucVu;
    }

    public double getPhiGiaoHang() {
        return PhiGiaoHang;
    }

    public void setPhiGiaoHang(double phiGiaoHang) {
        PhiGiaoHang = phiGiaoHang;
    }

    public double getThue() {
        return Thue;
    }

    public void setThue(double thue) {
        Thue = thue;
    }

    public double getTienKhuyenMai() {
        return TienKhuyenMai;
    }

    public void setTienKhuyenMai(double tienKhuyenMai) {
        TienKhuyenMai = tienKhuyenMai;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double tongTien) {
        TongTien = tongTien;
    }

    public List<DonHangChiTiet> getListDonHangChiTiet() {
        return ListDonHangChiTiet;
    }

    public void setListDonHangChiTiet(List<DonHangChiTiet> listDonHangChiTiet) {
        ListDonHangChiTiet = listDonHangChiTiet;
    }

    public List<KhuyenMai> getListKhuyenMai() {
        return ListKhuyenMai;
    }

    public void setListKhuyenMai(List<KhuyenMai> listKhuyenMai) {
        ListKhuyenMai = listKhuyenMai;
    }
}
