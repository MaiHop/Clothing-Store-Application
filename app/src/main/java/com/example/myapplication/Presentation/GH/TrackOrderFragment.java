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

import com.example.myapplication.Model.DonHang;
import com.example.myapplication.Model.DonHangQuaTrinh;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class TrackOrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private DHQTAdapter adapter;
    private List<DonHangQuaTrinh> orderStatusList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gh_track_order, container, false);

        recyclerView = view.findViewById(R.id.recycler_order_tracking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        orderStatusList = new ArrayList<>();
        adapter = new DHQTAdapter(orderStatusList);
        recyclerView.setAdapter(adapter);

        // Fetch the order from the arguments
        DonHang donHang = (DonHang) getArguments().getSerializable("DONHANG");

        if (donHang != null && donHang.getListdonhangqt() != null) {
            orderStatusList.addAll(donHang.getListdonhangqt());
            adapter.notifyDataSetChanged();
        }

        return view;
    }

    public static TrackOrderFragment newInstance(DonHang donHang) {
        TrackOrderFragment fragment = new TrackOrderFragment();
        Bundle args = new Bundle();
        args.putSerializable("DONHANG", donHang);
        fragment.setArguments(args);
        return fragment;
    }
}
