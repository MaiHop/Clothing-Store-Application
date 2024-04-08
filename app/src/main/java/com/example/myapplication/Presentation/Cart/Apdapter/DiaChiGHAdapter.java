package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Model.DiaChiGH;
import com.example.myapplication.Presentation.Cart.ViewHolder.DiaChiGHVH;
import com.example.myapplication.R;

import java.util.List;

public class DiaChiGHAdapter extends RecyclerView.Adapter<DiaChiGHVH>{
    private Context context;
    private List<DiaChiGH> list;
    private LayoutInflater minflater;
    private int rowindex=-1;

    public DiaChiGHAdapter(Context context, List<DiaChiGH> list) {
        this.context = context;
        this.list = list;
        this.minflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DiaChiGHVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.item_deliver_adress, parent, false);

        return new DiaChiGHVH(itemView);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull DiaChiGHVH holder, int position) {
        DiaChiGH dc = list.get(position);
        holder.updateUI(dc);
        int p = position;
        holder.ll_item_DeliveryAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowindex = p;
                notifyDataSetChanged();

            }
        });
        if(rowindex!=position){
            dc.setChecked(false);
            holder.updateUI(dc);
        }else{
            dc.setChecked(true);
            holder.updateUI(dc);

        }
    }
}
