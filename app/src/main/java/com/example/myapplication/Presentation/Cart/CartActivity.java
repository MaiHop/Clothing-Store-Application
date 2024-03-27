package com.example.myapplication.Presentation.Cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Presentation.Cart.Apdapter.CartAdapter;
import com.example.myapplication.R;

public class CartActivity extends AppCompatActivity {
    private RecyclerView rv_ListCart;
    private Button btn_DatHang;
    private TextView toolbar_title;
    private Toolbar toolbar_cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        init();

        this.rv_ListCart =findViewById(R.id.rv_ListCart);

        CartAdapter cartAdapter =new CartAdapter(this, CartRepository.getAll(),btn_DatHang, toolbar_title);
        this.rv_ListCart.setAdapter(cartAdapter);
        this.rv_ListCart.setLayoutManager(new LinearLayoutManager(this));


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
            Toast.makeText(this,    "OK",Toast.LENGTH_SHORT).show();
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }

    }

    private void init(){
        this.toolbar_title = findViewById((R.id.toolbar_title));
        this.btn_DatHang = findViewById(R.id.btn_DatHang);
        this.toolbar_cart = findViewById(R.id.toolbar_cart);
        setSupportActionBar(toolbar_cart);
        toolbar_cart.setLogo(R.drawable.baseline_adb_24);

    }
}