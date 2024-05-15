package com.example.myapplication.Presentation.GH;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.DonHang;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewItemList;
    private SearchView searchView;
    private DonHangVM viewModel;
    private List<DonHang> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        recyclerViewItemList = findViewById(R.id.rc_DonHang);
        recyclerViewItemList.setLayoutManager(new LinearLayoutManager(this));
        viewModel = new ViewModelProvider(this).get(DonHangVM.class);
        viewModel.getListCartLiveData().observe(MainActivity.this, new Observer<List<DonHang>>() {
            @Override
            public void onChanged(List<DonHang> donHangs) {
                list = donHangs;
                setupTabs();
                ItemAdaptor itemAdaptor = new ItemAdaptor(MainActivity.this, donHangs);
//                recyclerViewItemList.setAdapter(itemAdaptor);
                recyclerViewItem("Active");
            }
        });
//        recyclerViewItem();
//        setupSearchView();
//        setupTabs();
    }

    private void recyclerViewItem(String loai) {

        viewModel.getListCartLiveData().observe(this, new Observer<List<DonHang>>() {
            @Override
            public void onChanged(List<DonHang> donHangs) {
                List<DonHang> listcart = new ArrayList<>();
                for (DonHang dh : donHangs) {
                    switch (loai) {
                        case "Active":
                            if (dh.getTrangThai().equals("Active")) {
                                listcart.add(dh);
                            }
                            break;
                        case "Completed":
                            if (dh.getTrangThai().equals("Completed")) {
                                listcart.add(dh);
                            }
                            break;
                        case "Canceled":
                            if (dh.getTrangThai().equals("Canceled")) {
                                listcart.add(dh);
                            }
                            break;
                    }
                }
                list = donHangs;
                ItemAdaptor itemAdaptor = new ItemAdaptor(MainActivity.this, listcart);
                recyclerViewItemList.setAdapter(itemAdaptor);
            }
        });
    }

    private void setupTabs() {
        int ac =0;
        int co =0;
        int ca =0;
        for(DonHang dh : list){
            if (dh.getTrangThai().equals("Canceled")) {
                ca+=1;
            }else if (dh.getTrangThai().equals("Completed")) {
                co+=1;
            }else if (dh.getTrangThai().equals("Active")) {
                ac+=1;
            }
        }
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        // Xóa các tab cũ và tạo mới từ code
        tabLayout.removeAllTabs();
        TabLayout.Tab activeTab = tabLayout.newTab().setText("Active "+ ac);
        TabLayout.Tab completedTab = tabLayout.newTab().setText("Completed "+co);
        TabLayout.Tab canceledTab = tabLayout.newTab().setText("Canceled "+ ca);

        tabLayout.addTab(activeTab);
        tabLayout.addTab(completedTab);
        tabLayout.addTab(canceledTab);

//        viewModel.getActiveCount().observe(this, newCount -> {
//            activeTab.setText("Active (" + newCount + ")");
//        });
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        showNotification("Active tab selected");
                        recyclerViewItem("Active");
                        break;
                    case 1:
                        showNotification("Completed tab selected");
                        recyclerViewItem("Completed");
                        break;
                    case 2:
                        showNotification("Canceled tab selected");
                        recyclerViewItem("Canceled");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void showNotification(String message) {
        // Hiển thị thông báo ở đây, ví dụ: Toast hoặc AlertDialog
        // Ví dụ Toast:
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
//    private void setupSearchView() {
//        searchView = findViewById(R.id.searchView);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                ((ItemAdaptor) adapter).getFilter().filter(newText);
//                return true;
//            }
//        });
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gh_menu_activity, menu);
        MenuItem searchItem = menu.findItem(R.id.gh_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search submit here
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle text change here
                return true;
            }
        });
        return true;
    }
}