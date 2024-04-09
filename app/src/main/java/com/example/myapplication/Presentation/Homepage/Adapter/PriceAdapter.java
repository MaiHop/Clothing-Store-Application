package com.example.myapplication.Presentation.Homepage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Homepage.DTO.Price;

import com.example.myapplication.R;

import java.util.ArrayList;

public class    PriceAdapter extends RecyclerView.Adapter<PriceAdapter.ViewHolder>{
    private ArrayList<Price> itemsPrice;
    public PriceAdapter (ArrayList<Price> items){
        this.itemsPrice = items;
    }
    @NonNull
    @Override
    public PriceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_gia, parent, false);
        return new PriceAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PriceAdapter.ViewHolder holder, int position) {
        Price price = itemsPrice.get(position);
        holder.titleprice.setText(price.getGia());
    }

    @Override
    public int getItemCount() {
        return itemsPrice.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleprice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleprice = itemView.findViewById(R.id.gia);

        }
    }
}
