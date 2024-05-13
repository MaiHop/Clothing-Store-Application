package com.example.myapplication.Domain.UseCase;

import com.example.myapplication.Data.Data_Source.CartRepository;
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
//    public boolean AddGioHang(DonHangChiTiet_api dhct) {
//        return true;
//    }
//    public boolean UpdateGioHang(DonHangChiTiet_api dhct) {
//        return false;
//    }
//    public boolean DeleteGioHang(String IdDonHang) {
//        return false;
//    }
//    public List<DonHangChiTiet_api> AddGioHang(DonHangChiTiet_api dhct, List<DonHangChiTiet_api> list) {
//        list.add(dhct);
//        return list;
//    }
//    public List<DonHangChiTiet_api> UpdateGioHang(DonHangChiTiet_api dhct, List<DonHangChiTiet_api> list) {
//        for(DonHangChiTiet_api donHangChiTiet : list){
//            if(donHangChiTiet.getSanPham().getIdSanPham().equals(dhct.getSanPham().getIdSanPham())){
//
//            }
//        }
//        return true;
//    }
//    public List<DonHangChiTiet_api> DeleteGioHang(DonHangChiTiet_api dhct, List<DonHangChiTiet_api> list) {
//
//        return true;
//    }
}
