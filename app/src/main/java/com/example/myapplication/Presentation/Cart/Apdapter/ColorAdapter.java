package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Model.DiaChi;
import com.example.myapplication.Presentation.Cart.Model.KichThuoc;
import com.example.myapplication.Presentation.Cart.Model.Mau;
import com.example.myapplication.Presentation.Cart.Model.SanPham;
import com.example.myapplication.Presentation.Cart.ViewHolder.MauVH;
import com.example.myapplication.Presentation.Cart.ViewModel.KichThuocVM;
import com.example.myapplication.R;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<MauVH>{
    private List<Mau> list_color;
    private Context context;
    private LayoutInflater minflater;
    private int rowindex=-1;
    private KichThuocVM kichThuocVM;
    private ItemClickListener itemClickListener;

    public ColorAdapter(Context context, List<Mau> list_color, KichThuocVM kichThuocVM, ItemClickListener itemClickListener) {
        this.list_color = list_color;
        this.context = context;
        this.kichThuocVM = kichThuocVM;
        this.itemClickListener = itemClickListener;
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
    public interface ItemClickListener{
        void onItemClick(Mau mau);
    }
    @Override
    public void onBindViewHolder(@NonNull MauVH holder, int position) {
        Mau color = list_color.get(position);
        holder.updateUI(color);
        holder.iv_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Mau m : list_color){
                    if(m.isAble()){
                        m.setChecked(false);
                    }
                }
                notifyDataSetChanged();
                itemClickListener.onItemClick(color);
                holder.updateUI(color);
            }
        });




    }
}
