package com.example.myapplication.Presentation.PhucHoi.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Domain.Model.NhomSP;
import com.example.myapplication.Domain.Model.SanPham;
import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Presentation.PhucHoi.Apdapter.SanPhamAdapter;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DanhMucActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SanPhamAdapter sanPhamAdapter;
    private List<SanPham> sanPhamList;
    private TextView tvNhomSPName;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.women_layout);
//        tvNhomSPName = findViewById(R.id.tendanhmuc);
//
//        ImageView backButton = findViewById(R.id.imageViewBack);
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Xử lý khi người dùng nhấn vào nút back (ImageView backButton)
//                // Ví dụ: Đóng Activity hiện tại khi nhấn nút back
//                finish(); // Đóng Activity và trở về Activity trước đó (nếu có)
//            }
//        });
//
//        recyclerView = findViewById(R.id.viewwomen);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        // Lấy toàn bộ danh sách sản phẩm từ CartRepository
//        CartRepository cartRepository = new CartRepository();
//        sanPhamList = cartRepository.getSanPham();
//
//        // Lọc danh sách sản phẩm tương ứng với nhóm sản phẩm được chọn (nhomSPId)
//        String nhomSPId = getIntent().getStringExtra("nhomSPId");
//        List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
//
//        // Khởi tạo và thiết lập adapter cho RecyclerView với danh sách sản phẩm đã lọc
//        sanPhamAdapter = new SanPhamAdapter(filteredList, this, getLayoutInflater());
//        recyclerView.setAdapter(sanPhamAdapter);
//
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.setHasFixedSize(true);
//    }
//
//    // Phương thức lọc danh sách sản phẩm theo nhóm sản phẩm (nhomSPId)
//    private List<SanPham> filterSanPhamByNhomSPId(List<SanPham> sanPhamList, String nhomSPId) {
//        List<SanPham> filteredList = new ArrayList<>();
//        for (SanPham sanPham : sanPhamList) {
//            if (sanPham.getNhomSanPham().getId().equals(nhomSPId)) {
//                filteredList.add(sanPham);
//            }
//        }
//        return filteredList;
//    }
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.hoi_women_layout);

    tvNhomSPName = findViewById(R.id.tendanhmuc);

    ImageView backButton = findViewById(R.id.imageViewBack);
    backButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });

    recyclerView = findViewById(R.id.viewwomen);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    // Lấy nhomSPId từ Intent
    String nhomSPId = getIntent().getStringExtra("nhomSPId");

    // Tìm và hiển thị tên của NhomSP lên tvNhomSPName
    NhomSP nhomSP = findNhomSPById(nhomSPId);
    if (nhomSP != null) {
        tvNhomSPName.setText(nhomSP.getTen());
    }

    // Lấy danh sách sản phẩm từ CartRepository
    CartRepository cartRepository = new CartRepository();
    sanPhamList = cartRepository.getSanPham();

    // Lọc danh sách sản phẩm theo nhomSPId và thiết lập adapter cho RecyclerView
    List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
    sanPhamAdapter = new SanPhamAdapter(filteredList, this, getLayoutInflater());
    recyclerView.setAdapter(sanPhamAdapter);
}

    // Phương thức lọc danh sách sản phẩm theo nhóm sản phẩm (nhomSPId)
    private List<SanPham> filterSanPhamByNhomSPId(List<SanPham> sanPhamList, String nhomSPId) {
        List<SanPham> filteredList = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            if (sanPham.getNhomSanPham().getId().equals(nhomSPId)) {
                filteredList.add(sanPham);
            }
        }
        return filteredList;
    }

    // Phương thức tìm NhomSP theo nhomSPId
    private NhomSP findNhomSPById(String nhomSPId) {
        CartRepository cartRepository = new CartRepository();
        List<NhomSP> nhomSPList = cartRepository.getListNhomSP();
        for (NhomSP nhomSP : nhomSPList) {
            if (nhomSP.getId().equals(nhomSPId)) {
                return nhomSP;
            }
        }
        return null;
    }
}


