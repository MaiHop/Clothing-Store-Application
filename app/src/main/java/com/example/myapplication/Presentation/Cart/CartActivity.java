package com.example.myapplication.Presentation.Cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.R;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView rc_ListCart;
    private Button btn_DatHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        init();

        this.rc_ListCart =findViewById(R.id.rv_ListCart);

        CartAdapter cartAdapter =new CartAdapter(this, CartRepository.getAll(),btn_DatHang);
        this.rc_ListCart.setAdapter(cartAdapter);
        this.rc_ListCart.setLayoutManager(new LinearLayoutManager(this));


    }

    private void init(){
        this.btn_DatHang = findViewById(R.id.btn_DatHang);
    }
}