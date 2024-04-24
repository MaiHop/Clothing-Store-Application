package com.example.myapplication.Presentation.PhucHoi.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Presentation.PhucHoi.Model.SanPham;
import com.example.myapplication.Presentation.PhucHoi.Repository.CartRepository;

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
        // Assuming you have a repository that provides the data
        CartRepository repository = new CartRepository();
        List<SanPham> allProducts = repository.getSanPham();
        int totalProducts = allProducts.size();
        // Khởi tạo danh sách sản phẩm theo thứ tự ngược
        List<SanPham> reversedProducts = new ArrayList<>();
        for (int i = totalProducts - 1; i >= 0; i--) {
            reversedProducts.add(allProducts.get(i));
        }
        // Đặt danh sách sản phẩm theo thứ tự ngược vào LiveData
        productListLiveData.setValue(reversedProducts);

    }

}
