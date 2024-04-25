package com.example.myapplication.Presentation.Wishlist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Wishlist.Model.BoLoc_WishList;
import com.example.myapplication.R;

import java.util.List;

public class Adapter_Item_BoLoc_WishList extends RecyclerView.Adapter<Adapter_Item_BoLoc_WishList.BoLocWishListViewHolder> {

    private Context context;
    private int layout;
    private List<BoLoc_WishList> arr_item_boloc_wishlist;

    public Adapter_Item_BoLoc_WishList(Context context, int layout, List<BoLoc_WishList> arr_item_boloc_wishlist) {
        this.context = context;
        this.layout = layout;
        this.arr_item_boloc_wishlist = arr_item_boloc_wishlist;
    }

    @NonNull
    @Override
    public BoLocWishListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new BoLocWishListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BoLocWishListViewHolder holder, int position) {
        BoLoc_WishList boLocWishList = arr_item_boloc_wishlist.get(position);
        holder.ten.setText(boLocWishList.getTen_loai());
    }

    @Override
    public int getItemCount() {
        return arr_item_boloc_wishlist.size();
    }

    public class BoLocWishListViewHolder extends RecyclerView.ViewHolder {
        public TextView ten;
        public BoLocWishListViewHolder(View itemView) {
            super(itemView);
            ten = itemView.findViewById(R.id.tenBoLoc);
        }
    }
}
