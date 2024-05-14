package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Model.DonHangChiTiet;
import com.example.myapplication.Model.Mau;
import com.example.myapplication.Model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class MauVM extends ViewModel {
    private MutableLiveData<List<Mau>> listMauLiveData;
    private List<Mau> listMau;
    private List<DonHangChiTiet> listCart;

    public MauVM() {
        listMauLiveData = new MutableLiveData<>();
    }
    public MutableLiveData<List<Mau>> getListMauProductEditLiveData(List<DonHangChiTiet> listCart, SanPham sanPham){
        listMau = new ArrayList<>();
        this.listCart = listCart;
//        List<SanPham> listSP = res.getSanPham();
//        for(SanPham sp : listSP){
//            if(sp.getTenSanPham().equals(sanPham.getTenSanPham())){
//                listMau.add(sp.getMau());
//            }
//        }
//        for(Mau m : listMau){
//            for(DonHangChiTiet dh : listCart){
//                if(dh.getSanPham().getTenSanPham().equals(sanPham.getTenSanPham()) ){
//                    if(m.getId().equals(dh.getSanPham().getMau().getId())){
//                        m.setAble(false);
//                    }else if(m.getId().equals(sanPham.getMau().getId())){
//                        m.setAble(true);
//                        m.setChecked(true);
//                    }
//                }
//            }
//        }
//        listMauLiveData.setValue(listMau);
        return listMauLiveData;
//    }
//    private void getListMauSanPham(){
//
    }
}
