package com.example.myapplication.Presentation.GH;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
    private ItemAdaptor itemAdaptor;
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
        itemAdaptor = new ItemAdaptor(this, new ArrayList<>());
        recyclerViewItemList.setAdapter(itemAdaptor);

        viewModel = new ViewModelProvider(this).get(DonHangVM.class);
        viewModel.getListCartLiveData().observe(this, new Observer<List<DonHang>>() {
            @Override
            public void onChanged(List<DonHang> donHangs) {
                list = donHangs;
                setupTabs();
                filterList("Active");
            }
        });
    }

    private void filterList(String status) {
        List<DonHang> filteredList = new ArrayList<>();
        for (DonHang dh : list) {
            if (dh.getTrangThai().equals(status)) {
                filteredList.add(dh);
            }
        }
        itemAdaptor.updateList(filteredList);
    }

    private void setupTabs() {
        int ac = 0;
        int co = 0;
        int ca = 0;
        for (DonHang dh : list) {
            if (dh.getTrangThai().equals("Canceled")) {
                ca++;
            } else if (dh.getTrangThai().equals("Completed")) {
                co++;
            } else if (dh.getTrangThai().equals("Active")) {
                ac++;
            }
        }

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.removeAllTabs();
        TabLayout.Tab activeTab = tabLayout.newTab().setText("Active " + ac);
        TabLayout.Tab completedTab = tabLayout.newTab().setText("Completed " + co);
        TabLayout.Tab canceledTab = tabLayout.newTab().setText("Canceled " + ca);

        tabLayout.addTab(activeTab);
        tabLayout.addTab(completedTab);
        tabLayout.addTab(canceledTab);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        showNotification("Active tab selected");
                        filterList("Active");
                        break;
                    case 1:
                        showNotification("Completed tab selected");
                        filterList("Completed");
                        break;
                    case 2:
                        showNotification("Canceled tab selected");
                        filterList("Canceled");
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gh_menu_activity, menu);
        MenuItem searchItem = menu.findItem(R.id.gh_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                itemAdaptor.getFilter().filter(newText);
                return true;
            }
        });
        return true;
    }

    private void showNotification(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
