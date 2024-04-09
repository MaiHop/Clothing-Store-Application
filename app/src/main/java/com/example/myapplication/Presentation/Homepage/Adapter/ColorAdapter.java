package com.example.myapplication.Presentation.Homepage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.Presentation.Homepage.DTO.MyColor;
import com.example.myapplication.Presentation.Homepage.DTO.Price;
import com.example.myapplication.Presentation.Homepage.DTO.Size;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder>{
    private ArrayList<MyColor> itemsColor;
    public ColorAdapter (ArrayList<MyColor> items){
        this.itemsColor = items;
    }

    @NonNull
    @Override
    public ColorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_color, parent, false);

        return new ColorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorAdapter.ViewHolder holder, int position) {
        MyColor color = itemsColor.get(position);
        holder.titlecolor.setBackgroundColor(android.graphics.Color.parseColor(color.getMycolor()));
    }

    @Override
    public int getItemCount() {
        return itemsColor.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView titlecolor;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titlecolor = itemView.findViewById(R.id.iv_Color_cart);

        }
    }
}
