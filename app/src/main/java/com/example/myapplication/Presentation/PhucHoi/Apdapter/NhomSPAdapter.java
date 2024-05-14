package com.example.myapplication.Presentation.PhucHoi.Apdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Domain.Model.NhomSP;

import com.example.myapplication.Presentation.PhucHoi.Activity.DanhMucActivity;
import com.example.myapplication.Presentation.PhucHoi.ViewHolder.NhomSPVH;
import com.example.myapplication.R;

import java.util.List;

public class NhomSPAdapter extends RecyclerView.Adapter<NhomSPVH>{
    private List<NhomSP> nhomSPList;
    private Context context;
    private LayoutInflater minflater;

    public NhomSPAdapter(List<NhomSP> nhomSPList, Context context, LayoutInflater minflater) {
        this.nhomSPList = nhomSPList;
        this.context = context;
        this.minflater = minflater;
    }

    @NonNull
    @Override
    public NhomSPVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoi_item_boloc, parent, false);
        return new NhomSPVH(itemView);
    }

//    @Override
//    public void onBindViewHolder(@NonNull NhomSPVH holder, int position) {
//        NhomSP nhomSP = nhomSPList.get(position);
//        holder.bind(nhomSP);
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Chuyển sang DanhMucActivity và truyền thông tin nhóm sản phẩm
//                Intent intent = new Intent(context, DanhMucActivity.class);
//                intent.putExtra("nhomSPId", nhomSP.getId());
//                context.startActivity(intent);
//            }
//        });
//
//    }

    public void onBindViewHolder(@NonNull NhomSPVH holder, int position) {
        NhomSP nhomSP = nhomSPList.get(position);
        holder.bind(nhomSP);

        // Đặt onClickListener cho tenBoloc thay vì itemView
        holder.tenBoloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang DanhMucActivity và truyền thông tin nhóm sản phẩm
                Intent intent = new Intent(context, DanhMucActivity.class);
                intent.putExtra("nhomSPId", nhomSP.getId());
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return nhomSPList.size();
    }
    public void setListNhomSP(List<NhomSP> listnhomsp) {
        this.nhomSPList = listnhomsp;
        notifyDataSetChanged(); // Thông báo cho RecyclerView biết là danh sách đã thay đổi
    }

}
