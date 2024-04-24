//package com.example.myapplication.Presentation.Cart.Activity;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.myapplication.Presentation.Cart.Apdapter.ColorAdapterPH;
//import com.example.myapplication.Presentation.Cart.Apdapter.SizeAdapterPH;
//import com.example.myapplication.Presentation.Cart.Model.KichThuoc;
//import com.example.myapplication.Presentation.Cart.Model.Mau;
//import com.example.myapplication.Presentation.Cart.Model.SanPham;
//import com.example.myapplication.Presentation.Cart.Repository.CartRepository;
//import com.example.myapplication.R;
//import com.squareup.picasso.Picasso;
//
//import java.util.List;
//
//public class ChiTietSanPhamActivity extends AppCompatActivity {
//
//    private ImageView imageViewProduct;
//    private TextView textViewProductName;
//    private TextView textViewProductDescription;
//    private TextView textViewProductPrice;
//    private RecyclerView recyclerViewKichThuoc;
//    private RecyclerView recyclerViewMauSac;
//
//    private SizeAdapterPH kichThuocAdapter;
//    private ColorAdapterPH mauAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.detail);
//
//        // Ánh xạ các thành phần trong layout
//        imageViewProduct = findViewById(R.id.imageslider);
//        textViewProductName = findViewById(R.id.tilte);
//        textViewProductDescription = findViewById(R.id.thongtinsp);
//        textViewProductPrice = findViewById(R.id.price);
//        recyclerViewKichThuoc = findViewById(R.id.recylerviewsize);
//        recyclerViewMauSac = findViewById(R.id.recylerviewcolor);
//
//        // Lấy thông tin sản phẩm từ Intent
//        SanPham product = (SanPham) getIntent().getSerializableExtra("product");
//
//        // Hiển thị thông tin sản phẩm lên các TextView và ImageView
//        if (product != null) {
//            Picasso.get().load(product.getImageUrl()).into(imageViewProduct);
//            textViewProductName.setText(product.getTenSanPham());
//            textViewProductDescription.setText(product.getThongTin());
//            textViewProductPrice.setText(String.format("$%.2f", product.getGiaban()));
//
//            // Lấy danh sách kích thước từ CartRepository
//            CartRepository cartRepository = new CartRepository();
//            List<KichThuoc> danhSachKichThuoc = cartRepository.getListSize();
//
//            // Khởi tạo và đặt adapter cho RecyclerView của kích thước
//            kichThuocAdapter = new SizeAdapterPH(danhSachKichThuoc,this);
//            recyclerViewKichThuoc.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//            recyclerViewKichThuoc.setAdapter(kichThuocAdapter);
//
//            // Lấy danh sách màu sắc từ sản phẩm
//            List<Mau> danhSachMauSac = cartRepository.getListMau();
//
//            // Khởi tạo và đặt adapter cho RecyclerView của màu sắc
//            mauAdapter = new ColorAdapterPH(danhSachMauSac,this);
//            recyclerViewMauSac.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//            recyclerViewMauSac.setAdapter(mauAdapter);
//        }
//    }
//}
package com.example.myapplication.Presentation.Homepage.phuchoi.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Homepage.phuchoi.Apdapter.ColorAdapterPH;
import com.example.myapplication.Presentation.Homepage.phuchoi.Apdapter.SizeAdapterPH;
import com.example.myapplication.Presentation.Homepage.phuchoi.Model.KichThuoc;
import com.example.myapplication.Presentation.Homepage.phuchoi.Model.Mau;
import com.example.myapplication.Presentation.Homepage.phuchoi.Model.SanPham;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamActivity extends AppCompatActivity {

    private ImageView imageViewProduct,backButton;
    private TextView textViewProductName;
    private TextView textViewProductDescription;
    private TextView textViewProductPrice;
    private RecyclerView recyclerViewKichThuoc;
    private RecyclerView recyclerViewMauSac;

    private SizeAdapterPH kichThuocAdapter;
    private ColorAdapterPH mauAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hoi_detail);
        backButton = findViewById(R.id.imageView3);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý khi người dùng nhấn vào nút back (ImageView backButton)
                // Ví dụ: Đóng Activity hiện tại khi nhấn nút back
                finish(); // Đóng Activity và trở về Activity trước đó (nếu có)
            }
        });


        // Ánh xạ các thành phần trong layout
        imageViewProduct = findViewById(R.id.imageslider);
        textViewProductName = findViewById(R.id.tilte);
        textViewProductDescription = findViewById(R.id.thongtinsp);
        textViewProductPrice = findViewById(R.id.price);
        recyclerViewKichThuoc = findViewById(R.id.recylerviewsize);
        recyclerViewMauSac = findViewById(R.id.recylerviewcolor);
        // Lấy thông tin sản phẩm từ Intent
        SanPham product = (SanPham) getIntent().getSerializableExtra("product");

        // Hiển thị thông tin sản phẩm lên các TextView và ImageView
        if (product != null) {
            Picasso.get().load(product.getImageUrl()).into(imageViewProduct);
            textViewProductName.setText(product.getTenSanPham());
            textViewProductDescription.setText(product.getThongTin());
            textViewProductPrice.setText(String.format("$%.2f", product.getGiaban()));

            // Khởi tạo và đặt adapter cho RecyclerView của kích thước
            // Tạo danh sách kích thước và thêm đối tượng vào danh sách
            List<KichThuoc> danhSachKichThuoc = new ArrayList<>();
            danhSachKichThuoc.add(product.getKichThuoc());

            // Khởi tạo adapter cho RecyclerView của kích thước
            kichThuocAdapter = new SizeAdapterPH(danhSachKichThuoc, this);
            recyclerViewKichThuoc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerViewKichThuoc.setAdapter(kichThuocAdapter);

            // Khởi tạo và đặt adapter cho RecyclerView của màu sắc
            List<Mau> danhSachMauSac = new ArrayList<>();
            danhSachMauSac.add(product.getMau());
            mauAdapter = new ColorAdapterPH(danhSachMauSac,this);
            recyclerViewMauSac.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerViewMauSac.setAdapter(mauAdapter);
        }
    }
}
