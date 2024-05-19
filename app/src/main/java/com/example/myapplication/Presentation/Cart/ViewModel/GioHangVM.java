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

    }


    public MutableLiveData<List<DonHangChiTiet>> getListCartLiveData() {
        res.readGioHang();
        return listGioHangLiveData;
    }

    public void removeCart(String id) {
        for (DonHangChiTiet ct : listDonHangChiTiet) {
            if (ct.getSanPham().getTenSanPham().equals(id)) {
                listDonHangChiTiet.remove(ct);
            }
        }
        listGioHangLiveData.setValue(listDonHangChiTiet);
    }
//    public void editCart(DonHangChiTiet donHangChiTiet){
//        listDonHangChiTiet = listGioHangLiveData.getValue();
//        for(DonHangChiTiet ct : listDonHangChiTiet){
//            if(ct.getIdDonHang().equals(donHangChiTiet.getIdDonHang())){
//                ct.setSanPham(donHangChiTiet.getSanPham());
//                ct.setSoLuong(donHangChiTiet.getSoLuong());
//                ct.setThanhTien((donHangChiTiet.getThanhTien()));
//            }
//        }
//        listGioHangLiveData.setValue(listDonHangChiTiet);
//    }


    @Override
    public void getGioHang(List<DonHangChiTiet> list) {
        listGioHangLiveData.setValue(list);
    }
}

