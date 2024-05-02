package com.example.myapplication.Presentation.Cart.Test;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Domain.Model.DonHangChiTiet;
import com.example.myapplication.Domain.Model.KieuSP;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class KieuSP_ViewModel extends ViewModel implements KieuSP_Res.OnKieuSPAvaiableInFirestore {
    private MutableLiveData<List<KieuSP>> listKieuSPLiveData = new MutableLiveData<>();
    private KieuSP KieuSanPham;
    private List<KieuSP> listKieuSP;

    KieuSP_Res kieuSPRes = new KieuSP_Res(this);
    public KieuSP_ViewModel() {
        kieuSPRes.readListKieuSP();
    }

    public MutableLiveData<List<KieuSP>> getListCartLiveData(){
        return listKieuSPLiveData;
    }

    public KieuSP getKieuSPbyId(String id){
        List<KieuSP> list = listKieuSPLiveData.getValue();
        KieuSP kieu = new KieuSP();
        for(KieuSP k : list){
            if(k.getId().equals(id)){
                kieu = k;
            }
        }

        return kieu;
    }

    @Override
    public void getListKieuSP(List<KieuSP> list) {
        listKieuSPLiveData.setValue(list);
    }

    @Override
    public void getKieuSP(KieuSP kieusp) {
        KieuSanPham = new KieuSP();
        KieuSanPham = kieusp;
    }
}
