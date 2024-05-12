package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Domain.Model.KhuyenMai;
import com.example.myapplication.Data.Service.CartRepository;

import java.util.List;

public class KhuyenMaiVM extends ViewModel {
    private MutableLiveData<List<KhuyenMai>> listKhuyenMaiLiveData;
    private List<KhuyenMai> listKhuyenMai;

    public KhuyenMaiVM() {
        listKhuyenMaiLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData(){
        CartRepository res = new CartRepository();
        listKhuyenMai = res.getListKhuyenMai();

        listKhuyenMaiLiveData.setValue(listKhuyenMai);
    }
    public MutableLiveData<List<KhuyenMai>> getListKhuyenMaiLiveData(){
        return listKhuyenMaiLiveData;
    }
}
