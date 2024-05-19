package com.example.myapplication.Presentation.PhucHoi.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.Model.KichThuoc;
import com.example.myapplication.Presentation.PhucHoi.ViewHolder.SizeVH;
import com.example.myapplication.R;

import java.util.List;

public class SizeAdapterPH extends RecyclerView.Adapter<SizeVH> {

    private List<KichThuoc> kichThuocList;
    private Context context;
    private LayoutInflater minflater;
    private LayoutInflater inflater;
    private KieuSPAdapter.OnItemClickListener listener;
    private int selectedPosition = RecyclerView.NO_POSITION;

    public SizeAdapterPH(List<KichThuoc> kichThuocList, LayoutInflater inflater) {
        this.kichThuocList = kichThuocList;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public SizeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoi_item_size, parent, false);
        return new SizeVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SizeVH holder, int position) {
        KichThuoc kichhuoc = kichThuocList.get(position);
        holder.updateUI(kichhuoc);
        holder.itemView.setSelected(selectedPosition == position);

        // Xử lý sự kiện click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemChanged(selectedPosition);
                selectedPosition = holder.getAdapterPosition();
                notifyItemChanged(selectedPosition);

                if (listener != null) {
                    listener.onItemClick(kichhuoc.getId());
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return kichThuocList.size();
    }
    public void setListKichThuoc(List<KichThuoc>KTList) {
        this.kichThuocList = KTList;
        notifyDataSetChanged(); // Thông báo cho RecyclerView biết là danh sách đã thay đổi
    }


}
