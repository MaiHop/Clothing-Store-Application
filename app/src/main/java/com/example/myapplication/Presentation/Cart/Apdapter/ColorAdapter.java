package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.ViewHolder.MauVH;
import com.example.myapplication.R;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<MauVH>{
    private List<String> list_color;
    private Context context;
    private LayoutInflater minflater;
     int rowindex=-1;

    public ColorAdapter(Context context, List<String> list_color) {
        this.list_color = list_color;
        this.context = context;
        this.minflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MauVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.item_color, parent, false);

        return new MauVH(itemView);
    }
    @Override
    public int getItemCount() {
        return list_color.size();
    }
    @Override
    public void onBindViewHolder(@NonNull MauVH holder, int position) {
        String color = list_color.get(position);
        holder.updateUI();
        int p = position;
        holder.iv_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowindex = p;
                notifyDataSetChanged();            }
        });
        if(rowindex!=position){
            holder.iv_color.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#EFEFEF")));

        }else{
            holder.iv_color.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#6750A4")));

        }

    }
}
