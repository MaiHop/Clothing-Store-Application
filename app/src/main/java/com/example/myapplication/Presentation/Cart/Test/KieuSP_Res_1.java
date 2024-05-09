package com.example.myapplication.Presentation.Cart.Test;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Domain.Model.KieuSP;

import java.util.List;

public class KieuSP_Res_1 extends ViewModel implements KieuSP_Data.OnKieuSPAvaiableInFirestore{
    private MutableLiveData<List<KieuSP>> listKieuSPLiveData = new MutableLiveData<>();
    private KieuSP KieuSanPham;
    private MutableLiveData<KieuSP> KieuSanPhamLivedata = new MutableLiveData<>();
    private List<KieuSP> listKieuSP;
    KieuSP_Data kieuSPData = new KieuSP_Data(this);

    public KieuSP_Res_1() {
    }

    public MutableLiveData<List<KieuSP>> getListCartLiveData(){
        kieuSPData.readListKieuSP();
        return listKieuSPLiveData;
    }

    public MutableLiveData<KieuSP> getKieuSPbyId(String id){
        kieuSPData.getKieuSanPham(id);
        return KieuSanPhamLivedata;
    }
    @Override
    public void getListKieuSP(List<KieuSP> list) {
        listKieuSPLiveData.setValue(list);
    }

    @Override
    public void getKieuSP(KieuSP kieusp) {
        KieuSanPhamLivedata.setValue(kieusp);
    }
}
