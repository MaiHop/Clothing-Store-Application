package com.example.myapplication.Presentation.PhucHoi.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.Model.Mau;
import com.example.myapplication.Presentation.PhucHoi.ViewHolder.MauVH;
import com.example.myapplication.R;

import java.util.List;

public class ColorAdapterPH extends RecyclerView.Adapter<MauVH>  {

    private List<Mau> mauList;
    private Context context;

    public ColorAdapterPH(List<Mau> mauList, Context context) {
        this.mauList = mauList;
        this.context = context;
    }

    @NonNull
    @Override
    public MauVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoi_item_color, parent, false);
        return new MauVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MauVH holder, int position) {
        Mau mau = mauList.get(position);
        holder.updateUI(mau);
    }



    @Override
    public int getItemCount() {
        return mauList.size();
    }
    public void setListMau(List<Mau>colorList) {
        this.mauList = colorList;
        notifyDataSetChanged(); // Thông báo cho RecyclerView biết là danh sách đã thay đổi
    }
}

