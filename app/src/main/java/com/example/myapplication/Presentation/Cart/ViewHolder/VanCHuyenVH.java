package com.example.myapplication.Presentation.Cart.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Model.VanCHuyen;
import com.example.myapplication.R;

public class VanCHuyenVH extends RecyclerView.ViewHolder{
    private ImageView iv_Logo_VanChuyen,iv_D_Checked;
    private TextView tv_TenVanChuyen, tv_ThoiGianDuKien;
    private LinearLayout item_delivery;
    public VanCHuyenVH(@NonNull View itemView) {
        super(itemView);

        iv_Logo_VanChuyen = itemView.findViewById(R.id.iv_Logo_VanChuyen);
        iv_D_Checked = itemView.findViewById(R.id.iv_D_Checked);
        tv_TenVanChuyen = itemView.findViewById(R.id.tv_TenVanChuyen);
        tv_ThoiGianDuKien = itemView.findViewById(R.id.tv_ThoiGianDuKien);
        item_delivery = itemView.findViewById(R.id.item_delivery);
    }

    public void updateUI(VanCHuyen vanchuyen){
        iv_Logo_VanChuyen.setImageResource(vanchuyen.getLogo());
        tv_TenVanChuyen.setText(vanchuyen.getTenDonVI());
        tv_ThoiGianDuKien.setText("Thời gian giao dự kiến: "+vanchuyen.getThoiGian());
        if(vanchuyen.isChecked()){
            iv_D_Checked.setVisibility(View.VISIBLE);
            item_delivery.setBackgroundResource(R.drawable.stroke_green_rad_5);
        }else {
            iv_D_Checked.setVisibility(View.INVISIBLE);
            item_delivery.setBackgroundResource(R.drawable.stroke_black_rad_5);
        }
    }
}
