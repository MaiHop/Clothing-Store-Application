package com.example.myapplication.Presentation.GH;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.DonHangChiTiet;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

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
        holder.textViewMau.setText(item.getSanPham().getMau().getTen());
        holder.textViewSize.setText(item.getSanPham().getKichThuoc().getTen());
//        holder.textMauSize.setText(item.getSanPham().getMau().getImgUrl());
        holder.textViewSoLuong.setText(String.valueOf(item.getSanPham().getSoLuongBan()));
        holder.textViewGia.setText(String.valueOf(item.getSanPham().getGiaban()));
        Picasso.get().load(item.getSanPham().getImageUrl()).into(holder.picOD);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewDetail,textViewMau,textViewSize,textViewSoLuong,textViewGia,textMauSize;
        public ImageView picOD;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewDetail = itemView.findViewById(R.id.tv_TenSanPham_order);
            textViewMau = itemView.findViewById(R.id.tv_Mau_order);
            textViewSize = itemView.findViewById(R.id.tv_Size_order);
            textViewSoLuong = itemView.findViewById(R.id.tv_SoLuong_order);
            textViewGia = itemView.findViewById(R.id.tv_ThanhTien_order);
//            textMauSize = itemView.findViewById(R.id.iv_Color_order);
            picOD = itemView.findViewById(R.id.iv_Image_order);
        }
    }

    // Method to update data in the adapter
    public void updateData(List<DonHangChiTiet> newItems) {
        items = newItems;
        notifyDataSetChanged();
    }
}