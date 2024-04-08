package com.example.myapplication.Presentation.Cart.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import com.example.myapplication.Presentation.Cart.Model.Cart;
import com.example.myapplication.Presentation.Cart.Model.DiaChiGH;
import com.example.myapplication.Presentation.Cart.Model.DonHang;
import com.example.myapplication.Presentation.Cart.Model.KhuyenMai;
import com.example.myapplication.Presentation.Cart.Model.PTThanhToan;
import com.example.myapplication.Presentation.Cart.Model.VanChuyen;
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;
import com.example.myapplication.R;

import java.util.List;

public class GioHangActivity extends AppCompatActivity {
    private RecyclerView rv_ListCart;
    private Button btn_DatHang;
    private TextView toolbar_title;
    private Toolbar toolbar_cart;
    List<Cart> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        init();

        this.rv_ListCart =findViewById(R.id.rv_ListCart);

        CartRepository re = new CartRepository();
        list = re.getAll();

        CartAdapter cartAdapter =new CartAdapter(this, list,btn_DatHang, toolbar_title);
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
    private void dathang() {
        DonHang dh = new DonHang();
        DiaChiGH dc = new DiaChiGH();
        dc.setTenDiaChi("Home");
        dc.setNguoiNhan("Mai Hop");
        dc.setDiaChi("30893r89dvjsnsdjnr");
        dc.setChecked(true);
        dc.setXacDinh(true);
        dc.setDiaChiChinh(true);

        VanChuyen vc = new VanChuyen();
        vc.setChecked(true);
        vc.setGiaTien(100);
        vc.setThoiGian("23 -24 Tháng 12, 2024");
        vc.setTenDonVI("GiaoHangTietKiem");
        vc.setLogo(R.drawable.baseline_local_shipping_24);

        PTThanhToan pm = new PTThanhToan();
        pm.setChecked(true);
        pm.setTenPhuongThuc("Mastercard");

        KhuyenMai km = new KhuyenMai();
        km.setChecked(true);
        km.setChiTietKhuyenMai("Mua 1 tặng 1");
        km.setTenKhuyenMai("Khuyến Mãi T4");

        dh.setDiachi(dc);
        dh.setVanchuyen(vc);
        dh.setThanhToan(pm);
        dh.setKhuyenmai(km);
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