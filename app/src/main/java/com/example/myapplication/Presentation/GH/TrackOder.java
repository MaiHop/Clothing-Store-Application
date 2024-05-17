package com.example.myapplication.Presentation.GH;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.DonHang;
import com.example.myapplication.Model.DonHangQuaTrinh;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class TrackOder extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DonHangChiTietAdapter orderStatusAdapter;
    private List<DonHangQuaTrinh> orderStatusList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gh_track_order);

        recyclerView = findViewById(R.id.recycler_order_tracking);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        DonHang donHang = (DonHang) intent.getSerializableExtra("DONHANG");

        if (donHang != null) {
            orderStatusList = donHang.getListdonhangqt();
        } else {
            orderStatusList = new ArrayList<>();
        }

        orderStatusAdapter = new DonHangChiTietAdapter(orderStatusList);
        recyclerView.setAdapter(orderStatusAdapter);
    }
}

