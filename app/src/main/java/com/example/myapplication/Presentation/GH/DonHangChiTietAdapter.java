package com.example.myapplication.Presentation.GH;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.Model.DonHangQuaTrinh;
import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class DonHangChiTietAdapter extends RecyclerView.Adapter<DonHangChiTietVH> {

    private List<DonHangQuaTrinh> orderStatusList;

    public DonHangChiTietAdapter(List<DonHangQuaTrinh> orderStatusList) {
        this.orderStatusList = orderStatusList;
    }

    @NonNull
    @Override
    public DonHangChiTietVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoi_item_order, parent, false);
        return new DonHangChiTietVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonHangChiTietVH holder, int position) {
        DonHangQuaTrinh orderStatus = orderStatusList.get(position);
        holder.bind(orderStatus, position == 0);
    }

    @Override
    public int getItemCount() {
        return orderStatusList.size();
    }
}