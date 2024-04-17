package com.example.myapplication.Presentation.Cart.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Model.ThanhToan;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class PTThanhToanVH extends RecyclerView.ViewHolder{
    private ImageView iv_Logo_ThanhToanv,  iv_PM_Checked;
    private TextView tv_TenThanhToan;
    public LinearLayout item_payment_method;
    public PTThanhToanVH(@NonNull View itemView) {
        super(itemView);

        iv_Logo_ThanhToanv = itemView.findViewById(R.id.iv_Logo_ThanhToan);
        iv_PM_Checked = itemView.findViewById(R.id.iv_PM_Checked);
        tv_TenThanhToan = itemView.findViewById(R.id.tv_TenThanhToan);
        item_payment_method = itemView.findViewById(R.id.layout_item_payment_method);
    }
    public void updateUI(ThanhToan ptthanhtoan){
        Picasso.get().load(ptthanhtoan.getImageUrl()).into(this.iv_Logo_ThanhToanv);
        tv_TenThanhToan.setText(ptthanhtoan.getTenThanhToan());
        if(ptthanhtoan.isChecked()){
            iv_PM_Checked.setVisibility(View.VISIBLE);
            item_payment_method.setBackgroundResource(R.drawable.solid_white_stroke_green_rad_5);
        } else {
            iv_PM_Checked.setVisibility(View.INVISIBLE);
            item_payment_method.setBackgroundResource(R.drawable.solid_white_rad_5);
        }
    }
}
