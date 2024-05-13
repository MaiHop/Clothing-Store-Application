package com.example.myapplication.Presentation.Cart.ViewHolder;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Mau;
import com.example.myapplication.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

public class MauVH extends RecyclerView.ViewHolder{
    public ShapeableImageView iv_color;
    public TextView tv_color_name_cart,tv_line_item_color;
    public ConstraintLayout layout_item_color;
    public MauVH(@NonNull View itemView) {
        super(itemView);
        this.iv_color = itemView.findViewById(R.id.iv_Color_cart);
        this.tv_color_name_cart = itemView.findViewById(R.id.tv_color_name_cart);
        this.tv_line_item_color = itemView.findViewById(R.id.tv_line_item_color);
        this.layout_item_color = itemView.findViewById(R.id.layout_item_color);
    }
    public void updateUI(Mau mau){
        Picasso.get().load(mau.getImgUrl()).into(iv_color);
        tv_color_name_cart.setText(mau.getTen());
        tv_line_item_color.setVisibility(View.GONE);
        if(mau.isAble()){
            iv_color.setEnabled(true);
            tv_line_item_color.setVisibility(View.GONE);
        }else{
            tv_line_item_color.setVisibility(View.VISIBLE);
            iv_color.setEnabled(false);
        }
        if(mau.isChecked()){
            iv_color.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#528F65")));
        }else{
            iv_color.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#EFEFEF")));
        }


    }

}
