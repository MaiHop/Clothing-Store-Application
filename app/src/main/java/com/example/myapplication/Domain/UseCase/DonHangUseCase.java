package com.example.myapplication.Domain.UseCase;

import com.example.myapplication.Data.Repository.DonHangRepository_Impl;
import com.example.myapplication.Domain.Model.DonHang;
import com.example.myapplication.Domain.Repository.DonHangRepository;

import java.util.List;

public class DonHangUseCase {
    private DonHangRepository donhang;

    public DonHangUseCase() {
        this.donhang = new DonHangRepository_Impl();
    }
    public List<DonHang> getListDonHang() {
        List<DonHang> list = donhang.getListDonHang();
        return list;
    }
    public DonHang getDonHang(String IdDonHang){
        DonHang dh = donhang.getDonHang(IdDonHang);
        return dh;
    }
    public boolean AddDonHang(DonHang dh) {
        donhang.AddDonHang(dh);
        return true;
    }
    public boolean UpdateDonHang(DonHang dh) {
        donhang.UpdateDonHang(dh);
        return true;
    }
    public boolean DeleteDonHang(String IdDonHang) {
        donhang.DeleteDonHang(IdDonHang);
        return true;
    }
}
