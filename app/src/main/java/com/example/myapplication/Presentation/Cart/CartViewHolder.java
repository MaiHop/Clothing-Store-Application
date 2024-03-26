package com.example.myapplication.Presentation.Cart;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CartViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_TenSanPham, tv_Size, tv_Mau, tv_SoLuong, tv_ThanhTien;
    public ImageButton ib_Edit, ib_Remove;
    public ImageView iv_Image;
    public CheckBox cb_Selected;
    public ConstraintLayout layout_item_cart;
    public CartViewHolder(@NonNull View itemView) {
        super(itemView);

        //CheckBox
        this.cb_Selected = itemView.findViewById(R.id.cb_Selected);
        //ImageView
        this.iv_Image = itemView.findViewById((R.id.iv_Image));
        //TextView
        this.tv_TenSanPham = itemView.findViewById(R.id.tv_TenSanPham);
        this.tv_Size = itemView.findViewById(R.id.tv_Size);
        this.tv_Mau = itemView.findViewById(R.id.tv_Mau);
        this.tv_SoLuong = itemView.findViewById(R.id.tv_SoLuong);
        this.tv_ThanhTien = itemView.findViewById(R.id.tv_ThanhTien);
        //Image Button
        this.ib_Edit = itemView.findViewById(R.id.ib_Edit);
        this.ib_Remove = itemView.findViewById(R.id.ib_Remove);
        this.layout_item_cart = itemView.findViewById(R.id.layout_item_cart);
//        this.layout_item_cart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onClick
//            }
//        });
        //Button



    }

    public void updateUI(Cart cart){
        this.iv_Image.setImageResource(cart.getImage());
        this.tv_TenSanPham.setText(cart.getTenSanPham());
        this.tv_Size.setText("Size : "+cart.getSize());
        this.tv_Mau.setText("Color : "+cart.getMau());
        this.tv_SoLuong.setText("Qty :"+cart.getSoLuong());
        this.tv_ThanhTien.setText("$"+cart.getThanhTien());
        this.cb_Selected.setSelected(cart.isChecked());


    }

    public void updateTotal(List<Cart> list,Button button){
        double total = 0;
        int count =0;
        for(Cart cart : list){
            if(cart.isChecked()){
                total += cart.getThanhTien();
                count++;
            }
        }
        button.setText("Checkout ("+count+") - "+"$"+total);

    }



}
