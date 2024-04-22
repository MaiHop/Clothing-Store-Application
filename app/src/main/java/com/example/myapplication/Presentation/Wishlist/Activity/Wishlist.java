package com.example.myapplication.Presentation.Wishlist.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import com.example.myapplication.Presentation.Wishlist.Adapter.Adapter_Item_BoLoc_WishList;
import com.example.myapplication.Presentation.Wishlist.Adapter.Adapter_Item_SP_WishList;
import com.example.myapplication.Presentation.Wishlist.Model.BoLoc_WishList;
import com.example.myapplication.Presentation.Wishlist.Model.SanPham_WishList;
import com.example.myapplication.R;

import java.util.ArrayList;

public class Wishlist extends AppCompatActivity {
    private Toolbar toolbar;
    RecyclerView recyclerViewBoLoc,recyclerViewSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        initUI();
        setSupportActionBar(toolbar);

        ArrayList<BoLoc_WishList> arrayBoLocList;
        ArrayList<SanPham_WishList> arraySPList;

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

        arraySPList = new ArrayList<>();
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.ic_apple));

        adapterItemBoLocWishList = new Adapter_Item_BoLoc_WishList(Wishlist.this,R.layout.item_boloc,arrayBoLocList);
        recyclerViewBoLoc.setAdapter(adapterItemBoLocWishList);

        adapterItemSpWishList = new Adapter_Item_SP_WishList(Wishlist.this,R.layout.item_sp_wishlist,arraySPList);
        recyclerViewSP.setAdapter(adapterItemSpWishList);


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
    }
}