package com.example.myapplication.Domain.UseCase;

import com.example.myapplication.Data.Service.CartRepository;
import com.example.myapplication.Domain.Model.DonHang;
import com.example.myapplication.Domain.Model.DonHangChiTiet;

import java.util.ArrayList;
import java.util.List;

public class GioHangUseCase {
    private CartRepository cartRepository;

    public GioHangUseCase() {
        cartRepository = new CartRepository();
    }
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
//    public boolean AddGioHang(DonHangChiTiet dhct) {
//        return true;
//    }
//    public boolean UpdateGioHang(DonHangChiTiet dhct) {
//        return false;
//    }
//    public boolean DeleteGioHang(String IdDonHang) {
//        return false;
//    }
//    public List<DonHangChiTiet> AddGioHang(DonHangChiTiet dhct, List<DonHangChiTiet> list) {
//        list.add(dhct);
//        return list;
//    }
//    public List<DonHangChiTiet> UpdateGioHang(DonHangChiTiet dhct, List<DonHangChiTiet> list) {
//        for(DonHangChiTiet donHangChiTiet : list){
//            if(donHangChiTiet.getSanPham().getIdSanPham().equals(dhct.getSanPham().getIdSanPham())){
//
//            }
//        }
//        return true;
//    }
//    public List<DonHangChiTiet> DeleteGioHang(DonHangChiTiet dhct, List<DonHangChiTiet> list) {
//
//        return true;
//    }
}
