package com.example.myapplication.Presentation.Cart.Model;

import java.io.Serializable;

public class DonHang implements Serializable {
    private DiaChi diachi = null;
    private VanCHuyen vanchuyen= null;
    private PTThanhToan thanhToan = null;
    private KhuyenMai khuyenmai= null;
    private double ThanhTien =0, PhiPhucVu=0, PhiGiaoHang=0, Thue=0, TienKhuyenMai=0, TongCong=0;

    public DonHang() {
    }

    public DiaChi getDiachi() {
        return diachi;
    }

    public void setDiachi(DiaChi diachi) {
        this.diachi = diachi;
    }

    public VanCHuyen getVanchuyen() {
        return vanchuyen;
    }

    public void setVanchuyen(VanCHuyen vanchuyen) {
        this.vanchuyen = vanchuyen;
    }

    public PTThanhToan getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(PTThanhToan thanhToan) {
        this.thanhToan = thanhToan;
    }

    public KhuyenMai getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(KhuyenMai khuyenmai) {
        this.khuyenmai = khuyenmai;
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

    public double getTongCong() {
        return TongCong;
    }

    public void setTongCong(double tongCong) {
        TongCong = tongCong;
    }
}
