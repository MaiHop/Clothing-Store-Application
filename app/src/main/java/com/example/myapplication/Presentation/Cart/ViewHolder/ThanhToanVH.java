package com.example.myapplication.Presentation.Cart.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Model.Cart;
import com.example.myapplication.R;

public class ThanhToanVH extends RecyclerView.ViewHolder{
    public TextView tv_TenSanPham, tv_Size, tv_Mau, tv_SoLuong, tv_ThanhTien;
    public ImageView iv_Image;
    public LinearLayout item_payment_method;
    public ThanhToanVH(@NonNull View itemView) {
        super(itemView);

        //ImageView
        this.iv_Image = itemView.findViewById((R.id.iv_Image_order));
        //TextView
        this.tv_TenSanPham = itemView.findViewById(R.id.tv_TenSanPham_order);
        this.tv_Size = itemView.findViewById(R.id.tv_Size_order);
        this.tv_Mau = itemView.findViewById(R.id.tv_Mau_order);
        this.tv_SoLuong = itemView.findViewById(R.id.tv_SoLuong_order);
        this.tv_ThanhTien = itemView.findViewById(R.id.tv_ThanhTien_order);
        this.item_payment_method = itemView.findViewById(R.id.item_payment_method);
    }
    public void updateUI(Cart cart){
        this.iv_Image.setImageResource(cart.getImage());
        this.tv_TenSanPham.setText(cart.getTenSanPham());
        this.tv_Size.setText("Size : "+cart.getSize());
        this.tv_Mau.setText("Color : "+cart.getMau());
        this.tv_SoLuong.setText("Qty :"+cart.getSoLuong());
        this.tv_ThanhTien.setText("$"+cart.getThanhTien());
    }
}
