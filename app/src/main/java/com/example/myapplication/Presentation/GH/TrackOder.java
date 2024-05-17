package com.example.myapplication.Presentation.GH;

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
    private DHQTAdapter adapter;
    private List<DonHangQuaTrinh> orderStatusList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gh_track_order);

        recyclerView = findViewById(R.id.recycler_order_tracking);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        orderStatusList = new ArrayList<>();
        adapter = new DHQTAdapter(orderStatusList);
        recyclerView.setAdapter(adapter);

        // Fetch the order from the intent
        DonHang donHang = (DonHang) getIntent().getSerializableExtra("DONHANG");

        if (donHang != null && donHang.getListdonhangqt() != null) {
            orderStatusList.addAll(donHang.getListdonhangqt());
            adapter.notifyDataSetChanged();
        }
    }
}
