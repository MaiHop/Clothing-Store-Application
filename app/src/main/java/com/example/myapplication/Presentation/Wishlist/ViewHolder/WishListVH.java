package com.example.myapplication.Presentation.Wishlist.ViewHolder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model2.SanPham;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class WishListVH extends RecyclerView.ViewHolder{
    public TextView tenSP;
    public TextView giaSP;
    public ImageView hinhSP;
    public CheckBox checkBox;
    List<SanPham> sanPham = new ArrayList<>();
    public WishListVH(@NonNull View itemView) {
        super(itemView);
        initUI();

    }
    public void initUI(){
        tenSP = itemView.findViewById(R.id.item_tenSP);
        giaSP = itemView.findViewById(R.id.item_giaSP);
        hinhSP = itemView.findViewById(R.id.item_imageSP);
        checkBox = itemView.findViewById(R.id.cbHeart);
    }
    public void updateUI(SanPham sanPham){
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
//        SanPham_api sanPham = yeuThich.getListsanpham().get(0);

//        Picasso.get().load(sanPham.getImageUrl()).into(this.hinhSP);
        Picasso.get().load(sanPham.getListKho().get(0).getImageURL()).into(hinhSP);
//        this.tenSP.setText(sanPham.getTenSanPham());
        this.tenSP.setText(sanPham.getTenSanPham());
//        this.giaSP.setText(decimalFormat.format(sanPham.getGiaban())+" VND");
//        this.giaSP.setText(decimalFormat.format(sanPham.getListKho().get(0).getImageURL())+" VND");


    }


}
