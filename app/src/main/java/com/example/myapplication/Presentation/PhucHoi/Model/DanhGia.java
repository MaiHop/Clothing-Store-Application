package com.example.myapplication.Presentation.PhucHoi.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DanhGia implements Serializable {
    private String IdDanhGia, NhanXet;
    private KhachHang KhachHang;
    private Date NgayDanhGia;
    private double DiemDanhGia;
    private SanPham sanpham;
    private List<String> ListImage = null;

    public DanhGia() {
    }

    public String getIdDanhGia() {
        return IdDanhGia;
    }

    public void setIdDanhGia(String idDanhGia) {
        IdDanhGia = idDanhGia;
    }

    public String getNhanXet() {
        return NhanXet;
    }

    public void setNhanXet(String nhanXet) {
        NhanXet = nhanXet;
    }

    public com.example.myapplication.Presentation.PhucHoi.Model.KhachHang getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(com.example.myapplication.Presentation.PhucHoi.Model.KhachHang khachHang) {
        KhachHang = khachHang;
    }

    public Date getNgayDanhGia() {
        return NgayDanhGia;
    }

    public void setNgayDanhGia(Date ngayDanhGia) {
        NgayDanhGia = ngayDanhGia;
    }

    public double getDiemDanhGia() {
        return DiemDanhGia;
    }

    public void setDiemDanhGia(double diemDanhGia) {
        DiemDanhGia = diemDanhGia;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public List<String> getListImage() {
        return ListImage;
    }

    public void setListImage(List<String> listImage) {
        ListImage = listImage;
    }
}
