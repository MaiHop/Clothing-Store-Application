package com.example.myapplication.Presentation.Wishlist;

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

import com.example.myapplication.R;

import java.text.DecimalFormat;
import java.util.List;

public class Adapter_Item_SP_WishList extends RecyclerView.Adapter<Adapter_Item_SP_WishList.SPItemViewHolder> {

    private Context context;
    private int layout;
    private List<SanPham_WishList> arr_item_SP_WL;

    public Adapter_Item_SP_WishList(Context context, int layout, List<SanPham_WishList> arr_item_SP_WL) {
        this.context = context;
        this.layout = layout;
        this.arr_item_SP_WL = arr_item_SP_WL;
    }

    @NonNull
    @Override
    public SPItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new SPItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Item_SP_WishList.SPItemViewHolder holder, int position) {
        SanPham_WishList sanPhamWishList =  arr_item_SP_WL.get(position);
        holder.tenSP.setText(sanPhamWishList.getTenSP());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.giaSP.setText(decimalFormat.format(Double.parseDouble(sanPhamWishList.getGia()))+" VND");
        holder.hinhSP.setImageResource(sanPhamWishList.getHinh());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.checkBox.isChecked()){
                    Toast.makeText(v.getContext(), "Add from Wishlist", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(v.getContext(), "Removed from Wishlist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr_item_SP_WL.size();
    }

    public class SPItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tenSP;
        public TextView giaSP;
        public ImageView hinhSP;
        CheckBox checkBox;
        public SPItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tenSP = itemView.findViewById(R.id.item_tenSP);
            giaSP = itemView.findViewById(R.id.item_giaSP);
            hinhSP = itemView.findViewById(R.id.item_imageSP);
            checkBox = itemView.findViewById(R.id.cbHeart);
        }
    }
}
