package com.example.myapplication.Presentation.GH;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Model.DonHang;
import com.example.myapplication.R;

public class OrderDetailsActivity extends AppCompatActivity {
    private TextView  tvCheckoutTenDiaChiGiaoHang, tvCheckoutDiaChiGiaoHang, tvCheckoutTenDonViGiaoHang,
            tvCheckoutThoiGianGiaoHang,tvTenKhuyenMai,tvThongTinKhuyenMai,tvCheckoutPhiDichVu,tvCheckoutPhiGiaoHang,
            tvCheckoutTienThue,tvCheckoutTienKhuyenMai,tvCheckoutTongTien,tv_Checkout_ThanhTien,rv_Checkout_DanhSachDonHang;

    private RecyclerView recyclerView;
    private ODAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gh_activity_order_detail);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        DonHang donHang = (DonHang) getIntent().getSerializableExtra("DONHANG");

        recyclerView = findViewById(R.id.rvDanhSachDonHang);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


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
        tvCheckoutPhiDichVu.setText(String.valueOf(donHang.getphiDichVu()));
        tvCheckoutPhiGiaoHang.setText(String.valueOf(donHang.getPhiGiaoHang()));
        tvCheckoutTienThue.setText(String.valueOf(donHang.getThue()));
        tvCheckoutTienKhuyenMai.setText(String.valueOf(donHang.getTienKhuyenMai()));
        tvCheckoutTongTien.setText(String.valueOf(donHang.getTongTien()));
        tv_Checkout_ThanhTien.setText(String.valueOf(donHang.getThanhTien()));

        CartRepository repository = new CartRepository();
        DonHang dh1 = repository.getListDH().get(0); // Assuming you're interested in the first order

        adapter = new ODAdapter(dh1.getListDonHangChiTiet());
        recyclerView.setAdapter(adapter);


    }
}
