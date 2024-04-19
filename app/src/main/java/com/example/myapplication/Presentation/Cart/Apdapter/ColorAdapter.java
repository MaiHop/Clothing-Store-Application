package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    private SanPham sanPham;

    public ColorAdapter(Context context, List<Mau> list_color, KichThuocVM kichThuocVM, SanPham sanPham) {
        this.list_color = list_color;
        this.context = context;
        this.kichThuocVM = kichThuocVM;
        this.sanPham = sanPham;
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
        Mau color = list_color.get(position);
        holder.updateUI(color);
        int p = position;
        holder.iv_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =0; i<list_color.size();i++){
                    Mau cl = list_color.get(i);
                    Mau cl_check = list_color.get(holder.getAdapterPosition());
                    if(cl.getId().equals(cl_check.getId())){
                        cl.setChecked(true);
                        list_color.set(i,cl);
                    }else {
                        cl.setChecked(false);
                        list_color.set(i,cl);
                    }
                }
                Mau m = list_color.get(holder.getAdapterPosition());
                kichThuocVM.showListSize(m.getId(), sanPham);
                notifyDataSetChanged();
            }

        });
        if(!color.isAble()){
            holder.tv_line_item_color.setVisibility(View.VISIBLE);
            holder.iv_color.setClickable(false);

        }else{
            holder.iv_color.setClickable(true);
            holder.tv_line_item_color.setVisibility(View.GONE);
        }
        if(!color.isChecked()){
            holder.iv_color.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#EFEFEF")));

        }else{
            holder.iv_color.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#6750A4")));

        }


    }
}
