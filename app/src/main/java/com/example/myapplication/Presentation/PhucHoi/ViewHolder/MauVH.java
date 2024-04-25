package com.example.myapplication.Presentation.PhucHoi.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.Domain.Model.Mau;
import com.example.myapplication.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

public class MauVH extends RecyclerView.ViewHolder{
    public ShapeableImageView iv_color;
    public TextView tv_color_name_cart,tv_line_item_color;
    public MauVH(@NonNull View itemView) {
        super(itemView);
        this.iv_color = itemView.findViewById(R.id.iv_Color_cart); // Gán ShapeableImageView với ID của ImageView trong XML
        this.tv_color_name_cart = itemView.findViewById(R.id.tv_line_item_color); // Gán TextView với ID của TextView trong XML
        this.tv_line_item_color = itemView.findViewById(R.id.tv_line_item_color); // (Nếu cần) Gán TextView khác (nếu có) với ID trong XML
    }


    public void updateUI(Mau mau){
        Picasso.get().load(mau.getImgUrl()).into(iv_color);
        tv_color_name_cart.setText(mau.getTen()); // Hiển thị tên màu trong TextView tv_color_name_cart
        tv_line_item_color.setText(mau.getTen()); // Hiển thị tên màu trong TextView tv_line_item_color
        tv_line_item_color.setVisibility(View.VISIBLE); // Đảm bảo TextView tv_line_item_color được hiển thị
    }
    }


