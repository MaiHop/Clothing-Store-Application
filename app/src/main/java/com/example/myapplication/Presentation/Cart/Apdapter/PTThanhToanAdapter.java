package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Model.DiaChiGH;
import com.example.myapplication.Presentation.Cart.Model.PTThanhToan;
import com.example.myapplication.Presentation.Cart.ViewHolder.DiaChiGHVH;
import com.example.myapplication.Presentation.Cart.ViewHolder.PTThanhToanVH;
import com.example.myapplication.R;

import java.util.List;

public class PTThanhToanAdapter extends RecyclerView.Adapter<PTThanhToanVH>{
    private Context context;
    private List<PTThanhToan> list;
    private LayoutInflater minflater;
    private int rowindex=-1;

    public PTThanhToanAdapter(Context context, List<PTThanhToan> list) {
        this.context = context;
        this.list = list;
        this.minflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PTThanhToanVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.item_payment_methods, parent, false);

        return new PTThanhToanVH(itemView);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull PTThanhToanVH holder, int position) {
        PTThanhToan pttt = list.get(position);
        holder.updateUI(pttt);
        int p = position;
        holder.item_payment_method.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowindex = p;
                notifyDataSetChanged();

            }
        });
        if(rowindex!=position){
            pttt.setChecked(false);
            holder.updateUI(pttt);
        }else{
            pttt.setChecked(true);
            holder.updateUI(pttt);

        }
    }
}
