package com.example.myapplication.Presentation.Cart.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.Presentation.Cart.Apdapter.DiaChiGHAdapter;
import com.example.myapplication.Presentation.Cart.Apdapter.KhuyenMaiAdapter;
import com.example.myapplication.Presentation.Cart.Apdapter.PTThanhToanAdapter;
import com.example.myapplication.Presentation.Cart.Apdapter.VanChuyenAdapter;
import com.example.myapplication.Presentation.Cart.Model.DiaChiGH;
import com.example.myapplication.Presentation.Cart.Model.KhuyenMai;
import com.example.myapplication.Presentation.Cart.Model.PTThanhToan;
import com.example.myapplication.Presentation.Cart.Model.VanChuyen;
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;
import com.example.myapplication.R;

import java.util.List;

public class ThongTinActivity extends AppCompatActivity {
    private TextView toolbar_thongtin_title;
    private EditText ed_NhapCode;
    private Button btn_XacNhanCode, btn_ThongTin_OK;
    private RecyclerView rv_Choose_info;
    private LinearLayout ll_Promo_Code;
    private Toolbar toolbar_choose_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_info);

        init();
        HienThiDanhSach();
    }
    private void init(){
        toolbar_choose_info = findViewById(R.id.toolbar_choose_info);
        setSupportActionBar(toolbar_choose_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_choose_info.setTitle("");
        toolbar_thongtin_title = findViewById(R.id.toolbar_thongtin_title);
        ed_NhapCode = findViewById(R.id.ed_NhapCode);
        btn_XacNhanCode = findViewById(R.id.btn_XacNhanCode);
        btn_ThongTin_OK = findViewById(R.id.btn_ThongTin_OK);
        rv_Choose_info = findViewById(R.id.rv_Choose_info);
        ll_Promo_Code = findViewById((R.id.ll_Promo_Code));
        ll_Promo_Code.setVisibility(View.GONE);
    }
    private void HienThiDanhSach(){
        Intent i = getIntent();
        String type = i.getStringExtra("Loai");
        CartRepository re = new CartRepository();
        switch (type){
            case "DiaChi":
                toolbar_thongtin_title.setText("Choose Delivery Address");
                List<DiaChiGH> list_dc = re.getListAddress();
                DiaChiGHAdapter adapter_dc =new DiaChiGHAdapter(this, list_dc);
                this.rv_Choose_info.setAdapter(adapter_dc);
                this.rv_Choose_info.setLayoutManager(new LinearLayoutManager(this));
                return;
            case "VanChuyen":
                toolbar_thongtin_title.setText("Choose Delivery");
                List<VanChuyen> list_vc = re.getListDelivery();
                VanChuyenAdapter adapter_vc =new VanChuyenAdapter(this, list_vc);
                this.rv_Choose_info.setAdapter(adapter_vc);
                this.rv_Choose_info.setLayoutManager(new LinearLayoutManager(this));
                return;
            case "ThanhToan":
                toolbar_thongtin_title.setText("Choose Payment Methods");
                List<PTThanhToan> list_tt = re.getListMP();
                PTThanhToanAdapter adapter_tt =new PTThanhToanAdapter(this, list_tt);
                this.rv_Choose_info.setAdapter(adapter_tt);
                this.rv_Choose_info.setLayoutManager(new LinearLayoutManager(this));
                return;
            case "KhuyenMai":
                toolbar_thongtin_title.setText("Promos & Vouchers");
                ll_Promo_Code.setVisibility(View.VISIBLE);
                List<KhuyenMai> list_km = re.getListKhuyenMai();
                KhuyenMaiAdapter adapter_km =new KhuyenMaiAdapter(this, list_km);
                this.rv_Choose_info.setAdapter(adapter_km);
                this.rv_Choose_info.setLayoutManager(new LinearLayoutManager(this));
                return;
        }
    }
}