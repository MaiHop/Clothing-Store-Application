package com.example.myapplication.Presentation.Cart.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Activity.SPEditDialog;
import com.example.myapplication.Presentation.Cart.Model.DonHangChiTiet;
import com.example.myapplication.Presentation.Cart.ViewHolder.GioHangVH;
import com.example.myapplication.Presentation.Cart.ViewModel.CartVM;
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
    private CartVM cartVM;


    public CartAdapter(Context context, List<DonHangChiTiet> list, Button btn_DatHang, TextView toolbar_title, CartVM cartVM){
        this.list = list;
        this.context = context;
        this.minflater = LayoutInflater.from(context);
        this.btn_DatHang = btn_DatHang;
        this.toolbar_title = toolbar_title;
        this.cartVM = cartVM;
    }

    @NonNull
    @Override
    public GioHangVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.item_cart, parent, false);

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
                donHangChiTiet.setChecked(isChecked);
                holder.updateTotal(list, btn_DatHang);
            }
        });

        holder.ib_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DonHangChiTiet dh_edit = list.get(holder.getAdapterPosition());
//                Toast.makeText(context, dh_edit.getSanPham().getTenSanPham(),Toast.LENGTH_SHORT).show();
//                holder.show_dialog(context,dh_edit);
                SPEditDialog dia = new SPEditDialog(context, dh_edit, cartVM);
                dia.showEditSanPhamDialog();
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
