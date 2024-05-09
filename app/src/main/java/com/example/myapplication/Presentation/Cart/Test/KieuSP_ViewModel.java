package com.example.myapplication.Presentation.Cart.Test;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Domain.Model.KieuSP;

import java.util.List;

public class KieuSP_ViewModel extends ViewModel  {
    private MutableLiveData<List<KieuSP>> listKieuSPLiveData = new MutableLiveData<>();
    private KieuSP KieuSanPham;
    private MutableLiveData<KieuSP> KieuSanPhamLivedata = new MutableLiveData<>();
    private List<KieuSP> listKieuSP;

    public KieuSP_ViewModel() {
    }

//    public MutableLiveData<List<KieuSP>> getListCartLiveData(){
//        kieuSPRes.readListKieuSP();
//        return KieuSanPhamLivedata;
//    }
//
//    public MutableLiveData<KieuSP> getKieuSPbyId(String id){
//        kieuSPRes.getKieuSanPham(id);
//        return this.KieuSanPham;
//    }

}
