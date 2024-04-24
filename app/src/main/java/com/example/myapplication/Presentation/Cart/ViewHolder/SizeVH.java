package com.example.myapplication.Presentation.Cart.ViewHolder;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Domain.Model.KichThuoc;
import com.example.myapplication.R;

public class SizeVH extends RecyclerView.ViewHolder{
    public TextView tv_Size_cart,tv_line_item_size;
    public SizeVH(@NonNull View itemView) {
        super(itemView);

        tv_Size_cart = itemView.findViewById(R.id.tv_Size_cart);
        tv_line_item_size = itemView.findViewById(R.id.tv_line_item_size);
    }
    public void updateUI(KichThuoc size){
        tv_Size_cart.setText(size.getTen());
        tv_line_item_size.setVisibility(View.GONE);
        if(size.isAble()){
            tv_Size_cart.setEnabled(true);
            tv_line_item_size.setVisibility(View.GONE);
            if(size.isChecked()){
                tv_Size_cart.setBackgroundResource(R.drawable.mh_item_size_selected);
                tv_Size_cart.setTextColor(ColorStateList.valueOf(Color.parseColor("#ffffff")));
            }else{
                tv_Size_cart.setBackgroundResource(R.drawable.mh_item_size_defaut);
                tv_Size_cart.setTextColor(ColorStateList.valueOf(Color.parseColor("#000000")));
            }
        }else{
            tv_Size_cart.setEnabled(false);
            tv_line_item_size.setVisibility(View.VISIBLE);
            tv_Size_cart.setTextColor(ColorStateList.valueOf(Color.parseColor("#EDEBEB")));
        }

    }
}
