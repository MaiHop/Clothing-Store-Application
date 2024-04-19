package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Presentation.Cart.Model.KhuyenMai;
import com.example.myapplication.Presentation.Cart.Model.KichThuoc;
import com.example.myapplication.Presentation.Cart.Model.Mau;
import com.example.myapplication.Presentation.Cart.Model.SanPham;
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;

import java.util.List;

public class KichThuocVM extends ViewModel {
    private MutableLiveData<List<KichThuoc>> listKichThuocLiveData;
    private List<KichThuoc> listKichThuoc;

    public KichThuocVM() {
        listKichThuocLiveData = new MutableLiveData<>();
        initData();
    }
    private void initData(){
        CartRepository res = new CartRepository();
        listKichThuoc = res.getListSize();

        listKichThuocLiveData.setValue(listKichThuoc);
    }
    public MutableLiveData<List<KichThuoc>> getListKichThuocLiveData(){
        return listKichThuocLiveData;
    }
    public void showListSize(String colorId, SanPham sanPham){
        CartRepository res = new CartRepository();
        List<SanPham> list_sp = res.getSanPham();
        for (SanPham sp : list_sp){
            if(sp.getTenSanPham().equals(sanPham.getTenSanPham()) && sp.getMau().getId().equals(colorId)){
                for(KichThuoc kt : listKichThuoc){
                    kt.setChecked(false);
                    if(sp.getKichThuoc().getId().equals(kt.getId())){
                        kt.setAble(true);
                    }else {
                        kt.setAble(false);
                    }
                }
            }
        }
        listKichThuocLiveData.setValue(listKichThuoc);
    }
}
