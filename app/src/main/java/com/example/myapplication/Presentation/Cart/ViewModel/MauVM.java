package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Presentation.Cart.Model.KichThuoc;
import com.example.myapplication.Presentation.Cart.Model.Mau;
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;

import java.util.List;

public class MauVM extends ViewModel {
    private MutableLiveData<List<Mau>> listMauLiveData;
    private List<Mau> listMau;


    public MauVM() {
        listMauLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData(){
        CartRepository res = new CartRepository();
        listMau = res.getListMau();

        listMauLiveData.setValue(listMau);
    }
    public MutableLiveData<List<Mau>> getListMauLiveData(){
        return listMauLiveData;
    }
}
