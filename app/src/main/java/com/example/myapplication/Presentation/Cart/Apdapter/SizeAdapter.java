package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Model.KichThuoc;
import com.example.myapplication.Presentation.Cart.ViewHolder.SizeVH;
import com.example.myapplication.R;

import java.util.List;

public class SizeAdapter extends RecyclerView.Adapter<SizeVH> {
    private List<KichThuoc> list_size;
    private Context context;
    private LayoutInflater minflater;
    private ItemClickListener itemClickListener;
    public SizeAdapter( Context context,List<KichThuoc> list_size, ItemClickListener itemClickListener) {
        this.list_size = list_size;
        this.context = context;
        this.minflater = LayoutInflater.from(context);
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public SizeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.mh_item_size, parent, false);

        return new SizeVH(itemView);
    }

    @Override
    public int getItemCount() {
        return list_size.size();
    }
    public interface ItemClickListener{
        void onItemClick(KichThuoc kichthuoc);
    }
    @Override
    public void onBindViewHolder(@NonNull SizeVH holder, int position) {
        KichThuoc size = list_size.get(position);
        holder.updateUI(size);
        int p = position;
        holder.tv_Size_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged();
                itemClickListener.onItemClick(size);
            }
        });

    }
}
