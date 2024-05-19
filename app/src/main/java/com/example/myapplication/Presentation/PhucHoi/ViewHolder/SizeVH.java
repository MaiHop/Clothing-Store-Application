package com.example.myapplication.Presentation.PhucHoi.ViewHolder;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.Model.KichThuoc;
import com.example.myapplication.R;

public class SizeVH extends RecyclerView.ViewHolder{
    public TextView tv_Size_cart;

    public SizeVH(@NonNull View itemView) {
        super(itemView);

        tv_Size_cart = itemView.findViewById(R.id.tv_Size_cart);

    }
    public void updateUI(KichThuoc size){
        tv_Size_cart.setText(size.getTen());


    }
}
