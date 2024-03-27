package com.example.myapplication.Presentation.Homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class category_women extends AppCompatActivity {
    private RecyclerView.Adapter adapterProdutc;
    private RecyclerView recyclerviewWomen;
    private ImageView imageViewBack; // Đã chuyển khai báo ImageView vào trong onCreate
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
}
