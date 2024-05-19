package com.example.myapplication.Presentation.GH;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Model.DonHang;
import com.example.myapplication.R;

public class OrderDetailsFragment extends Fragment {
    private TextView tvCheckoutTenDiaChiGiaoHang, tvCheckoutDiaChiGiaoHang, tvCheckoutTenDonViGiaoHang,
            tvCheckoutThoiGianGiaoHang, tvTenKhuyenMai, tvThongTinKhuyenMai, tvCheckoutPhiDichVu,
            tvCheckoutPhiGiaoHang, tvCheckoutTienThue, tvCheckoutTienKhuyenMai, tvCheckoutTongTien, tv_Checkout_ThanhTien;

    private RecyclerView recyclerView;
    private ODAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gh_activity_order_detail, container, false);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
//        recyclerView = view.findViewById(R.id.rvDanhSachDonHang);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//        tvCheckoutTenDiaChiGiaoHang = view.findViewById(R.id.txtTenDiaChiGiaoHang);
//        tvCheckoutDiaChiGiaoHang = view.findViewById(R.id.txtDiaChiGiaoHang);
//        tvCheckoutTenDonViGiaoHang = view.findViewById(R.id.txtDonViGiaoHang);
//        tvCheckoutThoiGianGiaoHang = view.findViewById(R.id.txtThoiGianGiaoHang);
//        tvTenKhuyenMai = view.findViewById(R.id.txtTenKhuyenMai);
//        tvThongTinKhuyenMai = view.findViewById(R.id.txtThongTinKhuyenMai);
//        tvCheckoutPhiDichVu = view.findViewById(R.id.txtPhiDichVu);
//        tvCheckoutPhiGiaoHang = view.findViewById(R.id.txtPhiGiaoHang);
//        tvCheckoutTienThue = view.findViewById(R.id.txtTienThue);
//        tvCheckoutTienKhuyenMai = view.findViewById(R.id.txtTienKhuyenMai);
//        tvCheckoutTongTien = view.findViewById(R.id.txtTongTien);
//        tv_Checkout_ThanhTien = view.findViewById(R.id.txtThanhTien);

        // Fetch the order from the arguments
        DonHang donHang = (DonHang) getArguments().getSerializable("DONHANG");

        tvCheckoutTenDiaChiGiaoHang.setText(donHang.getDiachi().getDiaChi());
        tvCheckoutDiaChiGiaoHang.setText(donHang.getDiachi().getTenDiaChi());
        tvCheckoutTenDonViGiaoHang.setText(donHang.getVanchuyen().getTen());
        tvCheckoutThoiGianGiaoHang.setText(donHang.getVanchuyen().getNgayGiao());
        tvTenKhuyenMai.setText(donHang.getKhuyenmai().getTenKhuyenMai());
        tvThongTinKhuyenMai.setText(donHang.getKhuyenmai().getDieuKien() + " * Tối đa giảm : " + donHang.getKhuyenmai().getToiDaGiam() + " * " + dateFormat.format(donHang.getKhuyenmai().getHanSuDung()));
        tvCheckoutPhiDichVu.setText(String.valueOf(donHang.getphiDichVu()));
        tvCheckoutPhiGiaoHang.setText(String.valueOf(donHang.getPhiGiaoHang()));
        tvCheckoutTienThue.setText(String.valueOf(donHang.getThue()));
        tvCheckoutTienKhuyenMai.setText(String.valueOf(donHang.getTienKhuyenMai()));
        tvCheckoutTongTien.setText(String.valueOf(donHang.getTongTien()));
        tv_Checkout_ThanhTien.setText(String.valueOf(donHang.getThanhTien()));

        CartRepository repository = new CartRepository();
//        DonHang dh1 = repository.getListDH().get(0); // Assuming you're interested in the first order

//        adapter = new ODAdapter(dh1.getListDonHangChiTiet());
        recyclerView.setAdapter(adapter);

        return view;
    }

    public static OrderDetailsFragment newInstance(DonHang donHang) {
        OrderDetailsFragment fragment = new OrderDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable("DONHANG", donHang);
        fragment.setArguments(args);
        return fragment;
    }
}
