package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Model.KichThuoc;
import com.example.myapplication.Model.SanPham;

import java.util.List;

public class KichThuocVM extends ViewModel {
    private MutableLiveData<List<KichThuoc>> listKichThuocLiveData;
    private MutableLiveData<List<SanPham>> listSanPhamLiveData;
    private List<KichThuoc> listKichThuoc;
//    private KichThuocRepository kichThuocRepository;
    public KichThuocVM() {
        listKichThuocLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<KichThuoc>> getListKichThuocLiveData(SanPham sp){
//        kichThuocRepository.readKichThuoc();
//        kichThuocRepository.readSanPhambyIdSanPham(sp.getIdSanPham());
//        listKichThuoc = listKichThuocLiveData.getValue();
//        List<SanPham> list_sp = listSanPhamLiveData.getValue();
//        //Set able cho sản phẩm được edit
//        for (SanPham sp_check : list_sp){
//            if(sp_check.getTenSanPham().equals(sp.getTenSanPham()) && sp_check.getMau().getId().equals(sp.getMau().getId())){
//                for(KichThuoc kt : listKichThuoc){
//                    if(sp.getKichThuoc().getId().equals(kt.getId())){
//                        kt.setAble(true);
//                        kt.setChecked(true);
//                    }else {
//                        kt.setAble(false);
//                    }
//                }
//            }
//        }
//        listKichThuocLiveData.setValue(listKichThuoc);
//        return listKichThuocLiveData;
//    }
//    public List<KichThuoc> getListBySanPham(SanPham sp){
//        CartRepository res = new CartRepository();
//        List<SanPham> list_sp = res.getSanPham();
//        listKichThuoc = res.getListSize();
//        for (SanPham sp_check : list_sp){
//            if(sp_check.getTenSanPham().equals(sp.getTenSanPham()) && sp_check.getMau().getId().equals(sp.getMau().getId())){
//                for(KichThuoc kt : listKichThuoc){
//                    if(sp.getKichThuoc().getId().equals(kt.getId())){
//                        kt.setAble(true);
//                    }else {
//                        kt.setAble(false);
//                    }
//                }
//            }
//        }
        return listKichThuocLiveData;
    }
    public void showListSize(SanPham sanPham){
//        kichThuocRepository.readKichThuoc();
//        kichThuocRepository.readSanPhambyIdSanPham(sanPham.getIdSanPham());
        listKichThuoc = listKichThuocLiveData.getValue();
        List<SanPham> list_sp = listSanPhamLiveData.getValue();
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

//    @Override
//    public void getListKichThuoc(List<KichThuoc> list) {
//        listKichThuocLiveData.setValue(list);
//    }
//
//    @Override
//    public void getSanPhambyIdSanPham(List<SanPham> list) {
//        listSanPhamLiveData.setValue(list);
//    }
}
