package com.example.myapplication.Presentation.Cart.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.KhuyenMai;
import com.example.myapplication.R;

public class KhuyenMaiVH extends RecyclerView.ViewHolder{
    public LinearLayout item_promos_vouchers;
    public TextView tv_TenKhuyenMai, tv_ChiTietKhuyenMai;
    public ImageView iv_PV_Checked;
    public KhuyenMaiVH(@NonNull View itemView) {
        super(itemView);

        item_promos_vouchers = itemView.findViewById(R.id.layout_item_promos_vouchers);
        tv_TenKhuyenMai = itemView.findViewById(R.id.tv_TenKhuyenMai);
        tv_ChiTietKhuyenMai = itemView.findViewById(R.id.tv_ChiTietKhuyenMai);
        iv_PV_Checked = itemView.findViewById(R.id.iv_PV_Checked);
    }
    public void updateUI(KhuyenMai khuyenmai){
        tv_TenKhuyenMai.setText(khuyenmai.getTenKhuyenMai());
        tv_ChiTietKhuyenMai.setText((khuyenmai.getNoiDung()));
        if(khuyenmai.isChecked()){
            item_promos_vouchers.setBackgroundResource(R.drawable.solid_white_stroke_green_rad_5);
            iv_PV_Checked.setVisibility(View.VISIBLE);
        }else {
            item_promos_vouchers.setBackgroundResource(R.drawable.solid_white_rad_5);
            iv_PV_Checked.setVisibility(View.INVISIBLE);
        }
    }
}
