package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Model.DonHangChiTiet;
import com.example.myapplication.Presentation.Cart.ViewHolder.ThanhToanVH;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CheckOutAdapter extends RecyclerView.Adapter<ThanhToanVH> {
    private List<DonHangChiTiet> list;
    private List<DonHangChiTiet> list_checkout=new ArrayList<>();
    private LayoutInflater minflater;
    private Context context;
    private TextView order_title;


    public CheckOutAdapter(Context context, List<DonHangChiTiet> list, TextView order_title){
        this.list = list;
        this.context = context;
        this.minflater = LayoutInflater.from(context);
        this.order_title = order_title;
    }

    @NonNull
    @Override
    public ThanhToanVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.mh_item_order, parent, false);

        return new ThanhToanVH(itemView);
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ThanhToanVH holder, int position) {
        DonHangChiTiet donHangChiTiet = list.get(position);
        order_title.setText("Cart ("+list.size()+")");
        donHangChiTiet.setThanhTien(donHangChiTiet.getSanPham().getGiaban()*donHangChiTiet.getSoLuong());
        holder.updateUI(donHangChiTiet);



    }



}
