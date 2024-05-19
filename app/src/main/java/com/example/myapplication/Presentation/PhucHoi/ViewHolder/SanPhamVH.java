package com.example.myapplication.Presentation.PhucHoi.ViewHolder;


import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.Model.SanPham;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;
public class SanPhamVH extends  RecyclerView.ViewHolder {
    private TextView  TenSP, GiaSP;
    private ImageView HinhSP;
    public CheckBox cb_wishlist;
    public SanPhamVH(View itemView) {
        super(itemView);
        TenSP = itemView.findViewById(R.id.titletxt);
        GiaSP = itemView.findViewById(R.id.pricetxt);
        HinhSP = itemView.findViewById(R.id.imgproduct);
        cb_wishlist = itemView.findViewById(R.id.cb_wishlist);
    }
    public void bind(SanPham product) {
        TenSP.setText(product.getTenSanPham());
        String formattedPrice = String.format("$%.2f", product.getGiaban());
        GiaSP.setText(formattedPrice);
        // Load image using a library like Picasso or Glide
        Picasso.get().load(product.getImageUrl()).into(HinhSP);
    }
}