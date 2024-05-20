package com.example.myapplication.Presentation.GH;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.DonHang;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewItemList;
    private SearchView searchView;
    private DonHangVM viewModel;
    private List<DonHang> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        recyclerViewItemList = view.findViewById(R.id.rc_DonHang);
        recyclerViewItemList.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel = new ViewModelProvider(this).get(DonHangVM.class);
        viewModel.getListCartLiveData().observe(getViewLifecycleOwner(), new Observer<List<DonHang>>() {
            @Override
            public void onChanged(List<DonHang> donHangs) {
                list = donHangs;
//                setupTabs(view);
//                recyclerViewItem("Active");
            }
        });

        setHasOptionsMenu(true);

        return view;
    }

//    private void recyclerViewItem(String loai) {
//        viewModel.getListCartLiveData().observe(getViewLifecycleOwner(), new Observer<List<DonHang>>() {
//            @Override
//            public void onChanged(List<DonHang> donHangs) {
//                List<DonHang> listcart = new ArrayList<>();
//                for (DonHang dh : donHangs) {
//                    switch (loai) {
//                        case "Active":
//                            if (dh.getTrangThai().equals("Active")) {
//                                listcart.add(dh);
//                            }
//                            break;
//                        case "Completed":
//                            if (dh.getTrangThai().equals("Completed")) {
//                                listcart.add(dh);
//                            }
//                            break;
//                        case "Canceled":
//                            if (dh.getTrangThai().equals("Canceled")) {
//                                listcart.add(dh);
//                            }
//                            break;
//                    }
//                }
//                list = donHangs;
//                ItemAdaptor itemAdaptor = new ItemAdaptor(getContext(), listcart);
//                recyclerViewItemList.setAdapter(itemAdaptor);
//            }
//        });
//    }

//    private void setupTabs(View view) {
//        int ac = 0;
//        int co = 0;
//        int ca = 0;
//            for (DonHang dh : list) {
//            if (dh.getTrangThai().equals("Canceled")) {
//                ca += 1;
//            } else if (dh.getTrangThai().equals("Completed")) {
//                co += 1;
//            } else if (dh.getTrangThai().equals("Active")) {
//                ac += 1;
//            }
//        }
//        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
//        tabLayout.removeAllTabs();
//        TabLayout.Tab activeTab = tabLayout.newTab().setText("Active " + ac);
//        TabLayout.Tab completedTab = tabLayout.newTab().setText("Completed " + co);
//        TabLayout.Tab canceledTab = tabLayout.newTab().setText("Canceled " + ca);
//
//        tabLayout.addTab(activeTab);
//        tabLayout.addTab(completedTab);
//        tabLayout.addTab(canceledTab);
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                int position = tab.getPosition();
//                switch (position) {
//                    case 0:
//                        showNotification("Active tab selected");
//                        recyclerViewItem("Active");
//                        break;
//                    case 1:
//                        showNotification("Completed tab selected");
//                        recyclerViewItem("Completed");
//                        break;
//                    case 2:
//                        showNotification("Canceled tab selected");
//                        recyclerViewItem("Canceled");
//                        break;
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });
//    }

    private void showNotification(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.gh_menu_activity, menu);
        MenuItem searchItem = menu.findItem(R.id.gh_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}
