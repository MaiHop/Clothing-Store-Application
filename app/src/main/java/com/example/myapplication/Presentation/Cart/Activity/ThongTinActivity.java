package com.example.myapplication.Presentation.Cart.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Presentation.Cart.Apdapter.DiaChiGHAdapter;
import com.example.myapplication.Presentation.Cart.Apdapter.KhuyenMaiAdapter;
import com.example.myapplication.Presentation.Cart.Apdapter.PTThanhToanAdapter;
import com.example.myapplication.Presentation.Cart.Apdapter.VanChuyenAdapter;
import com.example.myapplication.Presentation.Cart.Model.DiaChi;
import com.example.myapplication.Presentation.Cart.Model.DonHang;
import com.example.myapplication.Presentation.Cart.Model.KhuyenMai;
import com.example.myapplication.Presentation.Cart.Model.ThanhToan;
import com.example.myapplication.Presentation.Cart.Model.VanChuyen;
import com.example.myapplication.Presentation.Cart.ViewModel.DiaChiGHVM;
import com.example.myapplication.Presentation.Cart.ViewModel.KhuyenMaiVM;
import com.example.myapplication.Presentation.Cart.ViewModel.PTThanhToanVM;
import com.example.myapplication.Presentation.Cart.ViewModel.VanChuyenVM;
import com.example.myapplication.R;

import java.util.List;

public class ThongTinActivity extends AppCompatActivity {
    private TextView toolbar_thongtin_title;
    private EditText ed_NhapCode;
    private Button btn_XacNhanCode, btn_ThongTin_OK;
    private RecyclerView rv_Choose_info;
    private LinearLayout ll_Promo_Code;
    private Toolbar toolbar_choose_info;
    private String type;
    private DiaChiGHVM daVM;
    private VanChuyenVM vcVM;
    private PTThanhToanVM pmVM;
    private KhuyenMaiVM kmVM;
    private DonHang dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_info);

        init();
        HienThiDanhSach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (type.equals("DiaChi") || type.equals("ThanhToan")) {
            getMenuInflater().inflate(R.menu.menu_toolbar_cho_inf_add, menu);
        } else if (type.equals("KhuyenMai")) {
            getMenuInflater().inflate(R.menu.menu_toolbar_cho_inf_find, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_cho_inf_add) {
            if (type.equals("DiaChi")) {
                daVM.addDiaChi();
            } else if (type.equals("ThanhToan")) {
                pmVM.addPTThanhToan();
            }
            Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.item_cho_inf_find) {
            Toast.makeText(this, "Find", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == android.R.id.home) {
            switch (type) {
                case "DiaChi":
                    dh.setDiachi(null);
                    break;
                case "VanChuyen":
                    dh.setVanchuyen(null);
                    break;
                case "ThanhToan":
                    dh.setThanhToan(null);
                    break;
                case "KhuyenMai":
                    dh.setKhuyenmai(null);
                    break;
            }
            Intent intent = new Intent(ThongTinActivity.this, ThanhToanActivity.class);
            intent.putExtra("DonHang", dh);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void init() {
        toolbar_choose_info = findViewById(R.id.toolbar_choose_info);
        setSupportActionBar(toolbar_choose_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_choose_info.setTitle("");
        toolbar_thongtin_title = findViewById(R.id.toolbar_thongtin_title);
        ed_NhapCode = findViewById(R.id.ed_NhapCode);
        btn_XacNhanCode = findViewById(R.id.btn_XacNhanCode);
        btn_ThongTin_OK = findViewById(R.id.btn_ThongTin_OK);
        btn_ThongTin_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThongTinActivity.this, ThanhToanActivity.class);
                intent.putExtra("DonHang", dh);
                startActivity(intent);
            }
        });
        rv_Choose_info = findViewById(R.id.rv_Choose_info);
        ll_Promo_Code = findViewById((R.id.ll_Promo_Code));
        ll_Promo_Code.setVisibility(View.GONE);
    }

    private void HienThiDanhSach() {
        Intent i = getIntent();
        type = i.getStringExtra("Loai");
        dh = (DonHang) i.getSerializableExtra("DonHang");
        switch (type) {
            case "DiaChi":
                toolbar_thongtin_title.setText("Choose Delivery Address");
                this.rv_Choose_info.setLayoutManager(new LinearLayoutManager(this));
                daVM = new ViewModelProvider(this).get(DiaChiGHVM.class);
                daVM.getListDiaChiGHLiveData().observe(this, new Observer<List<DiaChi>>() {
                    @Override
                    public void onChanged(List<DiaChi> diaChis) {
                        DiaChiGHAdapter adapter_dc = new DiaChiGHAdapter(ThongTinActivity.this, diaChis, new DiaChiGHAdapter.ItemClickListener() {
                            @Override
                            public void onItemClick(DiaChi diaChiGH) {
                                dh.setDiachi(diaChiGH);
                            }
                        });
                        rv_Choose_info.setAdapter(adapter_dc);
                    }
                });
                return;
            case "VanChuyen":
                toolbar_thongtin_title.setText("Choose Delivery");
                this.rv_Choose_info.setLayoutManager(new LinearLayoutManager(this));
                vcVM = new ViewModelProvider(this).get(VanChuyenVM.class);
                vcVM.getListVanChuyenLiveData().observe(this, new Observer<List<VanChuyen>>() {
                    @Override
                    public void onChanged(List<VanChuyen> vanChuyens) {
                        VanChuyenAdapter adapter_vc = new VanChuyenAdapter(ThongTinActivity.this, vanChuyens, new VanChuyenAdapter.ItemClickListener() {
                            @Override
                            public void onItemClick(VanChuyen vanChuyen) {
                                dh.setVanchuyen(vanChuyen);
                            }
                        });
                        rv_Choose_info.setAdapter(adapter_vc);
                    }
                });
                return;
            case "ThanhToan":
                toolbar_thongtin_title.setText("Choose Payment Methods");
                this.rv_Choose_info.setLayoutManager(new LinearLayoutManager(this));
                pmVM = new ViewModelProvider(this).get(PTThanhToanVM.class);
                pmVM.getListPTThanhToanLiveData().observe(this, new Observer<List<ThanhToan>>() {
                    @Override
                    public void onChanged(List<ThanhToan> thanhToans) {
                        PTThanhToanAdapter adapter_tt = new PTThanhToanAdapter(ThongTinActivity.this, thanhToans, new PTThanhToanAdapter.ItemClickListener() {
                            @Override
                            public void onItemClick(ThanhToan ptThanhToan) {
                                dh.setThanhToan(ptThanhToan);
                            }
                        });
                        rv_Choose_info.setAdapter(adapter_tt);
                    }
                });
                return;
            case "KhuyenMai":
                toolbar_thongtin_title.setText("Promos & Vouchers");
                this.rv_Choose_info.setLayoutManager(new LinearLayoutManager(this));
                kmVM = new ViewModelProvider(this).get(KhuyenMaiVM.class);
                kmVM.getListKhuyenMaiLiveData().observe(this, new Observer<List<KhuyenMai>>() {
                    @Override
                    public void onChanged(List<KhuyenMai> khuyenMais) {
                        KhuyenMaiAdapter adapter_km = new KhuyenMaiAdapter(ThongTinActivity.this, khuyenMais, new KhuyenMaiAdapter.ItemClickListener() {
                            @Override
                            public void onItemClick(KhuyenMai khuyenMai) {
                                dh.setKhuyenmai(khuyenMai);
                            }
                        });
                        rv_Choose_info.setAdapter(adapter_km);
                    }
                });
                return;
        }
    }
}