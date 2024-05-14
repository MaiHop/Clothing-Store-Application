package com.example.myapplication.Presentation.GH;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewItemList;

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_order_customer, container, false);
//        recyclerViewItem(view);
//        return view;
//    }

//    private void recyclerViewItem(View view) {
//        ArrayList<ItemDomain> item = new ArrayList<>();
//        item.add(new ItemDomain("30/11/2102", R.drawable.sp1, "long a shirt", "415"));
//        item.add(new ItemDomain("30/11/2102", R.drawable.sp1, "long shirt", "741"));
//        item.add(new ItemDomain("30/11/2102", R.drawable.sp1, "long shirt", "741"));
//        item.add(new ItemDomain("30/11/2102", R.drawable.sp1, "long shirt", "741"));
//
//        recyclerViewItemList = view.findViewById(R.id.view1);
//        recyclerViewItemList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//        adapter = new ItemAdaptor(getContext(), item);
//        recyclerViewItemList.setAdapter(adapter);
//    }
}
