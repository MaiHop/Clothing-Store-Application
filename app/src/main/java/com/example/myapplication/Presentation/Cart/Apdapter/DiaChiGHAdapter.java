package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.DiaChi;
import com.example.myapplication.Presentation.Cart.ViewHolder.DiaChiGHVH;
import com.example.myapplication.R;

import java.util.List;

public class DiaChiGHAdapter extends RecyclerView.Adapter<DiaChiGHVH>{
    private Context context;
    private List<DiaChi> list;
    private LayoutInflater minflater;
    private ItemClickListener itemClickListener;
    private int rowindex=-1;

    public DiaChiGHAdapter(Context context, List<DiaChi> list, ItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.minflater = LayoutInflater.from(context);
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public DiaChiGHVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.mh_item_deliver_adress, parent, false);

        return new DiaChiGHVH(itemView);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface ItemClickListener{
        void onItemClick(DiaChi diaChi);
    }
    @Override
    public void onBindViewHolder(@NonNull DiaChiGHVH holder, int position) {
        DiaChi dc = list.get(position);
        holder.updateUI(dc);
        int p = position;
        holder.ll_item_DeliveryAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowindex = p;
                notifyDataSetChanged();
                itemClickListener.onItemClick(list.get(position));
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
