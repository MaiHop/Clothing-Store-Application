package com.example.myapplication.Presentation.GH;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.DonHangChiTiet;
import com.example.myapplication.R;

import java.util.List;
public class ODAdapter extends RecyclerView.Adapter<ODAdapter.ViewHolder> {
    private List<DonHangChiTiet> items;

    public ODAdapter(List<DonHangChiTiet> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mh_item_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DonHangChiTiet item = items.get(position);
        holder.textViewDetail.setText(item.getSanPham().getTenSanPham());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewDetail = itemView.findViewById(R.id.tv_TenSanPham_order);
        }
    }

    // Method to update data in the adapter
    public void updateData(List<DonHangChiTiet> newItems) {
        items = newItems;
        notifyDataSetChanged();
    }
}
