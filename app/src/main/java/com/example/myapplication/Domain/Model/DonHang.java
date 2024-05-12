package com.example.myapplication.Domain.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DonHang implements Serializable {
    private String IdDonHang, TrangThai;
    private KhachHang KhachHang= null;
    private DiaChi diachi = null;
    private VanChuyen vanchuyen= null;
    private ThanhToan thanhToan = null;
    private int TongSoLuong = 0;
    private double ThanhTien =0, PhiDichVu=0, PhiGiaoHang=0, Thue=0, TienKhuyenMai=0, TongTien=0;
    private boolean ThanhToan = false;
    private Date NgayThanhToan;
    private List<DonHangChiTiet> ListDonHangChiTiet = null;
    private List<KhuyenMai> ListKhuyenMai = null;

    public DonHang() {
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        NgayThanhToan = ngayThanhToan;
    }

    public double getTienKhuyenMai() {
        return TienKhuyenMai;
    }

    public boolean isThanhToan() {
        return ThanhToan;
    }

    public void setThanhToan(boolean ThanhToan) {
        this.ThanhToan = ThanhToan;
    }

    public String getIdDonHang() {
        return IdDonHang;
    }

    public void setIdDonHang(String id) {
        this.IdDonHang = id;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public com.example.myapplication.Domain.Model.KhachHang getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(com.example.myapplication.Domain.Model.KhachHang khachHang) {
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



    public int getTongSoLuong() {
        return TongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        TongSoLuong = tongSoLuong;
    }

    public double getThanhTien() {
        ThanhTien =0;
        for(DonHangChiTiet dhct : getListDonHangChiTiet()){
            ThanhTien += dhct.getThanhTien();
        }
        return ThanhTien;
    }

    public void setThanhTien(double thanhTien) {
        ThanhTien = thanhTien;
    }

    public double getPhiDichVu() {
        PhiDichVu = ThanhTien * 0.08;
        return PhiDichVu;
    }

    public void setPhiDichVu(double phiDichVu) {
        PhiDichVu = phiDichVu;
    }

    public double getPhiGiaoHang() {
        return PhiGiaoHang;
    }

    public void setPhiGiaoHang(double phiGiaoHang) {
        PhiGiaoHang = phiGiaoHang;
    }

    public double getThue() {
        Thue = ThanhTien * 0.1;
        return Thue;
    }

    public void setThue(double thue) {
        Thue = thue;
    }

//    public double getTienKhuyenMai() {
//        if(khuyenmai != null){
//            TienKhuyenMai = Double.parseDouble(khuyenmai.getToiDaGiam());
//        }else {
//            TienKhuyenMai =0;
//        }
//
//        return TienKhuyenMai;
//    }

    public void setTienKhuyenMai(double tienKhuyenMai) {
        TienKhuyenMai = tienKhuyenMai;
    }

    public double getTongTien() {
        TongTien = 0;
        TongTien = ThanhTien + PhiDichVu + PhiGiaoHang + Thue - TienKhuyenMai;
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
