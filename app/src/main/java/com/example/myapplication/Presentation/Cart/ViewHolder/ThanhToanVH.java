package com.example.myapplication.Presentation.Cart.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.DonHangChiTiet;
import com.example.myapplication.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

public class ThanhToanVH extends RecyclerView.ViewHolder{
    public TextView tv_TenSanPham, tv_Size, tv_Mau, tv_SoLuong, tv_ThanhTien;
    public ImageView iv_Image;
    public ShapeableImageView iv_Color_order;
    public LinearLayout item_payment_method;
    public ThanhToanVH(@NonNull View itemView) {
        super(itemView);

        //ImageView
        this.iv_Image = itemView.findViewById((R.id.iv_Image_order));
        this.iv_Color_order = itemView.findViewById(R.id.iv_Color_order);
        //TextView
        this.tv_TenSanPham = itemView.findViewById(R.id.tv_TenSanPham_order);
        this.tv_Size = itemView.findViewById(R.id.tv_Size_order);
        this.tv_Mau = itemView.findViewById(R.id.tv_Mau_order);
        this.tv_SoLuong = itemView.findViewById(R.id.tv_SoLuong_order);
        this.tv_ThanhTien = itemView.findViewById(R.id.tv_ThanhTien_order);
        this.item_payment_method = itemView.findViewById(R.id.layout_item_payment_method);
    }
    public void updateUI(DonHangChiTiet donHangChiTiet){
        Picasso.get().load(donHangChiTiet.getSanPham().getImageUrl()).into(this.iv_Image);
        Picasso.get().load(donHangChiTiet.getSanPham().getMau().getImgUrl()).into(this.iv_Color_order);
        this.tv_TenSanPham.setText(donHangChiTiet.getSanPham().getTenSanPham());
        this.tv_Size.setText("Size : "+ donHangChiTiet.getSanPham().getKichThuoc().getTen());
        this.tv_Mau.setText("Color : "+ donHangChiTiet.getSanPham().getMau().getTen());
        this.tv_SoLuong.setText("Qty :"+ donHangChiTiet.getSoLuong());
        this.tv_ThanhTien.setText("$"+ donHangChiTiet.getThanhTien());
    }
}
