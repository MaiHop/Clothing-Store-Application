package com.example.myapplication.Presentation.Homepage.phuchoi.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Homepage.phuchoi.ViewHolder.SizeVH;
import com.example.myapplication.Presentation.Homepage.phuchoi.Model.KichThuoc;
import com.example.myapplication.R;

import java.util.List;

public class SizeAdapterPH extends RecyclerView.Adapter<SizeVH> {

    private List<KichThuoc> kichThuocList;
    private Context context;

    public SizeAdapterPH(List<KichThuoc> kichThuocList, Context context) {
        this.kichThuocList = kichThuocList;
        this.context = context;
    }

    @NonNull
    @Override
    public SizeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoi_item_sizeph, parent, false);
        return new SizeVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SizeVH holder, int position) {
        KichThuoc kichhuoc = kichThuocList.get(position);
        holder.updateUI(kichhuoc);
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
