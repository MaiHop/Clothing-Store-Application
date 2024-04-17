package com.example.myapplication.Presentation.Cart.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Presentation.Cart.Apdapter.CartAdapter;
import com.example.myapplication.Presentation.Cart.Model.DonHang;
import com.example.myapplication.Presentation.Cart.Model.DonHangChiTiet;
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;
import com.example.myapplication.Presentation.Cart.ViewModel.CartVM;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class GioHangActivity extends AppCompatActivity {
    private RecyclerView rv_ListCart;
    private Button btn_DatHang;
    private TextView toolbar_title;
    private Toolbar toolbar_cart;
    private List<DonHangChiTiet> list;
    private CartVM cartVM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        init();
        CartRepository res = new CartRepository();
        List<DonHangChiTiet> list = res.getGioHang();
        Toast.makeText(this, list.size(),Toast.LENGTH_SHORT).show();

//        this.rv_ListCart =findViewById(R.id.rv_ListCart);
//
//        this.rv_ListCart.setLayoutManager(new LinearLayoutManager(this));
//        cartVM = new ViewModelProvider(this).get(CartVM.class);
//        cartVM.getListCartLiveData().observe(this, new Observer<List<DonHangChiTiet>>() {
//            @Override
//            public void onChanged(List<DonHangChiTiet> donHangChiTiets) {
//                list= donHangChiTiets;
//                CartAdapter adapter = new CartAdapter(GioHangActivity.this, donHangChiTiets, btn_DatHang, toolbar_title);
//                rv_ListCart.setAdapter(adapter);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_cart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item_search_cart){
            cartVM.removeCart("1");
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }
    private void dathang() {
        DonHang dh =new DonHang();
        dh.setListDonHangChiTiet(list);
        Intent intent = new Intent(this, ThanhToanActivity.class);
        intent.putExtra("DonHang", dh);
        startActivity(intent);
    }
    private void init(){
        this.toolbar_title = findViewById((R.id.toolbar_cart_title));
        this.btn_DatHang = findViewById(R.id.btn_DatHang);
        this.toolbar_cart = findViewById(R.id.toolbar_cart);
        setSupportActionBar(toolbar_cart);
        toolbar_cart.setLogo(R.drawable.baseline_check_box_outline_blank_24);

        this.btn_DatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dathang();
            }
        });

    }


}