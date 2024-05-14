package com.example.myapplication.Data.Repository;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Domain.Model.DonHang;
import com.example.myapplication.Domain.Repository.DonHangRepository;

import java.util.List;

public class DonHangRepository_Impl implements DonHangRepository {
    private CartRepository cartRepository;

    public DonHangRepository_Impl() {
        cartRepository = new CartRepository();
    }

    @Override
    public List<DonHang> getListDonHang() {
        return null;
    }

    @Override
    public DonHang getDonHang(String IdDonHang) {
        return null;
    }

    @Override
    public boolean AddDonHang(DonHang dh) {
        return false;
    }

    @Override
    public boolean UpdateDonHang(DonHang dh) {
        return false;
    }

    @Override
    public boolean DeleteDonHang(String IdDonHang) {
        return false;
    }
}
