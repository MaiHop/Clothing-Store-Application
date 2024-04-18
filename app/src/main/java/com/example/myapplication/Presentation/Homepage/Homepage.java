package com.example.myapplication.Presentation.Homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Homepage.Adapter.ProductListAdapter;
import com.example.myapplication.Presentation.Homepage.DTO.Products;
import com.example.myapplication.R;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {
    private RecyclerView.Adapter adapterProdutc;
    private RecyclerView recyclerviewNewArrival;
    private RecyclerView recyclerViewdeals;
    private EditText search;
    private  ImageView imageViewBackSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        // chuyển trang search
        search = findViewById(R.id.search);
        search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    setContentView(R.layout.search_layout); // Chuyển sang layout tìm kiếm
                    setupBackButton();
                }
            }

            private void setupBackButton() {
                ImageView imageViewBackSearch = findViewById(R.id.imageViewBackSearch);
                imageViewBackSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish(); // Kết thúc hoạt động hiện tại và quay lại hoạt động trước đó

                    }
                });
            }
        });
        //chuyển trang home -> category
        View.OnClickListener goToPageClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Homepage.this, category_women.class);
                startActivity(intent);
            }
        };

        // Gán goToPageClickListener cho các ConstraintLayout cần xử lý sự kiện
        ConstraintLayout constraintLayout1 = findViewById(R.id.constraintLayout1);
        ConstraintLayout constraintLayout2 = findViewById(R.id.constraintLayout2);
        ConstraintLayout constraintLayout3 = findViewById(R.id.constraintLayout3);
        ConstraintLayout constraintLayout4 = findViewById(R.id.constraintLayout4);
        ConstraintLayout constraintLayout5 = findViewById(R.id.constraintLayout5);

        constraintLayout1.setOnClickListener(goToPageClickListener);
        constraintLayout2.setOnClickListener(goToPageClickListener);
        constraintLayout3.setOnClickListener(goToPageClickListener);
        constraintLayout4.setOnClickListener(goToPageClickListener);
        constraintLayout5.setOnClickListener(goToPageClickListener);


        initRecyclerView();
    }



    private void initRecyclerView(){
            ArrayList<Products> items = new ArrayList<>();
            items.add(new Products("Áo PoLo",R.drawable.polo,"123","5",""));
            items.add(new Products("Áo PoLo",R.drawable.polo,"100","5",""));
            items.add(new Products("Áo PoLo",R.drawable.polo,"120","5",""));
            recyclerviewNewArrival = findViewById(R.id.view1);
            recyclerviewNewArrival.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
            adapterProdutc = new ProductListAdapter(items);
            recyclerviewNewArrival.setAdapter(adapterProdutc);
            //hot deals this week
            items.add(new Products("Áo PoLo",R.drawable.polo,"123","5",""));
            items.add(new Products("Áo PoLo",R.drawable.polo,"100","5",""));
            items.add(new Products("Áo PoLo",R.drawable.polo,"120","5",""));
            recyclerViewdeals = findViewById(R.id.view2);
            recyclerViewdeals.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
            adapterProdutc = new ProductListAdapter(items);
            recyclerViewdeals.setAdapter(adapterProdutc);
        }
}
