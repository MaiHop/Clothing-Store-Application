package com.example.myapplication.Presentation.Homepage.phuchoi.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class KhachHang implements Serializable {
    private String IdKhachHang, ImageUrl, Ten, Email, MatKhau;
    private int GioiTinh;
    private Date NgaySinh;
    private List<DiaChi> ListDiaChi = null;
    private List<ThanhToan> ListThanhToan = null;
    private List<SanPham> ListYeuThich = null;
    private List<DonHang> ListDonHang = null;

    public KhachHang() {
    }

    public String getIdKhachHang() {
        return IdKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        IdKhachHang = idKhachHang;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public List<DiaChi> getListDiaChi() {
        return ListDiaChi;
    }

    public void setListDiaChi(List<DiaChi> listDiaChi) {
        ListDiaChi = listDiaChi;
    }

    public List<ThanhToan> getListThanhToan() {
        return ListThanhToan;
    }

    public void setListThanhToan(List<ThanhToan> listThanhToan) {
        ListThanhToan = listThanhToan;
    }

    public List<SanPham> getListYeuThich() {
        return ListYeuThich;
    }

    public void setListYeuThich(List<SanPham> listYeuThich) {
        ListYeuThich = listYeuThich;
    }

    public List<DonHang> getListDonHang() {
        return ListDonHang;
    }

    public void setListDonHang(List<DonHang> listDonHang) {
        ListDonHang = listDonHang;
    }
}
