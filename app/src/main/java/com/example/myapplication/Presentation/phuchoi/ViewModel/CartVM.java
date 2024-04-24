package com.example.myapplication.Presentation.phuchoi.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Presentation.phuchoi.Model.DonHangChiTiet;
import com.example.myapplication.Presentation.phuchoi.Model.SanPham;
import com.example.myapplication.Presentation.phuchoi.Repository.CartRepository;

import java.util.List;

public class CartVM extends ViewModel {
    private MutableLiveData<List<DonHangChiTiet>> listCartLiveData;
    private List<DonHangChiTiet> listDonHangChiTiet;

    public CartVM() {
        listCartLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData(){
        CartRepository res = new CartRepository();
        listDonHangChiTiet = res.getGioHang();

        listCartLiveData.setValue(listDonHangChiTiet);
    }
    public MutableLiveData<List<DonHangChiTiet>> getListCartLiveData(){
        return listCartLiveData;
    }
    public void addCart(){
        CartRepository res = new CartRepository();
        List<SanPham> listsp = res.getSanPham();
        DonHangChiTiet dh1 = new DonHangChiTiet();
        dh1.setIdDonHang("cc");
        dh1.setSanPham(listsp.get(4));
        dh1.setSoLuong(1);
        dh1.setThanhTien(dh1.getSanPham().getGiaban()*dh1.getSoLuong());
        dh1.setThanhTienKhuyenMai(0);
        dh1.setChecked(true);
        listDonHangChiTiet.add(dh1);
        listCartLiveData.setValue(listDonHangChiTiet);
    }
    public void removeCart(String id){
        for(DonHangChiTiet ct : listDonHangChiTiet){
            if(ct.getSanPham().getTenSanPham().equals(id)){
                listDonHangChiTiet.remove(ct);
            }
        }
        listCartLiveData.setValue(listDonHangChiTiet);
    }
    public void editCart(DonHangChiTiet donHangChiTiet){
        
    }
}
