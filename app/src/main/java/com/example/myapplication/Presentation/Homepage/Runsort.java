package com.example.myapplication.Presentation.Homepage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Runsort extends AppCompatActivity {
    private RecyclerView.Adapter adapterSort;
    private RecyclerView recyclervewSort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sort2);
        initRecyclerView();

    }

    private void initRecyclerView() {
        ArrayList<Sort> items = new ArrayList<>();
        items.add(new Sort("Thấp đến cao",true));
        items.add(new Sort("Cao đến thấp",false));
        items.add(new Sort("Phổ biến",false));

        recyclervewSort = findViewById(R.id.recylerviewsort);
        recyclervewSort.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapterSort = new SortListAdapter(items);
        recyclervewSort.setAdapter(adapterSort);
    }
}
