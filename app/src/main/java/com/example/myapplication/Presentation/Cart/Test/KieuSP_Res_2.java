package com.example.myapplication.Presentation.Cart.Test;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.myapplication.Domain.Model.KieuSP;
import com.example.myapplication.Presentation.Cart.ViewModel.CartVM;

import java.util.ArrayList;
import java.util.List;

public class KieuSP_Res_2 extends ViewModel {
    private MutableLiveData<List<KieuSP>> listKieuSPLiveData = new MutableLiveData<>();
    private KieuSP KieuSanPham;
    private MutableLiveData<KieuSP> KieuSanPhamLivedata = new MutableLiveData<>();
    private List<KieuSP> listKieuSP;
    List<KieuSP> list = new ArrayList<>();
    KieuSP_Res_1 kieuSPRes1;

    public KieuSP_Res_2() {
    }

    public List<KieuSP> getListCartLiveData(){

        kieuSPRes1.getListCartLiveData().observe((LifecycleOwner) this, new Observer<List<KieuSP>>() {
            @Override
            public void onChanged(List<KieuSP> kieuSPS) {
                list = kieuSPS;
            }
        });
        return list;
    }

//    public MutableLiveData<KieuSP> getKieuSPbyId(String id){
//        kieuSPData.getKieuSanPham(id);
//        return KieuSanPhamLivedata;
//    }

}
