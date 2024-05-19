package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Model2.SanPham;
import com.example.myapplication.Repository.GioHangRepository;
import com.example.myapplication.Repository.SanPhamRepository;

import java.util.List;

public class SanPhamVM extends ViewModel implements SanPhamRepository.SanPhamInterface {
    private MutableLiveData<List<SanPham>> listSanPhamLiveData;
    private List<SanPham> listSanPham;
    private SanPhamRepository res = new SanPhamRepository(this);
    public SanPhamVM() {
        listSanPhamLiveData = new MutableLiveData<>();
    }
//    public SanPham getSanPham(SanPham sp){
//        CartRepository res = new CartRepository();
//        List<SanPham> list = res.getSanPham();
//        SanPham sanpham = new SanPham();
//        for(SanPham sanPham : list){
//            if(sanPham.getTenSanPham().equals(sp.getTenSanPham())&& sanPham.getMau().getId().equals(sp.getMau().getId()) && sanPham.getKichThuoc().getId().equals(sp.getKichThuoc().getId())){
//                sanpham = sanPham;
//            }
//        }
//        return sanpham;
//    }

    @Override
    public void getListSanPham(List<SanPham> list) {

    }

    @Override
    public void getSanPhambyIdSanPham(List<SanPham> list) {

    }
}
