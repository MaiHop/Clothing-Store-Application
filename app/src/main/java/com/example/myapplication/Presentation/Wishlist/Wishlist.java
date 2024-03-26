package com.example.myapplication.Presentation.Wishlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.myapplication.R;

import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Wishlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        Toolbar toolbar = findViewById(R.id.toolbar_WishList);
        setSupportActionBar(toolbar);


        RecyclerView recyclerViewBoLoc = findViewById(R.id.RV_itemboloc_wishlist);
        RecyclerView recyclerViewSP = findViewById(R.id.RV_item_Sp_wishlist);

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
}