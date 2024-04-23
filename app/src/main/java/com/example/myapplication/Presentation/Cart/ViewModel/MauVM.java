package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Presentation.Cart.Model.DonHangChiTiet;
import com.example.myapplication.Presentation.Cart.Model.KichThuoc;
import com.example.myapplication.Presentation.Cart.Model.Mau;
import com.example.myapplication.Presentation.Cart.Model.SanPham;
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;

import java.util.ArrayList;
import java.util.List;

public class MauVM extends ViewModel {
    private MutableLiveData<List<Mau>> listMauLiveData;
    private List<Mau> listMau;


    public MauVM() {
        listMauLiveData = new MutableLiveData<>();
    }
    public MutableLiveData<List<Mau>> getListMauProductEditLiveData(SanPham sanPham){
        listMau = new ArrayList<>();
        CartRepository res = new CartRepository();
        List<DonHangChiTiet> listCart = res.getGioHang();
        List<SanPham> listSP = res.getSanPham();
        for(SanPham sp : listSP){
            if(sp.getTenSanPham().equals(sanPham.getTenSanPham())){
                listMau.add(sp.getMau());
            }
        }
        for(Mau m : listMau){
            for(DonHangChiTiet dh : listCart){
                if(dh.getSanPham().getTenSanPham().equals(sanPham.getTenSanPham()) ){
                    if(m.getId().equals(dh.getSanPham().getMau().getId())){
                        m.setAble(false);
                    }else if(m.getId().equals(sanPham.getMau().getId())){
                        m.setAble(true);
                        m.setChecked(true);
                    }
                }
            }
        }
        listMauLiveData.setValue(listMau);
        return listMauLiveData;
    }
}
