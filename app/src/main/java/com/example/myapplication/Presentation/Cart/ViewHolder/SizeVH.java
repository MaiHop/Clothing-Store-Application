package com.example.myapplication.Presentation.Cart.ViewHolder;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Model.KichThuoc;
import com.example.myapplication.R;

public class SizeVH extends RecyclerView.ViewHolder{
    public TextView tv_size;
    public SizeVH(@NonNull View itemView) {
        super(itemView);

        tv_size = itemView.findViewById(R.id.tv_Size_cart);
    }
    public void updateUI(KichThuoc size){
        tv_size.setText(size.getTen());
    }
}
