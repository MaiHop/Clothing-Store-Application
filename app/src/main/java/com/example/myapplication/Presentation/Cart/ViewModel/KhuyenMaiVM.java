package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Model.KhuyenMai;

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
