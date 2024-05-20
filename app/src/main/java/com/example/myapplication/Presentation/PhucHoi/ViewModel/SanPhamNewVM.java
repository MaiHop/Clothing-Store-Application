package com.example.myapplication.Presentation.PhucHoi.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.myapplication.Model.SanPham;
import com.example.myapplication.Data.Data_Source.CartRepository;

import java.util.ArrayList;
import java.util.List;

public class SanPhamNewVM extends ViewModel {
    private MutableLiveData<List<SanPham>> productListLiveData;

    public SanPhamNewVM() {
        productListLiveData = new MutableLiveData<>();
        loadData(); // Load data here from your repository or source
    }


    public LiveData<List<SanPham>> getProductListLiveData() {
        return productListLiveData;

    }
    private void loadData() {
        CartRepository repository = new CartRepository();
        List<SanPham> allProducts = repository.getSanPham();
        productListLiveData.setValue(allProducts);

    }

}
