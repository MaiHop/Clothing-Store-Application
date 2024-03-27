package com.example.myapplication.Presentation.Cart.ViewHolder;


import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Cart;
import com.example.myapplication.R;

public class SizeViewHolder extends RecyclerView.ViewHolder{
    public TextView tv_size;
    public SizeViewHolder(@NonNull View itemView) {
        super(itemView);

        tv_size = itemView.findViewById(R.id.tv_Size);
    }
    public void updateUI(String size){
        tv_size.setText(size);
    }
}
