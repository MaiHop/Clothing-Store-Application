package com.example.myapplication.Presentation.Cart.ViewHolder;


import com.example.myapplication.Domain.Model.DiaChi;
import com.example.myapplication.R;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DiaChiGHVH extends RecyclerView.ViewHolder{
    private TextView tv_TenDiaChi, tv_TenNguoiNhan_Sdt,tv_DiaChi,tv_XacDinh,tv_DiaChiChinh;
    public LinearLayout ll_item_DeliveryAddress;
    private ImageView iv_DA_checked;

    public DiaChiGHVH(@NonNull View itemView) {
        super(itemView);
        init();
    }

    public void updateUI(DiaChi diachi){
        tv_TenDiaChi.setText(diachi.getTenDiaChi());
        if (diachi.isDiaChiChinh()){
            tv_DiaChiChinh.setVisibility(View.VISIBLE);
            diachi.setChecked(true);
        }else {
            tv_DiaChiChinh.setVisibility(View.INVISIBLE);
        }
        tv_TenNguoiNhan_Sdt.setText(diachi.getNguoiNhan()+"\t("+diachi.getSDT()+")");
        tv_DiaChi.setText(diachi.getDiaChi());
        if(diachi.isXacDinh()){
            tv_XacDinh.setText("Pinpoint already");
        }else {
            tv_XacDinh.setText("Pinpoint undefined");
        }
        if(diachi.isChecked()){
            iv_DA_checked.setVisibility(View.VISIBLE);
            ll_item_DeliveryAddress.setBackgroundResource(R.drawable.solid_white_stroke_green_rad_5);
        }else {
            iv_DA_checked.setVisibility(View.INVISIBLE);
            ll_item_DeliveryAddress.setBackgroundResource(R.drawable.solid_white_rad_5);
        }

    }
    private void init(){
        tv_TenDiaChi = itemView.findViewById(R.id.tv_TenDiaChi);
        tv_TenNguoiNhan_Sdt = itemView.findViewById(R.id.tv_TenNguoiNhan_Sdt);
        tv_DiaChi = itemView.findViewById(R.id.tv_DiaChi);
        tv_XacDinh = itemView.findViewById(R.id.tv_XacDinh);
        tv_DiaChiChinh = itemView.findViewById(R.id.tv_DiaChiChinh);
        ll_item_DeliveryAddress = itemView.findViewById(R.id.layout_item_delivery_adress);
        iv_DA_checked = itemView.findViewById(R.id.iv_DA_checked);
    }

}
