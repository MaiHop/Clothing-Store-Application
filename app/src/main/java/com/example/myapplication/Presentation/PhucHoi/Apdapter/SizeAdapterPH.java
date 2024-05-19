package com.example.myapplication.Presentation.PhucHoi.Apdapter;

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
    private LayoutInflater inflater;
    private OnItemClickListener listener;
    private int selectedPosition = RecyclerView.NO_POSITION;

    public SizeAdapterPH(List<KichThuoc> kichThuocList, LayoutInflater inflater) {
        this.kichThuocList = kichThuocList;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public SizeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView  = inflater.inflate(R.layout.hoi_item_size, parent, false);
        return new SizeVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SizeVH holder, int position) {
        KichThuoc kichThuoc = kichThuocList.get(position);
        holder.updateUI(kichThuoc);
        holder.itemView.setSelected(selectedPosition == position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemChanged(selectedPosition);
                selectedPosition = holder.getAdapterPosition();
                notifyItemChanged(selectedPosition);

                if (listener != null) {
                    listener.onItemClick(kichThuoc.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return kichThuocList.size();
    }

    public void setListKichThuoc(List<KichThuoc> KTList) {
        this.kichThuocList = KTList;
        notifyDataSetChanged();
    }

    public KichThuoc getSelectedSize() {
        if (selectedPosition != RecyclerView.NO_POSITION) {
            return kichThuocList.get(selectedPosition);
        }
        return null;
    }

    public void clearSelection() {
        int previousSelectedPosition = selectedPosition;
        selectedPosition = RecyclerView.NO_POSITION;
        notifyItemChanged(previousSelectedPosition);
    }

    public interface OnItemClickListener {
        void onItemClick(String kichThuocId);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
