package com.example.myapplication.Presentation.Cart.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.Presentation.Cart.Apdapter.CheckOutAdapter;
import com.example.myapplication.Presentation.Cart.Model.Cart;
import com.example.myapplication.Presentation.Cart.Model.DonHang;
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;
import com.example.myapplication.R;

import java.util.List;

public class ThanhToanActivity extends AppCompatActivity {
    private RecyclerView rv_ListOrder;
    private TextView order_title, tv_Checkout_TenDiaChiGiaoHang,tv_Checkout_DiaChiGiaoHang,tv_Checkout_TenDonViGiaoHang,
    tv_Checkout_ThoiGianGiaoHang,tv_TenPhuongThucThanhToan,tv_SoThe,tv_TenKhuyenMai,tv_ThongTinKhuyenMai,
    tv_Checkout_TienKhuyenMai,tv_Checkout_TongTien,tv_Checkout_TienThue,tv_Checkout_ThanhTien,tv_Checkout_PhiDichVu,
            tv_Checkout_PhiGiaoHang;
    private ImageView iv_PV_Remove,iv_DanhSachDiaChiGiaoHang,iv_DanhSachVanChuyen,iv_DanhSachThanhToan,
    iv_DanhSachKhuyenMai;

    private Button btn_XacNhanDonHang;

    private LinearLayout ll_Delivery_Address, ll_Delivery, ll_Payment_Method, ll_Promos_Vouchers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        init();
        loadinfo();



    }

    private void loadinfo() {
        Intent i = getIntent();
        DonHang dh = (DonHang) i.getSerializableExtra("DonHang");

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
            this.tv_Checkout_TenDonViGiaoHang.setText(dh.getVanchuyen().getTenDonVI());
            this.tv_Checkout_ThoiGianGiaoHang.setText(dh.getVanchuyen().getThoiGian());
            this.ll_Delivery.setVisibility(View.VISIBLE);
        }
        if (dh.getThanhToan() == null){
            this.ll_Payment_Method.setVisibility(View.GONE);
        }else {
            this.tv_TenPhuongThucThanhToan.setText(dh.getThanhToan().getTenPhuongThuc());
            this.tv_SoThe.setText("");
            this.ll_Payment_Method.setVisibility(View.VISIBLE);
        }
        if (dh.getKhuyenmai() == null){
            this.ll_Promos_Vouchers.setVisibility(View.GONE);
        }else {
            this.tv_TenKhuyenMai.setText(dh.getKhuyenmai().getTenKhuyenMai());
            this.tv_ThongTinKhuyenMai.setText(dh.getKhuyenmai().getChiTietKhuyenMai());
            this.iv_PV_Remove.setVisibility(View.VISIBLE);
            this.ll_Promos_Vouchers.setVisibility(View.VISIBLE);
        }
        this.tv_Checkout_ThanhTien.setText(String.valueOf(dh.getThanhTien()));
        this.tv_Checkout_PhiDichVu.setText(String.valueOf(dh.getPhiPhucVu()));
        this.tv_Checkout_PhiGiaoHang.setText(String.valueOf(dh.getPhiGiaoHang()));
        this.tv_Checkout_TienThue.setText(String.valueOf(dh.getThue()));
        this.tv_Checkout_TienKhuyenMai.setText(String.valueOf(dh.getTienKhuyenMai()));
        this.tv_Checkout_TongTien.setText(String.valueOf(dh.getTongCong()));

        CartRepository re = new CartRepository();
        List<Cart> list = re.getAll();

        CheckOutAdapter cartAdapter =new CheckOutAdapter(this, list, this.order_title);
        this.rv_ListOrder.setAdapter(cartAdapter);
        this.rv_ListOrder.setLayoutManager(new LinearLayoutManager(this));
    }

    private void init(){
        //RecycleView
        this.rv_ListOrder =findViewById(R.id.rv_Checkout_DanhSachDonHang);
        //LinearLayout
        this.ll_Delivery_Address = findViewById(R.id.ll_Delivery_Address);
        this.ll_Delivery = findViewById(R.id.ll_Delivery);
        this.ll_Payment_Method = findViewById(R.id.ll_Payment_Method);
        this.ll_Promos_Vouchers = findViewById(R.id.ll_Promos_Vouchers);
        //TextView
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
        this.tv_Checkout_PhiDichVu = findViewById(R.id.tv_Checkout_PhiDichVu);
        this.tv_Checkout_PhiGiaoHang = findViewById(R.id.tv_Checkout_PhiGiaoHang);
        this.tv_Checkout_TienThue = findViewById(R.id.tv_Checkout_TienThue);
        this.tv_Checkout_TienKhuyenMai = findViewById(R.id.tv_Checkout_TienKhuyenMai);
        this.tv_Checkout_TongTien = findViewById(R.id.tv_Checkout_TongTien);
        //ImageView
        this.iv_PV_Remove = findViewById(R.id.iv_PV_Remove);
        this.iv_DanhSachThanhToan = findViewById(R.id.iv_DanhSachThanhToan);
        this.iv_DanhSachDiaChiGiaoHang = findViewById(R.id.iv_DanhSachDiaChiGiaoHang);
        this.iv_DanhSachVanChuyen = findViewById(R.id.iv_DanhSachVanChuyen);
        this.iv_DanhSachKhuyenMai = findViewById(R.id.iv_DanhSachKhuyenMai);
        //Button
        this.btn_XacNhanDonHang = findViewById(R.id.btn_XacNhanDonHang);
    }
}