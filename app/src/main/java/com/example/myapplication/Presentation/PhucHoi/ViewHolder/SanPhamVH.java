package com.example.myapplication.Presentation.PhucHoi.ViewHolder;


import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.Model2.SanPham;
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
        if (product.getListKho() != null && !product.getListKho().isEmpty()) {
            Double giaBan = product.getListKho().get(0).getGiaBan();
            String formattedPrice = String.format("$%.2f", giaBan);
            GiaSP.setText(formattedPrice);
        }
        // Load image using a library like Picasso or Glide
//        Picasso.get().load(product.getImageUrl()).into(HinhSP);
        String imageUrl = product.getListKho().get(0).getImageURL();

        // Load image using a library like Picasso or Glide
        Picasso.get().load(imageUrl).into(HinhSP);
    }
}