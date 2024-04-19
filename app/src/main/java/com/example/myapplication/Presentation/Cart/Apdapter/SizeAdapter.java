package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Model.KichThuoc;
import com.example.myapplication.Presentation.Cart.Model.Mau;
import com.example.myapplication.Presentation.Cart.ViewHolder.SizeVH;
import com.example.myapplication.R;

import java.util.List;

public class SizeAdapter extends RecyclerView.Adapter<SizeVH> {
    private List<KichThuoc> list_size;
    private Context context;
    private LayoutInflater minflater;
    private int rowindex=-1;
    public SizeAdapter( Context context,List<KichThuoc> list_size) {
        this.list_size = list_size;
        this.context = context;
        this.minflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SizeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.item_size, parent, false);

        return new SizeVH(itemView);
    }

    @Override
    public int getItemCount() {
        return list_size.size();
    }
    @Override
    public void onBindViewHolder(@NonNull SizeVH holder, int position) {
        KichThuoc size = list_size.get(position);
        holder.updateUI(size);
        int p = position;
        holder.tv_Size_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =0; i<list_size.size();i++){
                    KichThuoc kt = list_size.get(i);
                    KichThuoc kt_check = list_size.get(holder.getAdapterPosition());
                    if(kt.getId().equals(kt_check.getId())){
                        kt.setChecked(true);
                    }else {
                        kt.setChecked(false);
                    }
                }
                notifyDataSetChanged();            }
        });
        if(!size.isAble()){
            holder.tv_Size_cart.setClickable(false);
            holder.tv_line_item_size.setVisibility(View.VISIBLE);
            holder.tv_Size_cart.setTextColor((Color.parseColor("#EDEBEB")));

        }else{
            holder.tv_Size_cart.setClickable(true);
            holder.tv_line_item_size.setVisibility(View.GONE);
            if(!size.isChecked()){
                holder.tv_Size_cart.setBackgroundResource(R.drawable.item_size_defaut);
                holder.tv_Size_cart.setTextColor(ContextCompat.getColor(context, android.R.color.black));

            }else{
                holder.tv_Size_cart.setBackgroundResource(R.drawable.item_size_selected);
                holder.tv_Size_cart.setTextColor(ContextCompat.getColor(context, android.R.color.white));

            }
        }

    }
}
