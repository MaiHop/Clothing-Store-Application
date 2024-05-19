package com.example.myapplication.Model2;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DonHang implements Serializable {

    private Integer idDonHang;

    private String trangThai;

    private int tongSoLuong;

    private Double thanhTien ;

    private Double phiDichVu;

    private Double phiGiaoHang;

    private Double thue;

    private Double tienKhuyenMai;

    private Double tongTien;

    private boolean thanhToanTrangThai;

    private Date ngayThanhToan;


    private KhachHang khachHang= null;


    private DiaChi diachi = null;


    private VanChuyen vanchuyen= null;


    private ThanhToan thanhToan = null;


    private List<DonHangQuaTrinh> listDonHangQuaTrinh = null;


    private List<DonHangChiTiet> listDonHangChiTiet = null;


    private List<KhuyenMai> listKhuyenMai = null;
    public DonHang() {
    }

    public Integer getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(Integer idDonHang) {
        this.idDonHang = idDonHang;
    }

    public boolean isThanhToanTrangThai() {
        return thanhToanTrangThai;
    }

    public void setThanhToanTrangThai(boolean thanhToanTrangThai) {
        this.thanhToanTrangThai = thanhToanTrangThai;
    }

    public List<DonHangQuaTrinh> getListDonHangQuaTrinh() {
        return listDonHangQuaTrinh;
    }

    public void setListDonHangQuaTrinh(List<DonHangQuaTrinh> listDonHangQuaTrinh) {
        this.listDonHangQuaTrinh = listDonHangQuaTrinh;
    }

    public double getPhiDichVu() {
        return phiDichVu;
    }

    public void setPhiDichVu(double phiDichVu) {
        this.phiDichVu = phiDichVu;
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



    public int getTongSoLuong() {
        return tongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }

    public double getThanhTien() {
        this.thanhTien = (double) 0;
        for(DonHangChiTiet dhct : getListDonHangChiTiet()){
            this.thanhTien += dhct.getThanhTien();
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
        for(KhuyenMai km : listKhuyenMai){
            if(km != null){
                tienKhuyenMai += Double.parseDouble(km.getToiDaGiam());
            }
        }


        return tienKhuyenMai;
    }

    public void setTienKhuyenMai(double tienKhuyenMai) {
        this.tienKhuyenMai = tienKhuyenMai;
    }

    public double getTongTien() {
        this.tongTien = (double) 0;
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
