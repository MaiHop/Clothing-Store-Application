package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Model.KhuyenMai;
import com.example.myapplication.Presentation.Cart.ViewHolder.KhuyenMaiVH;
import com.example.myapplication.R;

import java.util.List;

public class KhuyenMaiAdapter extends RecyclerView.Adapter<KhuyenMaiVH>{
    private Context context;
    private List<KhuyenMai> list;
    private LayoutInflater minflater;
    private KhuyenMaiAdapter.ItemClickListener itemClickListener;
    private int rowindex=-1;

    public KhuyenMaiAdapter(Context context, List<KhuyenMai> list,KhuyenMaiAdapter.ItemClickListener itemClickListene) {
        this.context = context;
        this.list = list;
        this.minflater = LayoutInflater.from(context);
        this.itemClickListener = itemClickListene;
    }

    @NonNull
    @Override
    public KhuyenMaiVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.mh_item_promos_vouchers, parent, false);

        return new KhuyenMaiVH(itemView);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface ItemClickListener{
        void onItemClick(KhuyenMai khuyenMai);
    }
    @Override
    public void onBindViewHolder(@NonNull KhuyenMaiVH holder, int position) {
        KhuyenMai km = list.get(position);
        holder.updateUI(km);
        int p = position;
        holder.item_promos_vouchers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowindex = p;
                notifyDataSetChanged();
                itemClickListener.onItemClick(list.get(position));
            }
        });
        if(rowindex!=position){
            km.setChecked(false);
            holder.updateUI(km);
        }else{
            km.setChecked(true);
            holder.updateUI(km);

        }
    }
}
