package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Model.VanChuyen;

import java.util.List;

public class VanChuyenVM extends ViewModel {
    private MutableLiveData<List<VanChuyen>> listVanChuyenLiveData;
    private List<VanChuyen> listVanChuyen;

    public VanChuyenVM() {
        listVanChuyenLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData(){
        CartRepository res = new CartRepository();
        listVanChuyen = res.getListDelivery();

        listVanChuyenLiveData.setValue(listVanChuyen);
    }
    public MutableLiveData<List<VanChuyen>> getListVanChuyenLiveData(){
        return listVanChuyenLiveData;
    }
    public void addCart(){
        VanChuyen vc1 = new VanChuyen();
        vc1.setId("cc");
        vc1.setTen("J&T Express");
        vc1.setImageURL("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
        vc1.setNgayGiao("23 - 25 tháng 10 2024");
        vc1.setGia(10);
        vc1.setChecked(false);
        listVanChuyen.add(vc1);
        listVanChuyenLiveData.setValue(listVanChuyen);

    }
}
