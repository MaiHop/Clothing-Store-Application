package com.example.myapplication.Presentation.PhucHoi.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.KieuSP;

import com.example.myapplication.Model.NhomSP;
import com.example.myapplication.Presentation.PhucHoi.ViewHolder.KieuSPVH;
import com.example.myapplication.Presentation.PhucHoi.ViewHolder.NhomSPVH;
import com.example.myapplication.R;

import java.util.List;

public class KieuSPAdapter extends RecyclerView.Adapter<KieuSPVH>{

    private List<KieuSP> kieuSPList;
    private Context context;
    private LayoutInflater minflater;
    private OnItemClickListener listener;

    public KieuSPAdapter(List<KieuSP> kieuSPList, Context context, LayoutInflater minflater) {
        this.kieuSPList = kieuSPList;
        this.context = context;
        this.minflater = minflater;

    }

    @NonNull
    @Override
    public KieuSPVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoi_item_kieusp, parent, false);
        return new KieuSPVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull KieuSPVH holder, int position) {
        KieuSP kieuSP = kieuSPList.get(position);
        holder.bind(kieuSP);
        holder.tenkieuSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(kieuSP.getId());
                }
            }
        });


    }
    public interface OnItemClickListener {
        void onItemClick(String kieuSPId);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return kieuSPList.size();
    }
    public void setListNhomSP(List<KieuSP> listkieusp) {
        this.kieuSPList = listkieusp;
        notifyDataSetChanged(); // Thông báo cho RecyclerView biết là danh sách đã thay đổi
    }

}
