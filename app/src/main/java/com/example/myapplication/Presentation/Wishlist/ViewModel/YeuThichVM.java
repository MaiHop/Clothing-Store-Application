package com.example.myapplication.Presentation.Wishlist.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Model2.SanPham;
import com.example.myapplication.Repository.WishListRepository;

import java.util.ArrayList;
import java.util.List;

public class YeuThichVM extends ViewModel implements WishListRepository.WishListInterface{
    private MutableLiveData<List<SanPham>> productListWishLiveData = new MutableLiveData<>();
    private List<SanPham> sanPhamList;
    private WishListRepository wishListRepository = new WishListRepository(this);
    public YeuThichVM() {

//        loadData(); // Load data here from your repository or source
        productListWishLiveData = new MutableLiveData<>();
//        loadData();
    }


    public LiveData<List<SanPham>> getProductListWishLiveData() {
        return productListWishLiveData;

    }

//    private void loadData() {
//       wishListRepository.readWishList();
//    }
//    private void loadData() {
//        // Assuming you have a repository that provides the data
//        CartRepository repository = new CartRepository();
//        List<SanPham> allProducts = repository.getSanPham();
//        int totalProducts = allProducts.size();
//        // Khởi tạo danh sách sản phẩm theo thứ tự ngược
//        List<SanPham> reversedProducts = new ArrayList<>();
//        for (int i = totalProducts - 1; i >= 0; i--) {
//            reversedProducts.add(allProducts.get(i));
//        }
//        // Đặt danh sách sản phẩm theo thứ tự ngược vào LiveData
//        productListWishLiveData.setValue(reversedProducts);
//
//    }
    @Override
    public void getWishList(List<SanPham> list_sp_wishlist) {
        productListWishLiveData.setValue(list_sp_wishlist);
    }
}
