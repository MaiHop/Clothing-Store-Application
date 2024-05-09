package com.example.myapplication.Presentation.Wishlist.ViewHolder;

import android.content.Context;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Domain.Model.SanPham;
import com.example.myapplication.Domain.Model.YeuThich;
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
//        SanPham sanPham = yeuThich.getListsanpham().get(0);

        Picasso.get().load(sanPham.getImageUrl()).into(this.hinhSP);
//        this.tenSP.setText(sanPham.getTenSanPham());
        this.tenSP.setText(sanPham.getTenSanPham());
        this.giaSP.setText(decimalFormat.format(sanPham.getGiaban())+" VND");


    }


}
