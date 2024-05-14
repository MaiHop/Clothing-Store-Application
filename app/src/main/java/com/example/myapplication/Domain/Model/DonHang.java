package com.example.myapplication.Domain.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DonHang implements Serializable {
    private String idDonHang, trangThai;
    private KhachHang khachHang= null;
    private DiaChi diachi = null;
    private VanChuyen vanchuyen= null;
    private ThanhToan thanhToan = null;
    private KhuyenMai khuyenmai= null;
    private int tongSoLuong;
    private double thanhTien =0, phiDichVu=0, phiGiaoHang=0, thue=0, tienKhuyenMai=0, tongTien=0;
    private List<DonHangChiTiet> listDonHangChiTiet = null;
    private List<KhuyenMai> listKhuyenMai = null;
    private Date ngayThanhToan;
    public DonHang() {
    }

    public String getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(String idDonHang) {
        this.idDonHang = idDonHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
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
        return tongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        tongSoLuong = tongSoLuong;
    }

    public double getThanhTien() {
        thanhTien =0;
        for(DonHangChiTiet dhct : getListDonHangChiTiet()){
            thanhTien += dhct.getThanhTien();
        }
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double getphiDichVu() {
        phiDichVu = thanhTien * 0.08;
        return phiDichVu;
    }

    public void setphiDichVu(double phiDichVu) {
        this.phiDichVu = phiDichVu;
    }

    public double getPhiGiaoHang() {
        return phiGiaoHang;
    }

    public void setPhiGiaoHang(double phiGiaoHang) {
        this.phiGiaoHang = phiGiaoHang;
    }

    public double getThue() {
        thue = thanhTien * 0.1;
        return thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    public double getTienKhuyenMai() {
        if(khuyenmai != null){
            tienKhuyenMai = Double.parseDouble(khuyenmai.getToiDaGiam());
        }else {
            tienKhuyenMai =0;
        }

        return tienKhuyenMai;
    }

    public void setTienKhuyenMai(double tienKhuyenMai) {
        tienKhuyenMai = tienKhuyenMai;
    }

    public double getTongTien() {
        this.tongTien = 0;
        this.tongTien = thanhTien + phiDichVu + phiGiaoHang + thue - tienKhuyenMai;
        return this.tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public List<DonHangChiTiet> getListDonHangChiTiet() {
        return listDonHangChiTiet;
    }

    public void setListDonHangChiTiet(List<DonHangChiTiet> listDonHangChiTiet) {
        this.listDonHangChiTiet = listDonHangChiTiet;
    }

    public List<KhuyenMai> getListKhuyenMai() {
        return listKhuyenMai;
    }

    public void setListKhuyenMai(List<KhuyenMai> listKhuyenMai) {
        this.listKhuyenMai = listKhuyenMai;
    }
}
