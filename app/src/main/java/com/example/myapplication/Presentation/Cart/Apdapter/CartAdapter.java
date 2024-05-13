package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Dialog.SPEditDialog;
import com.example.myapplication.Model.DonHangChiTiet;
import com.example.myapplication.Presentation.Cart.ViewHolder.GioHangVH;
import com.example.myapplication.Presentation.Cart.ViewModel.GioHangVM;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<GioHangVH> {
    private List<DonHangChiTiet> list;
    private List<DonHangChiTiet> list_checkout=new ArrayList<>();
    private LayoutInflater minflater;
    private Context context;
    private Button btn_DatHang;
    private TextView toolbar_title;
    private DonHangChiTiet donHangChiTiet;
    private GioHangVM gioHangVM;


    public CartAdapter(Context context, List<DonHangChiTiet> list, Button btn_DatHang, TextView toolbar_title, GioHangVM gioHangVM){
        this.list = list;
        this.context = context;
        this.minflater = LayoutInflater.from(context);
        this.btn_DatHang = btn_DatHang;
        this.toolbar_title = toolbar_title;
        this.gioHangVM = gioHangVM;
    }

    @NonNull
    @Override
    public GioHangVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.mh_item_cart, parent, false);

        return new GioHangVH(itemView);
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
    @Override
    public void onBindViewHolder(@NonNull GioHangVH holder, int position) {
        donHangChiTiet = list.get(position);
        toolbar_title.setText("Cart ("+list.size()+")");
        holder.updateTotal(list, btn_DatHang);
        holder.updateUI(donHangChiTiet);

        holder.cb_Selected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DonHangChiTiet dh_edit = list.get(holder.getAdapterPosition());
                dh_edit.setChecked(isChecked);
                holder.updateTotal(list, btn_DatHang);
            }
        });

        holder.ib_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DonHangChiTiet dh_edit = list.get(holder.getAdapterPosition());
                SPEditDialog dia = new SPEditDialog(context, dh_edit, gioHangVM);
                dia.showEditSanPhamDialog();
                notifyDataSetChanged();
            }
        });
        holder.ib_Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(),list.size());
                holder.removeItem(context,minflater);
                toolbar_title.setText("Cart ("+list.size()+")");
//                Toast.makeText(context,donHangChiTiet_edit.getTenSanPham(),Toast.LENGTH_SHORT).show();
            }
        });


    }



}
