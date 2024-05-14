package com.example.myapplication.Presentation.Wishlist.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Model.SanPham;

import java.util.List;

public class YeuThichVM extends ViewModel {
    private MutableLiveData<List<SanPham>> productListWishLiveData;
    public YeuThichVM() {
        productListWishLiveData = new MutableLiveData<>();

        loadData(); // Load data here from your repository or source
    }


    public LiveData<List<SanPham>> getProductListWishLiveData() {
        return productListWishLiveData;

    }

    private void loadData() {
        // Assuming you have a repository that provides the data
        CartRepository repository = new CartRepository();
        List<SanPham> productList = repository.getSanPham();
        productListWishLiveData.setValue(productList);


    }
}
