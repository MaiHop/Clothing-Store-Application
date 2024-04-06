package com.example.myapplication.Presentation.Cart.ViewHolder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.google.android.material.imageview.ShapeableImageView;

public class MauVH extends RecyclerView.ViewHolder{
    public ShapeableImageView iv_color;
    public MauVH(@NonNull View itemView) {
        super(itemView);
        this.iv_color = itemView.findViewById(R.id.iv_Color_cart);
    }
    public void updateUI(){

    }

}
