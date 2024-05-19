// ColorAdapterPH.java
package com.example.myapplication.Presentation.PhucHoi.Apdapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Mau;
import com.example.myapplication.Presentation.PhucHoi.ViewHolder.MauVH;
import com.example.myapplication.R;

import java.util.List;

public class ColorAdapterPH extends RecyclerView.Adapter<MauVH> {

    private List<Mau> mauList;
    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener listener;
    private int selectedPosition = RecyclerView.NO_POSITION;

    public ColorAdapterPH(List<Mau> mauList, Context context, LayoutInflater inflater) {
        this.mauList = mauList;
        this.context = context;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public MauVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoi_item_color, parent, false);
        return new MauVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MauVH holder, int position) {
        Mau mau = mauList.get(position);
        holder.updateUI(mau);

        // Hiển thị trạng thái chọn
        holder.itemView.setSelected(selectedPosition == position);

        // Cập nhật trạng thái hiển thị dựa trên vị trí chọn
        if (selectedPosition == position) {
            holder.iv_color.setStrokeColor(ColorStateList.valueOf(context.getResources().getColor(R.color.selected_color)));
        } else {
            holder.iv_color.setStrokeColor(ColorStateList.valueOf(context.getResources().getColor(R.color.default_color)));
        }
        // Xử lý sự kiện click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemChanged(selectedPosition);
                selectedPosition = holder.getAdapterPosition();
                notifyItemChanged(selectedPosition);

                if (listener != null) {
                    listener.onItemClick(mau.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mauList.size();
    }

    public String getSelectedColorId() {
        if (selectedPosition != RecyclerView.NO_POSITION) {
            return mauList.get(selectedPosition).getId();
        }
        return null;
    }


    public interface OnItemClickListener {
        void onItemClick(String mauId);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setListMau(List<Mau> colorList) {
        this.mauList = colorList;
        notifyDataSetChanged(); // Thông báo cho RecyclerView biết là danh sách đã thay đổi
    }
}
