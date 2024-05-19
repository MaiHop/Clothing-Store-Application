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



    private KichThuoc kichThuoc;

    private Mau mau;



    private NhomSP nhomSanPham;



    private LoaiSP loaiSanPham;



    private KieuSP kieuSanPham;



    private List<Kho> listKho;


    private List<KhachHang> listKhachHang = new ArrayList<>();

}
