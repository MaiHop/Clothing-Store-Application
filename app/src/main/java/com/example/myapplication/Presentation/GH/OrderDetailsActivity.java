package com.example.myapplication.Presentation.GH;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Data.Data_Source.Hung_test;
import com.example.myapplication.Domain.Model.DiaChi;
import com.example.myapplication.Domain.Model.DonHang;
import com.example.myapplication.Domain.Model.KhuyenMai;
import com.example.myapplication.Domain.Model.VanChuyen;
import com.example.myapplication.R;

import java.util.List;

public class OrderDetailsActivity extends AppCompatActivity {
    private TextView  tvCheckoutTenDiaChiGiaoHang, tvCheckoutDiaChiGiaoHang, tvCheckoutTenDonViGiaoHang,
            tvCheckoutThoiGianGiaoHang,tvTenKhuyenMai,tvThongTinKhuyenMai,tvCheckoutPhiDichVu,tvCheckoutPhiGiaoHang,
            tvCheckoutTienThue,tvCheckoutTienKhuyenMai,tvCheckoutTongTien,tv_Checkout_ThanhTien;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gh_activity_order_detail);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        DonHang donHang = (DonHang) getIntent().getSerializableExtra("DONHANG");

        tvCheckoutTenDiaChiGiaoHang = findViewById(R.id.txtTenDiaChiGiaoHang);
        tvCheckoutDiaChiGiaoHang = findViewById(R.id.txtDiaChiGiaoHang);
        tvCheckoutTenDonViGiaoHang = findViewById(R.id.txtDonViGiaoHang);
        tvCheckoutThoiGianGiaoHang = findViewById(R.id.txtThoiGianGiaoHang);
        tvTenKhuyenMai = findViewById(R.id.txtTenKhuyenMai);
        tvThongTinKhuyenMai = findViewById(R.id.txtThongTinKhuyenMai);
        tvCheckoutPhiDichVu = findViewById(R.id.txtPhiDichVu);
        tvCheckoutPhiGiaoHang = findViewById(R.id.txtPhiGiaoHang);
        tvCheckoutTienThue = findViewById(R.id.txtTienThue);
        tvCheckoutTienKhuyenMai = findViewById(R.id.txtTienKhuyenMai);
        tvCheckoutTongTien = findViewById(R.id.txtTongTien);
        tv_Checkout_ThanhTien = findViewById(R.id.txtThanhTien);


        tvCheckoutTenDiaChiGiaoHang.setText(donHang.getDiachi().getDiaChi());
        tvCheckoutDiaChiGiaoHang.setText(donHang.getDiachi().getTenDiaChi());
        tvCheckoutTenDonViGiaoHang.setText(donHang.getVanchuyen().getTen());
        tvCheckoutThoiGianGiaoHang.setText(donHang.getVanchuyen().getNgayGiao());
        tvTenKhuyenMai.setText(donHang.getKhuyenmai().getTenKhuyenMai());
        tvThongTinKhuyenMai.setText(donHang.getKhuyenmai().getDieuKien()+" * Tối đa giảm : "+donHang.getKhuyenmai().getToiDaGiam()+" * "+dateFormat.format(donHang.getKhuyenmai().getHanSuDung()));
        tvCheckoutPhiDichVu.setText(String.valueOf(donHang.getPhiPhucVu()));
        tvCheckoutPhiGiaoHang.setText(String.valueOf(donHang.getPhiGiaoHang()));
        tvCheckoutTienThue.setText(String.valueOf(donHang.getThue()));
        tvCheckoutTienKhuyenMai.setText(String.valueOf(donHang.getTienKhuyenMai()));
        tvCheckoutTongTien.setText(String.valueOf(donHang.getTongTien()));
        tv_Checkout_ThanhTien.setText(String.valueOf(donHang.getThanhTien()));


    }
}
