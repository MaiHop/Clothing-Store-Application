package com.example.myapplication.Presentation.Cart.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Api.SanPham_api;
import com.example.myapplication.Api.ServiceBuilder;
import com.example.myapplication.Model2.DonHangChiTiet;
import com.example.myapplication.Model2.Mau;
import com.example.myapplication.Model2.SanPham;
import com.example.myapplication.Repository.SanPhamRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MauVM extends ViewModel implements SanPhamRepository.SanPhamInterface {
    private MutableLiveData<List<Mau>> listMauLiveData;
    private MutableLiveData<List<SanPham>> listSanPhamLiveData;
    private List<Mau> listMau;
    private List<Mau> listMau_temp;
    private List<DonHangChiTiet> listCart;
    private SanPham sanpham;
    private SanPhamRepository res = new SanPhamRepository(this);
    public MauVM() {
        listMauLiveData = new MutableLiveData<>();

    }
    private void getListMauSanPham(List<DonHangChiTiet> listCart, SanPham sanPham){
//        SanPham_api api = ServiceBuilder.buildService(SanPham_api.class);
//        Call<List<SanPham>> request = api.getSanPhambyIdSanPham(sanPham.getIdSanPham());
//        request.enqueue(new Callback<List<SanPham>>() {
//            @Override
//            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
//                listMau = new ArrayList<>();
//                if(response.isSuccessful()){
//                    //Lấy danh sách màu của sản phẩm được edit
//                    List<SanPham> listSP = response.body();
//                    for(SanPham sp : listSP){
//                        boolean alreadyExists = false;
//                        for (Mau mau : listMau) {
//                            if (sp.getMau().getId().equals(mau.getId())) {
//                                alreadyExists = true;
//                                break;  // Nếu đã tìm thấy một màu trùng lặp, thoát khỏi vòng lặp
//                            }
//                        }
//                        if (!alreadyExists) {
//                            listMau.add(sp.getMau());  // Chỉ thêm màu nếu nó chưa tồn tại trong danh sách test
//                        }
//                    }
//                    //Kiểm tra màu sp edit có trong giỏ hàng ko, nếu có thì setEnable=false
//                    for(Mau m : listMau){
//                        for(DonHangChiTiet dh : listCart){
//                            if(dh.getSanPham().getTenSanPham().equals(sanPham.getTenSanPham()) ){
//                                if(m.getId().equals(dh.getSanPham().getMau().getId())){
//                                    m.setAble(false);
//                                }else if(m.getId().equals(sanPham.getMau().getId())){
//                                    m.setAble(true);
//                                    m.setChecked(true);
//                                }
//                            }
//                        }
//                    }
//                    listMauLiveData.setValue(listMau);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<SanPham>> call, Throwable t) {
//
//            }
//        });


    }
    public MutableLiveData<List<Mau>> getListMauProductEditLiveData(List<DonHangChiTiet> listCart, SanPham sanPham){
        this.listCart = listCart;
        this.sanpham = sanPham;
        getListMauSanPham(this.listCart, this.sanpham);
        return listMauLiveData;
    }

    @Override
    public void getListSanPham(List<SanPham> list) {

    }

    @Override
    public void getSanPhambyIdSanPham(List<SanPham> list) {
        listSanPhamLiveData.setValue(list);
    }

}
