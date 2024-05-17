package com.example.myapplication.Presentation.GH;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.DonHangQuaTrinh;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Date;
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

        // Initialize the order status list and add sample data
        orderStatusList = new ArrayList<>();
        orderStatusList.add(new DonHangQuaTrinh("Order is being Delivered", "4 Evergreen Street Lake Zurich, IL 60047", new Date()));
        orderStatusList.add(new DonHangQuaTrinh("Order is being Delivered", "9177 Hillcrest Street Wheeling, WV 26003", new Date()));
        orderStatusList.add(new DonHangQuaTrinh("Orders are in Transit", "891 Glen Ridge St. Gainesville, VA 20155", new Date()));
        orderStatusList.add(new DonHangQuaTrinh("Order is being Delivered", "55 Summerhouse Dr. Apopka, FL 32703", new Date()));
        orderStatusList.add(new DonHangQuaTrinh("Store Processing Orders", "Orders are being processed by the Store", new Date()));
        orderStatusList.add(new DonHangQuaTrinh("Payments Verified", "Your payment has been confirmed", new Date()));

        orderStatusAdapter = new DonHangChiTietAdapter(orderStatusList);
        recyclerView.setAdapter(orderStatusAdapter);
    }
}

