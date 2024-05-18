package com.example.myapplication.Presentation.GH;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Model.DonHang;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentTab extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);

        Toolbar toolbar = findViewById(R.id.toolbar_checkout_cart);
        setSupportActionBar(toolbar);

        // Set up the back button
        ImageView btnBack = findViewById(R.id.ODback);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TabLayout tabLayout = findViewById(R.id.od_tabLayout);
        DonHang donHang = (DonHang) getIntent().getSerializableExtra("DONHANG");

        // Load the default fragment
        loadFragment(OrderDetailsFragment.newInstance(donHang));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment;
                if (tab.getText().equals("Track Order")) {
                    fragment = TrackOrderFragment.newInstance(donHang);
                } else {
                    fragment = OrderDetailsFragment.newInstance(donHang);
                }
                loadFragment(fragment);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        // Nếu muốn thực hiện hành động đặc biệt khi nút back được ấn, bạn có thể thêm mã ở đây.
        super.onBackPressed();
    }
}
