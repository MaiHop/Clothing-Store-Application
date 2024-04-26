package com.example.myapplication.Presentation.Wishlist.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Accout_Setting.Activity.Account;
import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.Presentation.Wishlist.Adapter.Adapter_Item_BoLoc_WishList;
import com.example.myapplication.Presentation.Wishlist.Adapter.Adapter_Item_SP_WishList;
import com.example.myapplication.Presentation.Wishlist.Model.BoLoc_WishList;
import com.example.myapplication.Presentation.Wishlist.Model.SanPham_WishList;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Wishlist extends AppCompatActivity {
    private Toolbar toolbar;
    RecyclerView recyclerViewBoLoc,recyclerViewSP;

    BottomNavigationView btn_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_wish_list);

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
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.c_hung_ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.c_hung_ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.c_hung_ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.c_hung_ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.c_hung_ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.c_hung_ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.c_hung_ic_apple));
        arraySPList.add(new SanPham_WishList("Ao Polo","200000",R.drawable.c_hung_ic_apple));

        adapterItemBoLocWishList = new Adapter_Item_BoLoc_WishList(Wishlist.this,R.layout.c_hung_item_boloc,arrayBoLocList);
        recyclerViewBoLoc.setAdapter(adapterItemBoLocWishList);

        adapterItemSpWishList = new Adapter_Item_SP_WishList(Wishlist.this,R.layout.c_hung_item_sp_wishlist,arraySPList);
        recyclerViewSP.setAdapter(adapterItemSpWishList);


        btn_navigation = findViewById(R.id.bottom_navigation);
        btn_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.PageHome){
                    Toast.makeText(Wishlist.this,"Home",Toast.LENGTH_SHORT).show();
                }
                else if (item.getItemId() == R.id.PageWishList) {
                    Toast.makeText(Wishlist.this,"WishList",Toast.LENGTH_SHORT).show();
                }
                else if (item.getItemId() == R.id.PageCart) {
                    Toast.makeText(Wishlist.this,"Cart",Toast.LENGTH_SHORT).show();
                }
                else if (item.getItemId() == R.id.PageOrder) {
                    Toast.makeText(Wishlist.this,"Order",Toast.LENGTH_SHORT).show();
                }else if (item.getItemId() == R.id.PageAccount) {
                    Intent intent = new Intent(Wishlist.this, Account.class);
                    startActivity(intent);
                }
                return true;
            }
        });

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