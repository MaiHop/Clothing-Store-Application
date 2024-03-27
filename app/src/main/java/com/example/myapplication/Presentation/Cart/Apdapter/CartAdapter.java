package com.example.myapplication.Presentation.Cart.Apdapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Cart;
import com.example.myapplication.Presentation.Cart.CartRepository;
import com.example.myapplication.Presentation.Cart.ViewHolder.CartViewHolder;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    private List<Cart> list;
    private List<Cart> list_checkout=new ArrayList<>();
    private LayoutInflater minflater;
    private Context context;
    private Button btn_DatHang;
    private TextView toolbar_title;
    private double total =0;

    public CartAdapter(Context context, List<Cart> list, Button btn_DatHang, TextView toolbar_title){
        this.list = list;
        this.context = context;
        this.minflater = LayoutInflater.from(context);
        this.btn_DatHang = btn_DatHang;
        this.toolbar_title = toolbar_title;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.item_cart, parent, false);

        return new CartViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
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
                Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottom_dialog_cart);
                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM);

                CartRepository rep = new CartRepository();
                List<String> list = rep.ListSize();

                RecyclerView rv_size =context.findViewById(R.id.rv_size);

                CartAdapter cartAdapter =new CartAdapter(context, list,btn_DatHang, toolbar_title);
                this.rv_ListCart.setAdapter(cartAdapter);
                this.rv_ListCart.setLayoutManager(new LinearLayoutManager(this));


            }
        });
    }


}
