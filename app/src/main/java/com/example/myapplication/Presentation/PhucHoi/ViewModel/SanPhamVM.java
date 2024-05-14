package com.example.myapplication.Presentation.PhucHoi.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.myapplication.Domain.Model.SanPham;
import com.example.myapplication.Data.Data_Source.CartRepository;

import java.util.List;

public class SanPhamVM  extends ViewModel {
    private MutableLiveData<List<SanPham>> productListLiveData;
    private MutableLiveData<Integer> currentPage;
    private MutableLiveData<Integer> pageSize;
    private MutableLiveData<Integer> totalItems;


    public SanPhamVM() {
        productListLiveData = new MutableLiveData<>();
        currentPage = new MutableLiveData<>(1); // Khởi tạo trang hiện tại là 1
        pageSize = new MutableLiveData<>(10); // Khởi tạo kích thước trang là 10
        totalItems = new MutableLiveData<>(0); // Khởi tạo tổng số sản phẩm là 0


        loadData(); // Load data here from your repository or source
    }

    public LiveData<Integer> getCurrentPage() {
        return currentPage;
    }

    public LiveData<Integer> getPageSize() {
        return pageSize;
    }

    public LiveData<Integer> getTotalItems() {
        return totalItems;
    }

    public void setCurrentPage(int page) {
        currentPage.setValue(page);
        loadData(); // Load data khi thay đổi trang
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
