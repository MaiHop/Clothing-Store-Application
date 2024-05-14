package com.example.myapplication.Presentation.GH;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Data.Data_Source.Hung_test;
import com.example.myapplication.Domain.Model.DiaChi;
import com.example.myapplication.Domain.Model.KhuyenMai;
import com.example.myapplication.Domain.Model.VanChuyen;
import com.example.myapplication.R;

import java.util.List;

public class OrderDetailsActivity extends AppCompatActivity {
    private TextView  tvCheckoutTenDiaChiGiaoHang, tvCheckoutDiaChiGiaoHang, tvCheckoutTenDonViGiaoHang,
            tvCheckoutThoiGianGiaoHang,tvTenKhuyenMai,tvThongTinKhuyenMai;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gh_activity_order_detail);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        tvCheckoutTenDiaChiGiaoHang = findViewById(R.id.txtTenDiaChiGiaoHang);
        tvCheckoutDiaChiGiaoHang = findViewById(R.id.txtDiaChiGiaoHang);
        tvCheckoutTenDonViGiaoHang = findViewById(R.id.txtDonViGiaoHang);
        tvCheckoutThoiGianGiaoHang = findViewById(R.id.txtThoiGianGiaoHang);
        tvTenKhuyenMai = findViewById(R.id.txtTenKhuyenMai);
        tvThongTinKhuyenMai = findViewById(R.id.txtThongTinKhuyenMai);

        Hung_test test = new Hung_test();
        List<DiaChi> listdc = test.getListDC();
        List<VanChuyen> listvc = test.getListVC();
        List<KhuyenMai> listkm = test.getListKM();

        DiaChi dc = listdc.get(0);
        VanChuyen vc = listvc.get(0);
        KhuyenMai km = listkm.get(0);

        tvCheckoutDiaChiGiaoHang.setText(dc.getDiaChi());
        tvCheckoutTenDiaChiGiaoHang.setText(dc.getTenDiaChi());
        tvCheckoutTenDonViGiaoHang.setText(vc.getTen());
        tvCheckoutThoiGianGiaoHang.setText(vc.getNgayGiao());
        tvTenKhuyenMai.setText(km.getTenKhuyenMai());
        tvThongTinKhuyenMai.setText(km.getDieuKien()+" * Tối đa giảm : "+km.getToiDaGiam()+" * "+dateFormat.format(km.getHanSuDung()));
    }
}
