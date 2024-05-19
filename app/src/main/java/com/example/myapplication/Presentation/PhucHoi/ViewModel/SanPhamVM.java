package com.example.myapplication.Presentation.PhucHoi.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.myapplication.Model.SanPham;
import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Repository.SanPhamRepository;

import java.util.List;

public class SanPhamVM  extends ViewModel  {
    //    implements SanPhamRepository.SanPhamInterface
    private MutableLiveData<List<SanPham>> productListLiveData = new MutableLiveData<>();
//    private SanPhamRepository res = new SanPhamRepository(this);


    public SanPhamVM() {
        productListLiveData = new MutableLiveData<>();
//        res.readSanPham();


//        loadData(); // Load data here from your repository or source
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

//
//    @Override
//    public void getListSanPham(List<SanPham> list) {
//        productListLiveData.setValue(list);
//    }
//
//    @Override
//    public void getSanPhambyIdSanPham(List<SanPham> list) {
//
//    }
}
