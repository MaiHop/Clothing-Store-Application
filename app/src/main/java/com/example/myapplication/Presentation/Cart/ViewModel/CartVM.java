package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Domain.Model.DonHangChiTiet;
import com.example.myapplication.Domain.Model.SanPham;
import com.example.myapplication.Data.Service.CartRepository;

import java.util.List;
import java.util.stream.Collectors;

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
        listDonHangChiTiet = listCartLiveData.getValue();
        for(DonHangChiTiet ct : listDonHangChiTiet){
            if(ct.getIdDonHang().equals(donHangChiTiet.getIdDonHang())){
                ct.setSanPham(donHangChiTiet.getSanPham());
                ct.setSoLuong(donHangChiTiet.getSoLuong());
                ct.setThanhTien((donHangChiTiet.getThanhTien()));
            }
        }
        listCartLiveData.setValue(listDonHangChiTiet);
    }
    public void filterCart(String key){
        if(key.length() ==0){
            CartRepository res = new CartRepository();
            listDonHangChiTiet = res.getGioHang();

            listCartLiveData.setValue(listDonHangChiTiet);
        }else {
            CartRepository res = new CartRepository();
            listDonHangChiTiet = res.getGioHang();
            listDonHangChiTiet = listDonHangChiTiet.stream()
                    .filter(donHangChiTiet -> donHangChiTiet.getSanPham().getTenSanPham().toLowerCase().contains(key))
                    .collect(Collectors.toList());
            listCartLiveData.setValue(listDonHangChiTiet);
        }

    }
}
