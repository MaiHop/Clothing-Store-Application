package com.example.myapplication.Data.Repository;

import com.example.myapplication.Data.Service.CartRepository;
import com.example.myapplication.Domain.Model.DonHang;
import com.example.myapplication.Domain.Model.DonHangChiTiet;
import com.example.myapplication.Domain.Repository.GioHangInterface;

import java.util.ArrayList;
import java.util.List;

public class GioHangRepository implements GioHangInterface {
    private CartRepository cartRepository;

    public GioHangRepository() {
        cartRepository = new CartRepository();
    }
    @Override
    public List<DonHangChiTiet> getGioHang() {
        List<DonHang> list_dh = cartRepository.getListDonHang();
        List<DonHangChiTiet> list = new ArrayList<>();
        for (DonHang dh : list_dh){
            if(dh.getTrangThai().equals("Cart")){
                list = dh.getListDonHangChiTiet();
            }
        }
        return list;
    }

    @Override
    public boolean AddGioHang(DonHangChiTiet dhct) {
        return false;
    }

    @Override
    public boolean UpdateGioHang(DonHangChiTiet dhct) {
        return false;
    }

    @Override
    public boolean DeleteGioHang(String IdDonHang) {
        return false;
    }
}
