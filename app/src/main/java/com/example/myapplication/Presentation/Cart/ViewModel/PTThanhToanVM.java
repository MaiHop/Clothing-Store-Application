package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Domain.Model.ThanhToan;
import com.example.myapplication.Data.Service.CartRepository;

import java.util.List;

public class PTThanhToanVM extends ViewModel {
    private MutableLiveData<List<ThanhToan>> listPTThanhToanLiveData;
    private List<ThanhToan> listThanhToan;

    public PTThanhToanVM() {
        listPTThanhToanLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData(){
        CartRepository res = new CartRepository();
//        listThanhToan = res.getListMP();

        listPTThanhToanLiveData.setValue(listThanhToan);
    }
    public MutableLiveData<List<ThanhToan>> getListPTThanhToanLiveData(){
        return listPTThanhToanLiveData;
    }
//    public void addPTThanhToan(){
//        ThanhToan tt1 = new ThanhToan();
//        tt1.setIdThanhToan("ccc");
//        tt1.setTenThanhToan("Paypal");
//        tt1.setHanSuDung("22/01");
//        tt1.setCVV("101");
//        tt1.setLoai("VISA");
//        tt1.setImageUrl("https://inkythuatso.com/uploads/thumbnails/800/2023/05/logo-viettelpost-inkythuatso-27-14-52-01.jpg");
//        tt1.setChecked(false);
//        listThanhToan.add(tt1);
//        listPTThanhToanLiveData.setValue(listThanhToan);
//
//    }
}
