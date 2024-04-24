package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Domain.Model.SanPham;
import com.example.myapplication.Domain.Repository.CartRepository;

import java.util.List;

public class SanPhamVM extends ViewModel {
    private MutableLiveData<List<SanPham>> listSanPhamLiveData;
    private List<SanPham> listSanPham;
    public SanPhamVM() {
        listSanPhamLiveData = new MutableLiveData<>();
    }
    public SanPham getSanPham(SanPham sp){
        CartRepository res = new CartRepository();
        List<SanPham> list = res.getSanPham();
        SanPham sanpham = new SanPham();
        for(SanPham sanPham : list){
            if(sanPham.getTenSanPham().equals(sp.getTenSanPham())&& sanPham.getMau().getId().equals(sp.getMau().getId()) && sanPham.getKichThuoc().getId().equals(sp.getKichThuoc().getId())){
                sanpham = sanPham;
            }
        }
        return sanpham;
    }
}
