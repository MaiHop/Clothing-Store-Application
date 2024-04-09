package com.example.myapplication.Presentation.Homepage;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Homepage.Adapter.BoclocAdapter;
import com.example.myapplication.Presentation.Homepage.Adapter.ColorAdapter;
import com.example.myapplication.Presentation.Homepage.Adapter.PriceAdapter;
import com.example.myapplication.Presentation.Homepage.Adapter.ProductListAdapter;
import com.example.myapplication.Presentation.Homepage.Adapter.SizeAdapter;
import com.example.myapplication.Presentation.Homepage.Adapter.SortListAdapter;
import com.example.myapplication.Presentation.Homepage.DTO.Boloc;
import com.example.myapplication.Presentation.Homepage.DTO.MyColor;
import com.example.myapplication.Presentation.Homepage.DTO.Price;
import com.example.myapplication.Presentation.Homepage.DTO.Products;
import com.example.myapplication.Presentation.Homepage.DTO.Sort;
import com.example.myapplication.Presentation.Homepage.DTO.Size;
import com.example.myapplication.R;

import java.util.ArrayList;

public class category_women extends AppCompatActivity {
    private RecyclerView.Adapter adapterProdutc;
    private RecyclerView recyclerviewWomen;
    private ImageView imageViewBack; // Đã chuyển khai báo ImageView vào trong onCreate
    public Button btnSort, btnFilter;
    private RecyclerView adapterSort, adapterBoloc,adapterSize,adapterPrice,adapterColor;
    private RecyclerView recyclervewSort, recyclerViewBoloc,recyclerViewSize,recyclerViewPrice,recyclerViewColor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.women_layout);

        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(category_women.this, Homepage.class);
                startActivity(intent);
                finish();
            }
        });
        btnSort = findViewById(R.id.btnSort);
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gọi hàm showdialog() khi btnSort được nhấn
                showdialog(category_women.this,1);
            }
        });
        btnFilter = findViewById(R.id.btnFilter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gọi hàm showdialog() khi btnSort được nhấn
                showdialog(category_women.this,2);
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<Products> items = new ArrayList<>();
        items.add(new Products("Áo PoLo", R.drawable.polo, "123", "5"));
        items.add(new Products("Áo PoLo", R.drawable.polo, "100", "5"));
        items.add(new Products("Áo PoLo", R.drawable.polo, "120", "5"));
        items.add(new Products("Áo PoLo", R.drawable.polo, "123", "5"));
        items.add(new Products("Áo PoLo", R.drawable.polo, "100", "5"));
        items.add(new Products("Áo PoLo", R.drawable.polo, "120", "5"));
        items.add(new Products("Áo PoLo", R.drawable.polo, "123", "5"));
        items.add(new Products("Áo PoLo", R.drawable.polo, "100", "5"));
        items.add(new Products("Áo PoLo", R.drawable.polo, "120", "5"));
        recyclerviewWomen = findViewById(R.id.viewwomen);
        recyclerviewWomen.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterProdutc = new ProductListAdapter(items);
        recyclerviewWomen.setAdapter(adapterProdutc);

        // Sử dụng GridLayoutManager để hiển thị RecyclerView theo lưới
        recyclerviewWomen.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerviewWomen.setHasFixedSize(true);


    }

    public void showdialog(Context context, int dialogType) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(dialogType == 1 ? R.layout.sort2 : R.layout.filter_dialog);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        // Xử lý các thành phần trong dialog tương ứng với dialogType
        if (dialogType == 1) {
            // Thiết lập dữ liệu cho dialog sort
            RecyclerView recyclerViewSort = dialog.findViewById(R.id.recylerviewsort);
            ArrayList<Sort> itemsSort = new ArrayList<>();
            itemsSort.add(new Sort("Thấp đến cao", true));
            itemsSort.add(new Sort("Cao đến thấp", false));
            itemsSort.add(new Sort("Phổ biến", false));
            SortListAdapter adapterSort = new SortListAdapter(itemsSort);
            recyclerViewSort.setLayoutManager(new LinearLayoutManager(context));
            recyclerViewSort.setAdapter(adapterSort);

            // Xử lý các sự kiện trong dialog sort
            ImageView imageCloseDialog = dialog.findViewById(R.id.imageViewBackSort);
            if (imageCloseDialog != null) {
                imageCloseDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        } else if (dialogType == 2) {
            // Thiết lập dữ liệu cho dialog filter
            RecyclerView recyclerViewFilter = dialog.findViewById(R.id.recylerviewcategories);
            ArrayList<Boloc> itemsBoloc = new ArrayList<>();
            itemsBoloc.add(new Boloc("Women"));
            itemsBoloc.add(new Boloc("Men"));
            itemsBoloc.add(new Boloc("Child"));
            itemsBoloc.add(new Boloc("Polo"));
            itemsBoloc.add(new Boloc("Short"));
            itemsBoloc.add(new Boloc("Long"));
            BoclocAdapter adapterBoloc = new BoclocAdapter(itemsBoloc);
            recyclerViewFilter.setLayoutManager(new LinearLayoutManager(context));
            int spanCount = 4; // Số cột mỗi hàng
            recyclerViewFilter.setLayoutManager(new GridLayoutManager(context, spanCount));
            recyclerViewFilter.setAdapter(adapterBoloc);

                //price

            RecyclerView recyclerViewPrice = dialog.findViewById(R.id.recylerviewprice);
            ArrayList<Price> itemsPrice = new ArrayList<>();
            itemsPrice.add(new Price("$1 - $50"));
            itemsPrice.add(new Price("$51 - $100"));
            itemsPrice.add(new Price("$101 - $150"));
            itemsPrice.add(new Price("$151 - $200"));

            PriceAdapter adapterprice = new PriceAdapter(itemsPrice);
            recyclerViewPrice.setLayoutManager(new LinearLayoutManager(context));
            recyclerViewPrice.setLayoutManager(new GridLayoutManager(context, spanCount));
            recyclerViewPrice.setAdapter(adapterprice);

            //Size

            RecyclerView recyclerViewSize = dialog.findViewById(R.id.recylerviewsize);
            ArrayList<Size> itemsSize = new ArrayList<>();
            itemsSize.add(new Size("XS"));
            itemsSize.add(new Size("S"));
            itemsSize.add(new Size("M"));
            itemsSize.add(new Size("L"));
            itemsSize.add(new Size("XL"));

            SizeAdapter adaptersize = new SizeAdapter(itemsSize);
            recyclerViewSize.setLayoutManager(new LinearLayoutManager(context));
            recyclerViewSize.setLayoutManager(new GridLayoutManager(context, spanCount));
            recyclerViewSize.setAdapter(adaptersize);

            //Color

            RecyclerView recyclerViewColor = dialog.findViewById(R.id.recylerviewcolor);
            ArrayList<MyColor> itemsColor = new ArrayList<>();
            itemsColor.add(new MyColor("#FF0000"));
            itemsColor.add(new MyColor("#00FF00"));
            itemsColor.add(new MyColor("#0000FF"));
            itemsColor.add(new MyColor("#000000"));
            itemsColor.add(new MyColor("#FFFF00"));



            ColorAdapter adaptercolor = new ColorAdapter(itemsColor);
            recyclerViewColor.setLayoutManager(new LinearLayoutManager(context));
            recyclerViewColor.setLayoutManager(new GridLayoutManager(context, spanCount));
            recyclerViewColor.setAdapter(adaptercolor);

            // Xử lý các sự kiện trong dialog filter
            ImageView imageCloseDialog = dialog.findViewById(R.id.imageViewBackFilter);
            if (imageCloseDialog != null) {
                imageCloseDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        }
    }
}




