package com.example.myapplication.Presentation.Wishlist.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Detail_SP_WishList extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sp_wish_list);

        Toolbar toolbar = findViewById(R.id.toolbar_Detail_SP_WisList);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutoolbarwishlist,menu);
        return true;
    }
}