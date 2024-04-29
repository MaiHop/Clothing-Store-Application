package com.example.myapplication.Presentation.Wishlist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Domain.Model.SanPham;
import com.example.myapplication.Domain.Model.YeuThich;
import com.example.myapplication.Presentation.Wishlist.ViewHolder.WishListVH;
import com.example.myapplication.R;

import java.text.DecimalFormat;
import java.util.List;

public class Adapter_Item_SP_WishList extends RecyclerView.Adapter<WishListVH> {

    private Context context;
    private int layout;
    private LayoutInflater minflater;
    private List<SanPham> arr_item_SP_WL;


    public Adapter_Item_SP_WishList(List<SanPham> arr_item_SP_WL, Context context, int layout) {
        this.context = context;
        this.layout = layout;
        this.arr_item_SP_WL = arr_item_SP_WL;
        this.minflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WishListVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new WishListVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WishListVH holder, int position) {
        SanPham sanPhamWishList =  arr_item_SP_WL.get(position);
        holder.updateUI(sanPhamWishList);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr_item_SP_WL.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(),arr_item_SP_WL.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr_item_SP_WL.size();
    }


    public void setListProductWish(List<SanPham> productList) {
        this.arr_item_SP_WL = productList;
        notifyDataSetChanged(); // Thông báo cho RecyclerView biết là danh sách đã thay đổi
    }
}
