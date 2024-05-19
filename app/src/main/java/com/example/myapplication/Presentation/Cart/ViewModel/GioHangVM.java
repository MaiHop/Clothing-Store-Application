package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Model2.DonHangChiTiet;
import com.example.myapplication.Repository.GioHangRepository;

import java.util.List;

public class GioHangVM extends ViewModel implements GioHangRepository.GioHangInterface {
    private MutableLiveData<List<DonHangChiTiet>> listGioHangLiveData = new MutableLiveData<>();
    private List<DonHangChiTiet> listDonHangChiTiet;
    private GioHangRepository res = new GioHangRepository(this);
    public GioHangVM() {
        res.readGioHang();
    }


    public MutableLiveData<List<DonHangChiTiet>> getListCartLiveData(){
        return listGioHangLiveData;
    }
    public void removeCart(String id){
        for(DonHangChiTiet ct : listDonHangChiTiet){
            if(ct.getSanPham().getTenSanPham().equals(id)){
                listDonHangChiTiet.remove(ct);
            }
        }
        listGioHangLiveData.setValue(listDonHangChiTiet);
    }
    public void editCart(DonHangChiTiet donHangChiTiet){

    }

    @Override
    public void getGioHang(List<DonHangChiTiet> list) {
        listGioHangLiveData.setValue(list);
    }
}

