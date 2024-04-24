package com.example.myapplication.Presentation.Homepage.phuchoi.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Presentation.Homepage.phuchoi.Repository.CartRepository;
import com.example.myapplication.Presentation.Homepage.phuchoi.Model.KhuyenMai;

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
