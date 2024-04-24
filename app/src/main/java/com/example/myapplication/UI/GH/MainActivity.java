package com.example.myapplication.UI.GH;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter;
private RecyclerView recyclerViewItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewItem();
    }
    private void recyclerViewItem(){
        ArrayList<ItemDomain> item = new ArrayList<>();
        item.add(new ItemDomain("30/11/2102",R.drawable.sp1,"long a shirt","415"));
        item.add(new ItemDomain("30/11/2102",R.drawable.sp1,"long shirt","741"));
        item.add(new ItemDomain("30/11/2102",R.drawable.sp1,"long shirt","741"));
        item.add(new ItemDomain("30/11/2102",R.drawable.sp1,"long shirt","741"));
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewItemList=findViewById(R.id.view1);
        recyclerViewItemList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new ItemAdaptor(MainActivity.this,item);
        recyclerViewItemList.setAdapter(adapter);
    }

}