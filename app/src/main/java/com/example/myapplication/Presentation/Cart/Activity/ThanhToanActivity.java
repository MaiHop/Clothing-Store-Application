package com.example.myapplication.Presentation.Cart.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Presentation.Cart.Apdapter.CheckOutAdapter;
import com.example.myapplication.Presentation.Cart.Model.DonHangChiTiet;
import com.example.myapplication.Presentation.Cart.Model.DonHang;
import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class ThanhToanActivity extends AppCompatActivity {
    private RecyclerView rv_ListOrder;
    private TextView order_title, tv_Checkout_TenDiaChiGiaoHang,tv_Checkout_DiaChiGiaoHang,tv_Checkout_TenDonViGiaoHang,
    tv_Checkout_ThoiGianGiaoHang,tv_TenPhuongThucThanhToan,tv_SoThe,tv_TenKhuyenMai,tv_ThongTinKhuyenMai,
    tv_Checkout_TienKhuyenMai,tv_Checkout_TongTien,tv_Checkout_TienThue,tv_Checkout_ThanhTien,tv_Checkout_PhiDichVu,
            tv_Checkout_PhiGiaoHang,tv_Subtotal,toolbar_checkout_title;
    private ImageView iv_PV_Remove,iv_DanhSachDiaChiGiaoHang,iv_DanhSachVanChuyen,iv_DanhSachThanhToan,
    iv_DanhSachKhuyenMai;

    private Button btn_XacNhanDonHang,btn_ViewOrder, btn_BackToHome;
    String type="";
    private Toolbar toolbar_checkout_cart;
    private LinearLayout ll_Delivery_Address, ll_Delivery, ll_Payment_Method, ll_Promos_Vouchers;
    private DonHang dh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        init();
        loadinfo();
    }

    private void loadinfo() {
        Intent i = getIntent();
        dh = (DonHang) i.getSerializableExtra("DonHang");
        if(dh.getDiachi() == null || dh.getVanchuyen() == null || dh.getThanhToan() == null){
            this.btn_XacNhanDonHang.setEnabled(false);
        }

        if (dh.getDiachi() == null){
            this.ll_Delivery_Address.setVisibility(View.GONE);
        }else {
            this.tv_Checkout_TenDiaChiGiaoHang.setText(dh.getDiachi().getTenDiaChi()+" ("+dh.getDiachi().getNguoiNhan()+")");
            this.tv_Checkout_DiaChiGiaoHang.setText(dh.getDiachi().getDiaChi());
            this.ll_Delivery_Address.setVisibility(View.VISIBLE);
        }
        if (dh.getVanchuyen() == null){
            this.ll_Delivery.setVisibility(View.GONE);
        }else {
            this.tv_Checkout_TenDonViGiaoHang.setText(dh.getVanchuyen().getTen());
            this.tv_Checkout_ThoiGianGiaoHang.setText("Ngày giao dự kiến: "+dh.getVanchuyen().getNgayGiao());
            this.ll_Delivery.setVisibility(View.VISIBLE);
        }
        if (dh.getThanhToan() == null){
            this.ll_Payment_Method.setVisibility(View.GONE);
        }else {
            this.tv_TenPhuongThucThanhToan.setText(dh.getThanhToan().getLoai());
            if(dh.getThanhToan().getTenThanhToan() == null){
                this.tv_SoThe.setVisibility(View.GONE);
            }else {
                this.tv_SoThe.setText(dh.getThanhToan().getTenThanhToan());
            }
        }
        if (dh.getKhuyenmai() == null){
            this.ll_Promos_Vouchers.setVisibility(View.GONE);
        }else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            this.tv_TenKhuyenMai.setText(dh.getKhuyenmai().getTenKhuyenMai());
            this.tv_ThongTinKhuyenMai.setText(dh.getKhuyenmai().getDieuKien()+" * Tối đa giảm : "+dh.getKhuyenmai().getToiDaGiam()+" * "+dateFormat.format(dh.getKhuyenmai().getHanSuDung()));
            this.iv_PV_Remove.setVisibility(View.VISIBLE);
            this.ll_Promos_Vouchers.setVisibility(View.VISIBLE);
            this.iv_PV_Remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dh.setKhuyenmai(null);
                    loadinfo();
//                    Toast.makeText(ThanhToanActivity.this, "OK",Toast.LENGTH_SHORT).show();
                }
            });
        }
        this.tv_Subtotal.setText("Subtotal ("+ dh.getListDonHangChiTiet().size()+")");
        this.tv_Checkout_ThanhTien.setText(String.valueOf("$"+dh.getThanhTien()));
        this.tv_Checkout_PhiDichVu.setText(String.valueOf("$"+dh.getPhiPhucVu()));
        this.tv_Checkout_PhiGiaoHang.setText(String.valueOf("$"+dh.getPhiGiaoHang()));
        this.tv_Checkout_TienThue.setText(String.valueOf("$"+dh.getThue()));
        this.tv_Checkout_TienKhuyenMai.setText(String.valueOf("-$"+dh.getTienKhuyenMai()));
        this.tv_Checkout_TongTien.setText(String.valueOf("$"+dh.getTongTien()));



        CheckOutAdapter cartAdapter =new CheckOutAdapter(this, dh.getListDonHangChiTiet(), this.order_title);
        this.rv_ListOrder.setAdapter(cartAdapter);
        this.rv_ListOrder.setLayoutManager(new LinearLayoutManager(this));
    }

    private void init(){
        //ToolBar
        toolbar_checkout_cart = findViewById(R.id.toolbar_checkout_cart);
        setSupportActionBar(toolbar_checkout_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_checkout_cart.setTitle("");
        //RecycleView
        this.rv_ListOrder =findViewById(R.id.rv_Checkout_DanhSachDonHang);
        //LinearLayout
        this.ll_Delivery_Address = findViewById(R.id.ll_Delivery_Address);
        this.ll_Delivery = findViewById(R.id.ll_Delivery);
        this.ll_Payment_Method = findViewById(R.id.ll_Payment_Method);
        this.ll_Promos_Vouchers = findViewById(R.id.ll_Promos_Vouchers);
        //TextView
        this.toolbar_checkout_title = findViewById(R.id.toolbar_checkout_title);
        toolbar_checkout_cart.setTitle("Checkout");
        this.order_title = findViewById(R.id.tv_Checkout_TieuDeDonHang);
        this.tv_Checkout_TenDiaChiGiaoHang = findViewById(R.id.tv_Checkout_TenDiaChiGiaoHang);
        this.tv_Checkout_DiaChiGiaoHang = findViewById(R.id.tv_Checkout_DiaChiGiaoHang);
        this.tv_Checkout_TenDonViGiaoHang = findViewById(R.id.tv_Checkout_TenDonViGiaoHang);
        this.tv_Checkout_ThoiGianGiaoHang = findViewById(R.id.tv_Checkout_ThoiGianGiaoHang);
        this.tv_TenPhuongThucThanhToan = findViewById(R.id.tv_TenPhuongThucThanhToan);
        this.tv_SoThe = findViewById(R.id.tv_SoThe);
        this.tv_TenKhuyenMai = findViewById(R.id.tv_TenKhuyenMai);
        this.tv_ThongTinKhuyenMai = findViewById(R.id.tv_ThongTinKhuyenMai);
        this.tv_Checkout_ThanhTien = findViewById(R.id.tv_Checkout_ThanhTien);
        this.tv_Subtotal = findViewById(R.id.tv_Subtotal);
        this.tv_Checkout_PhiDichVu = findViewById(R.id.tv_Checkout_PhiDichVu);
        this.tv_Checkout_PhiGiaoHang = findViewById(R.id.tv_Checkout_PhiGiaoHang);
        this.tv_Checkout_TienThue = findViewById(R.id.tv_Checkout_TienThue);
        this.tv_Checkout_TienKhuyenMai = findViewById(R.id.tv_Checkout_TienKhuyenMai);
        this.tv_Checkout_TongTien = findViewById(R.id.tv_Checkout_TongTien);
        //ImageView
        this.iv_PV_Remove = findViewById(R.id.iv_PV_Remove);
        this.iv_DanhSachDiaChiGiaoHang = findViewById(R.id.iv_DanhSachDiaChiGiaoHang);
        this.iv_DanhSachDiaChiGiaoHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "DiaChi";
                DanhSachThongTin(type);
            }
        });
        this.iv_DanhSachVanChuyen = findViewById(R.id.iv_DanhSachVanChuyen);
        this.iv_DanhSachVanChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "VanChuyen";
                DanhSachThongTin(type);
            }
        });
        this.iv_DanhSachThanhToan = findViewById(R.id.iv_DanhSachThanhToan);
        this.iv_DanhSachThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "ThanhToan";
                DanhSachThongTin(type);
            }
        });
        this.iv_DanhSachKhuyenMai = findViewById(R.id.iv_DanhSachKhuyenMai);
        this.iv_DanhSachKhuyenMai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = "KhuyenMai";
                DanhSachThongTin(type);

            }
        });
        //Button
        this.btn_XacNhanDonHang = findViewById(R.id.btn_XacNhanDonHang);

        this.btn_XacNhanDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog process = new Dialog(ThanhToanActivity.this);
                process.setContentView(R.layout.dialog_processing_payments);
                process.getWindow().setBackgroundDrawable(getDrawable(R.drawable.solid_white_rad_10));
                process.setCancelable(true);
                process.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        process.dismiss();
                        Dialog order = new Dialog(ThanhToanActivity.this);
                        order.setContentView(R.layout.dialog_order_confirmed);
                        order.getWindow().setBackgroundDrawable(getDrawable(R.drawable.solid_white_rad_10));
                        order.setCancelable(true);
                        order.show();

                        btn_ViewOrder = order.findViewById(R.id.btn_ViewOrder);
                        btn_ViewOrder.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(ThanhToanActivity.this,"OK",Toast.LENGTH_SHORT).show();
                            }
                        });
                        btn_BackToHome = order.findViewById(R.id.btn_BackToHome);
                        btn_BackToHome.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(ThanhToanActivity.this,"OK",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                },1000);
            }
        });
    }

    private void DanhSachThongTin(String type) {
        Intent intent = new Intent(this, ThongTinActivity.class);
        intent.putExtra("Loai", type);
        intent.putExtra("DonHang", dh);
        startActivity(intent);
    }
}