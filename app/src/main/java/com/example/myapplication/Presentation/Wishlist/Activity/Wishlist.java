package com.example.myapplication.Presentation.Wishlist.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.SanPham;
import com.example.myapplication.Presentation.Wishlist.Adapter.Adapter_Item_BoLoc_WishList;
import com.example.myapplication.Presentation.Wishlist.Adapter.Adapter_Item_SP_WishList;
import com.example.myapplication.Presentation.Wishlist.Model.BoLoc_WishList;
import com.example.myapplication.Presentation.Wishlist.ViewModel.YeuThichVM;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Wishlist extends AppCompatActivity {
    private Toolbar toolbar;
    RecyclerView recyclerViewBoLoc,recyclerViewSP;

    BottomNavigationView btn_navigation;
    TextView title;
    private YeuThichVM YeuThichVM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_wish_list);

        initUI();
        setSupportActionBar(toolbar);

        ArrayList<BoLoc_WishList> arrayBoLocList;

        Adapter_Item_BoLoc_WishList adapterItemBoLocWishList;
        Adapter_Item_SP_WishList adapterItemSpWishList;


        recyclerViewBoLoc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewSP.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerViewSP.setHasFixedSize(true);

        arrayBoLocList = new ArrayList<>();
        arrayBoLocList.add(new BoLoc_WishList("Ao"));
        arrayBoLocList.add(new BoLoc_WishList("Quan"));
        arrayBoLocList.add(new BoLoc_WishList("pop"));
        arrayBoLocList.add(new BoLoc_WishList("Tui"));
        arrayBoLocList.add(new BoLoc_WishList("Giay"));

        // Khởi tạo ViewModel1
        adapterItemSpWishList = new Adapter_Item_SP_WishList(new ArrayList<>(),this,R.layout.c_hung_item_sp_wishlist);
        recyclerViewSP.setAdapter(adapterItemSpWishList);
        YeuThichVM = new ViewModelProvider(this).get(YeuThichVM.class);

        // Lắng nghe LiveData để nhận danh sách sản phẩm
        YeuThichVM.getProductListWishLiveData().observe(this, new Observer<List<SanPham>>() {
            @Override
            public void onChanged(List<SanPham> productList) {
                // Cập nhật Adapter khi dữ liệu thay đổi
                adapterItemSpWishList.setListProductWish(productList);
            }
        });

        adapterItemBoLocWishList = new Adapter_Item_BoLoc_WishList(Wishlist.this,R.layout.c_hung_item_boloc,arrayBoLocList);
        recyclerViewBoLoc.setAdapter(adapterItemBoLocWishList);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutoolbarwishlist,menu);
        return true;
    }
    private void initUI(){
        toolbar = findViewById(R.id.toolbar_WishList);
        recyclerViewBoLoc = findViewById(R.id.RV_itemboloc_wishlist);
        recyclerViewSP = findViewById(R.id.RV_item_Sp_wishlist);
        title = findViewById(R.id.title);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }
}