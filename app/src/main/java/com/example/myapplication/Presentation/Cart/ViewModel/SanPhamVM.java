package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Presentation.Cart.Model.NhomSP;
import com.example.myapplication.Presentation.Cart.Model.SanPham;
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;

import java.util.List;

public class SanPhamVM  extends ViewModel {
    private MutableLiveData<List<SanPham>> productListLiveData;


    public SanPhamVM() {
        productListLiveData = new MutableLiveData<>();

        loadData(); // Load data here from your repository or source
    }


    public LiveData<List<SanPham>> getProductListLiveData() {
        return productListLiveData;

    }

    private void loadData() {
        // Assuming you have a repository that provides the data
        CartRepository repository = new CartRepository();
        List<SanPham> productList = repository.getSanPham();
        productListLiveData.setValue(productList);


    }


}
