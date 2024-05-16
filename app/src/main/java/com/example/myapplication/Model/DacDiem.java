package com.example.myapplication.Model;

import java.io.Serializable;

public class DacDiem implements Serializable {
    private int soLuong=0, soLuongBan=0;
    private KichThuoc kichThuoc=null;

    public DacDiem(int soLuong, int soLuongBan, KichThuoc kichThuoc) {
        this.soLuong = soLuong;
        this.soLuongBan = soLuongBan;
        this.kichThuoc = kichThuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public KichThuoc getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(KichThuoc kichThuoc) {
        this.kichThuoc = kichThuoc;
    }
}
