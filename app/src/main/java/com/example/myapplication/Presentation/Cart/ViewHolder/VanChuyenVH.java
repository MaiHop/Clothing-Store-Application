package com.example.myapplication.Presentation.Cart.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Model.VanChuyen;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class VanChuyenVH extends RecyclerView.ViewHolder{
    private ImageView iv_Logo_VanChuyen,iv_D_Checked;
    private TextView tv_TenVanChuyen, tv_ThoiGianDuKien;
    public LinearLayout item_delivery;
    public VanChuyenVH(@NonNull View itemView) {
        super(itemView);

        iv_Logo_VanChuyen = itemView.findViewById(R.id.iv_Logo_VanChuyen);
        iv_D_Checked = itemView.findViewById(R.id.iv_D_Checked);
        tv_TenVanChuyen = itemView.findViewById(R.id.tv_TenVanChuyen);
        tv_ThoiGianDuKien = itemView.findViewById(R.id.tv_ThoiGianDuKien);
        item_delivery = itemView.findViewById(R.id.layout_item_delivery);
    }

    public void updateUI(VanChuyen vanchuyen){
        Picasso.get().load(vanchuyen.getImageURL()).into(this.iv_Logo_VanChuyen);
        tv_TenVanChuyen.setText(vanchuyen.getTen());
        tv_ThoiGianDuKien.setText("Ngày giao dự kiến: "+vanchuyen.getNgayGiao());
        if(vanchuyen.isChecked()){
            iv_D_Checked.setVisibility(View.VISIBLE);
            item_delivery.setBackgroundResource(R.drawable.solid_white_stroke_green_rad_5);
        }else {
            iv_D_Checked.setVisibility(View.INVISIBLE);
            item_delivery.setBackgroundResource(R.drawable.solid_white_rad_5);
        }
    }
}
