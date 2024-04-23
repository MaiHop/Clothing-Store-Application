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
    }

    public MutableLiveData<List<KichThuoc>> getListKichThuocLiveData(SanPham sp){
        CartRepository res = new CartRepository();
        listKichThuoc = res.getListSize();
        List<SanPham> list_sp = res.getSanPham();
        listKichThuoc = res.getListSize();
        for (SanPham sp_check : list_sp){
            if(sp_check.getTenSanPham().equals(sp.getTenSanPham()) && sp_check.getMau().getId().equals(sp.getMau().getId())){
                for(KichThuoc kt : listKichThuoc){
                    if(sp.getKichThuoc().getId().equals(kt.getId())){
                        kt.setAble(true);
                        kt.setChecked(true);
                    }else {
                        kt.setAble(false);
                    }
                }
            }
        }
        listKichThuocLiveData.setValue(listKichThuoc);
        return listKichThuocLiveData;
    }
    public List<KichThuoc> getListBySanPham(SanPham sp){
        CartRepository res = new CartRepository();
        List<SanPham> list_sp = res.getSanPham();
        listKichThuoc = res.getListSize();
        for (SanPham sp_check : list_sp){
            if(sp_check.getTenSanPham().equals(sp.getTenSanPham()) && sp_check.getMau().getId().equals(sp.getMau().getId())){
                for(KichThuoc kt : listKichThuoc){
                    if(sp.getKichThuoc().getId().equals(kt.getId())){
                        kt.setAble(true);
                    }else {
                        kt.setAble(false);
                    }
                }
            }
        }
        return listKichThuoc;
    }
    public void showListSize(SanPham sanPham){
        CartRepository res = new CartRepository();
        List<SanPham> list_sp = res.getSanPham();
        listKichThuoc = res.getListSize();
        for (SanPham sp : list_sp){
            if(sp.getTenSanPham().equals(sanPham.getTenSanPham()) && sp.getMau().getId().equals(sanPham.getMau().getId())){
                for(KichThuoc kt : listKichThuoc){
                    if(sp.getKichThuoc().getId().equals(kt.getId()) && sp.getSoLuong()>0){
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
