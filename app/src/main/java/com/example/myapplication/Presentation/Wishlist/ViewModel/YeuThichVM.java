package com.example.myapplication.Presentation.Wishlist.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Model.SanPham;
import com.example.myapplication.Repository.WishListRepository;

import java.util.List;

public class YeuThichVM extends ViewModel implements WishListRepository.WishListInterface{
    private MutableLiveData<List<SanPham>> productListWishLiveData = new MutableLiveData<>();
    private List<SanPham> sanPhamList;
    private WishListRepository wishListRepository = new WishListRepository(this);
    public YeuThichVM() {

//        loadData(); // Load data here from your repository or source
    }


    public LiveData<List<SanPham>> getProductListWishLiveData() {
        return productListWishLiveData;

    }

//    private void loadData() {
//       wishListRepository.readWishList();
//    }

    @Override
    public void getWishList(List<SanPham> list_sp_wishlist) {
        productListWishLiveData.setValue(list_sp_wishlist);
    }
}
