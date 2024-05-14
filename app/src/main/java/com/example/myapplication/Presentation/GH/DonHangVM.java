package com.example.myapplication.Presentation.GH;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Domain.Model.DonHang;

import java.util.List;

public class DonHangVM extends ViewModel {
    private MutableLiveData<List<DonHang>> listCartLiveData;
//    private MutableLiveData<Integer> activeCountLiveData = new MutableLiveData<>();
    private List<DonHang> listDonHang;

    public DonHangVM() {
        listCartLiveData = new MutableLiveData<>();
//        activeCountLiveData.setValue(0);
        initData();
    }

    private void initData() {
        CartRepository res = new CartRepository();
        listDonHang = res.getListDH();
        listCartLiveData.setValue(listDonHang);
//        updateActiveCount();  // Cập nhật số lượng hoạt động ngay khi khởi tạo
    }
    public MutableLiveData<List<DonHang>> getListCartLiveData() {
        return listCartLiveData;
    }


//    public void addProduct(DonHang newDonHang) {
//        List<DonHang> currentList = listCartLiveData.getValue();
//        if (currentList == null) {
//            currentList = new ArrayList<>();
//        }
//        currentList.add(newDonHang);
//        listCartLiveData.setValue(currentList);
//        updateActiveCount(); // Cập nhật số lượng hoạt động sau khi thêm sản phẩm mới
//    }

//    private void updateActiveCount() {
//        List<DonHang> currentList = listCartLiveData.getValue();
//        if (currentList != null) {
//            int activeCount = 0;
//            for (DonHang dh : currentList) {
//                if ("active".equals(dh.getTrangThai())) {
//                    activeCount++;
//                }
//            }
//            activeCountLiveData.setValue(activeCount);
//        }
//    }
}


