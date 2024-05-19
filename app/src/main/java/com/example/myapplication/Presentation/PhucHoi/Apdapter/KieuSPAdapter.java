package com.example.myapplication.Presentation.PhucHoi.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.KieuSP;
import com.example.myapplication.Presentation.PhucHoi.ViewHolder.KieuSPVH;
import com.example.myapplication.R;

import java.util.List;

public class KieuSPAdapter extends RecyclerView.Adapter<KieuSPVH> {

    private List<KieuSP> kieuSPList;
    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener listener;
    private int selectedPosition = RecyclerView.NO_POSITION;

    public KieuSPAdapter(List<KieuSP> kieuSPList, Context context, LayoutInflater inflater) {
        this.kieuSPList = kieuSPList;
        this.context = context;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public KieuSPVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.hoi_item_kieusp, parent, false);
        return new KieuSPVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull KieuSPVH holder, int position) {
        KieuSP kieuSP = kieuSPList.get(position);
        holder.bind(kieuSP);
        holder.itemView.setSelected(selectedPosition == position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemChanged(selectedPosition);
                selectedPosition = holder.getAdapterPosition();
                notifyItemChanged(selectedPosition);

                if (listener != null) {
                    listener.onItemClick(kieuSP.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return kieuSPList.size();
    }

    public void setListNhomSP(List<KieuSP> listkieusp) {
        this.kieuSPList = listkieusp;
        notifyDataSetChanged();
    }

    public KieuSP getSelectedKieuSP() {
        if (selectedPosition != RecyclerView.NO_POSITION) {
            return kieuSPList.get(selectedPosition);
        }
        return null;
    }

    public void clearSelection() {
        int previousSelectedPosition = selectedPosition;
        selectedPosition = RecyclerView.NO_POSITION;
        notifyItemChanged(previousSelectedPosition);
    }

    public interface OnItemClickListener {
        void onItemClick(String kieuSPId);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
