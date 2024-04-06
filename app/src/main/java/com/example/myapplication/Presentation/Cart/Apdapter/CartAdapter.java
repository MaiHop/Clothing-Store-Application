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

import com.example.myapplication.Presentation.Cart.Model.Cart;
import com.example.myapplication.Presentation.Cart.ViewHolder.GioHangVH;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<GioHangVH> {
    private List<Cart> list;
    private List<Cart> list_checkout=new ArrayList<>();
    private LayoutInflater minflater;
    private Context context;
    private Button btn_DatHang;
    private TextView toolbar_title;


    public CartAdapter(Context context, List<Cart> list, Button btn_DatHang, TextView toolbar_title){
        this.list = list;
        this.context = context;
        this.minflater = LayoutInflater.from(context);
        this.btn_DatHang = btn_DatHang;
        this.toolbar_title = toolbar_title;
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
        Cart cart = list.get(position);
        toolbar_title.setText("Cart ("+list.size()+")");
        holder.updateTotal(list, btn_DatHang);
        holder.updateUI(cart);
        holder.cb_Selected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cart.setChecked(isChecked);
                holder.updateTotal(list, btn_DatHang);
            }
        });

        holder.ib_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.showdialog(context);
            }
        });
        holder.ib_Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.removeItem(context,minflater);

            }
        });


    }



}
