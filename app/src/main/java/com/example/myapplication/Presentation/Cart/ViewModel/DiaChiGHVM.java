package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Presentation.Cart.Model.DiaChi;
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;

import java.util.List;

public class DiaChiGHVM extends ViewModel {
    private MutableLiveData<List<DiaChi>> listDiaChiGHLiveData;
    private List<DiaChi> listDiaChi;

    public DiaChiGHVM() {
        listDiaChiGHLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData(){
        CartRepository res = new CartRepository();
        listDiaChi = res.getListAddress();

        listDiaChiGHLiveData.setValue(listDiaChi);
    }
    public MutableLiveData<List<DiaChi>> getListDiaChiGHLiveData(){
        return listDiaChiGHLiveData;
    }
    public void addDiaChi(){
        DiaChi dc2 = new DiaChi();
        dc2.setIdDiaChi("1");
        dc2.setTenDiaChi("CC1");
        dc2.setDiaChiChinh(false);
        dc2.setNguoiNhan("Trung Hậu");
        dc2.setSDT("0765328458");
        dc2.setDiaChi("155/33 Nguyễn Trãi");
        dc2.setXacDinh(true);
        dc2.setChecked(false);
        listDiaChi.add(dc2);
        listDiaChiGHLiveData.setValue(listDiaChi);

    }
}
