package com.example.myapplication.Presentation.Cart.ViewHolder;

import android.app.Dialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Activity.GioHangActivity;
import com.example.myapplication.Presentation.Cart.Apdapter.CartAdapter;
import com.example.myapplication.Presentation.Cart.Apdapter.ColorAdapter;
import com.example.myapplication.Presentation.Cart.Apdapter.SizeAdapter;
import com.example.myapplication.Presentation.Cart.Model.DonHangChiTiet;
import com.example.myapplication.Presentation.Cart.Model.KichThuoc;
import com.example.myapplication.Presentation.Cart.Model.Mau;
import com.example.myapplication.Presentation.Cart.Model.SanPham;
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;
import com.example.myapplication.Presentation.Cart.ViewModel.CartVM;
import com.example.myapplication.Presentation.Cart.ViewModel.KichThuocVM;
import com.example.myapplication.Presentation.Cart.ViewModel.MauVM;
import com.example.myapplication.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class GioHangVH extends RecyclerView.ViewHolder {
    public TextView tv_TenSanPham_cart, tv_Size_cart, tv_Mau_cart, tv_SoLuong_cart,
            tv_ThanhTien_cart;
    public ImageButton ib_Edit, ib_Remove;
    public ImageView iv_Image_cart;
    public ShapeableImageView iv_Color_cart;
    public CheckBox cb_Selected;
    public ConstraintLayout layout_item_cart;
    private CartVM cartVM;
    private Button btn_Giam, btn_Tang, btn_Cancel, btn_Confirm;
    private Dialog dialog;
    public GioHangVH(@NonNull View itemView) {
        super(itemView);
        init();
    }
    public void updateUI(DonHangChiTiet donHangChiTiet){
        Picasso.get().load(donHangChiTiet.getSanPham().getImageUrl()).into(iv_Image_cart);
        Picasso.get().load(donHangChiTiet.getSanPham().getMau().getImgUrl()).into(iv_Color_cart);
        this.tv_TenSanPham_cart.setText(donHangChiTiet.getSanPham().getTenSanPham());
        this.tv_Size_cart.setText("Size : "+ donHangChiTiet.getSanPham().getKichThuoc().getTen());
        this.tv_Mau_cart.setText("Color : "+ donHangChiTiet.getSanPham().getMau().getTen());
        this.tv_SoLuong_cart.setText("Qty : " + donHangChiTiet.getSoLuong());
        this.tv_ThanhTien_cart.setText("$"+ donHangChiTiet.getThanhTien());
        this.cb_Selected.setSelected(donHangChiTiet.isChecked());
    }

    public void updateTotal(List<DonHangChiTiet> list, Button button){
        double total = 0;
        int count =0;
        for(DonHangChiTiet donHangChiTiet : list){
            if(donHangChiTiet.isChecked()){
                total += donHangChiTiet.getThanhTien();
                count++;
            }
        }
        button.setText("Checkout ("+count+") - "+"$"+total);
    }


    public void removeItem(Context context,LayoutInflater layoutInflater) {
        Toast toast = new Toast(context);
        View view = layoutInflater.inflate(R.layout.custom_toast,(ViewGroup) itemView.findViewById(R.id.removed_custom_toast));
        toast.setView(view);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
    private void init(){
        //CheckBox
        this.cb_Selected = itemView.findViewById(R.id.cb_Selected);
        //ImageView
        this.iv_Image_cart = itemView.findViewById((R.id.iv_Image_cart));
        this.iv_Color_cart = itemView.findViewById(R.id.iv_Color_cart);
        //TextView
        this.tv_TenSanPham_cart = itemView.findViewById(R.id.tv_TenSanPham_cart);
        this.tv_Size_cart = itemView.findViewById(R.id.tv_Size_cart);
        this.tv_Mau_cart = itemView.findViewById(R.id.tv_Mau_cart);
        this.tv_ThanhTien_cart = itemView.findViewById(R.id.tv_ThanhTien_cart);
        this.tv_SoLuong_cart = itemView.findViewById(R.id.tv_SoLuong_cart);
        //EditText
        this.tv_SoLuong_cart = itemView.findViewById(R.id.tv_SoLuong_cart);
        //Image Button
        this.ib_Edit = itemView.findViewById(R.id.ib_Edit);
        this.ib_Remove = itemView.findViewById(R.id.ib_Remove);
    }
}
