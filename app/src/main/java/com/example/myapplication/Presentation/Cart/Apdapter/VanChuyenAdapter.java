package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.VanChuyen;
import com.example.myapplication.Presentation.Cart.ViewHolder.VanChuyenVH;
import com.example.myapplication.R;

import java.util.List;

public class VanChuyenAdapter extends RecyclerView.Adapter<VanChuyenVH>{
    private Context context;
    private List<VanChuyen> list;
    private LayoutInflater minflater;
    private ItemClickListener itemClickListener;
    private int rowindex=-1;

    public VanChuyenAdapter(Context context, List<VanChuyen> list, ItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.minflater = LayoutInflater.from(context);
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public VanChuyenVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.mh_item_delivery, parent, false);

        return new VanChuyenVH(itemView);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface ItemClickListener{
        void onItemClick(VanChuyen vanChuyen);
    }
    @Override
    public void onBindViewHolder(@NonNull VanChuyenVH holder, int position) {
        VanChuyen vc = list.get(position);
        holder.updateUI(vc);
        int p = position;
        holder.item_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowindex = p;
                notifyDataSetChanged();
                itemClickListener.onItemClick(list.get(position));
            }
        });
        if(rowindex!=position){
            vc.setChecked(false);
            holder.updateUI(vc);
        }else{
            vc.setChecked(true);
            holder.updateUI(vc);

        }
    }
}
