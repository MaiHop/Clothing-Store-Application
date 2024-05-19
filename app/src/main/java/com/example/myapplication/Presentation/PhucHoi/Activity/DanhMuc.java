//package com.example.myapplication.Presentation.PhucHoi.Activity;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.myapplication.Model.SanPham;
//import com.example.myapplication.Presentation.PhucHoi.Apdapter.SanPhamAdapter;
//import com.example.myapplication.R;
//
//import java.util.List;
//
//public class DanhMuc extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.hoi_filter_dialog);
//
//        // Nhận danh sách sản phẩm từ Intent
//        List<SanPham> productList = (List<SanPham>) getIntent().getSerializableExtra("productListnew");
//
//        // Tiếp tục với việc sử dụng danh sách sản phẩm để cấu hình RecyclerView
//        RecyclerView recyclerView = findViewById(R.id.viewwomen);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        SanPhamAdapter adapter = new SanPhamAdapter(productList, this, getLayoutInflater());
//        recyclerView.setAdapter(adapter);
//    }
//}
