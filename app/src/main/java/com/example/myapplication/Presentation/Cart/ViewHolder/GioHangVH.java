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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Apdapter.ColorAdapter;
import com.example.myapplication.Presentation.Cart.Apdapter.SizeAdapter;
import com.example.myapplication.Presentation.Cart.Model.DonHangChiTiet;
import com.example.myapplication.Presentation.Cart.Model.KichThuoc;
import com.example.myapplication.Presentation.Cart.Model.Mau;
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;
import com.example.myapplication.Presentation.Cart.ViewModel.CartVM;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class GioHangVH extends RecyclerView.ViewHolder {
    public TextView tv_TenSanPham, tv_Size, tv_Mau, tv_SoLuongConLai, tv_ThanhTien,tv_TenSanPham_cart,
            tv_ThanhTien_cart;
    private EditText ed_SoLuongDat;
    public ImageButton ib_Edit, ib_Remove;
    public ImageView iv_Image;
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
//        Picasso.get().load(donHangChiTiet.getSanPham().getImageUrl()).into(iv_Image);
        this.tv_TenSanPham.setText(donHangChiTiet.getSanPham().getTenSanPham());
        this.tv_Size.setText("Size : "+ donHangChiTiet.getSanPham().getKichThuoc());
        this.tv_Mau.setText("Color : "+ donHangChiTiet.getSanPham().getMau());
//        this.tv_SoLuongConLai.setText("Qty :"+ donHangChiTiet.getSoLuong());
        this.tv_ThanhTien.setText("$"+ donHangChiTiet.getThanhTien());
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
    private int qty =1;

    public void show_dialog(Context context, DonHangChiTiet donHangChiTiet){
        init_dialog(context);

        tv_TenSanPham_cart.setText(donHangChiTiet.getSanPham().getTenSanPham());
        tv_SoLuongConLai.setText(donHangChiTiet.getSanPham().getSoLuong());
        ed_SoLuongDat.setText(donHangChiTiet.getSoLuong());
        tv_ThanhTien_cart.setText(String.valueOf(donHangChiTiet.getThanhTien()));
        btn_Giam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qty>1){
                    qty-=1;
                    ed_SoLuongDat.setText(String.valueOf(qty));
                }else {
                    qty=1;
                    ed_SoLuongDat.setText(String.valueOf(qty));
                }
//                Toast.makeText(context, "Trừ", Toast.LENGTH_SHORT).show();
            }
        });
        btn_Tang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qty+=1;
                ed_SoLuongDat.setText(String.valueOf(qty));
//                Toast.makeText(context, "Tăng", Toast.LENGTH_SHORT).show();
            }
        });
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });
        btn_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, qty, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void removeItem(Context context,LayoutInflater layoutInflater) {
        Toast toast = new Toast(context);
        View view = layoutInflater.inflate(R.layout.custom_toast,(ViewGroup) itemView.findViewById(R.id.removed_custom_toast));
        toast.setView(view);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
    private void init_dialog(Context context){
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_bottom_cart);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        CartRepository re = new CartRepository();
        List<KichThuoc> list_size = re.getListSize();
        List<Mau> list_mau = re.getListMau();

        RecyclerView rv_size =dialog.findViewById(R.id.rv_size);

        SizeAdapter sizeAdapter =new SizeAdapter(context, list_size);
        rv_size.setAdapter(sizeAdapter);
        rv_size.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));

        RecyclerView rv_color =dialog.findViewById(R.id.rv_color);

        ColorAdapter colortAdapter =new ColorAdapter(context, list_mau);
        rv_color.setAdapter(colortAdapter);
        rv_color.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));


        ed_SoLuongDat = dialog.findViewById(R.id.ed_SoLuongDat);
        tv_TenSanPham_cart = dialog.findViewById(R.id.tv_TenSanPham_cart);
        tv_ThanhTien_cart = dialog.findViewById(R.id.tv_ThanhTien_cart);
        btn_Giam = dialog.findViewById(R.id.btn_Giam);
        btn_Tang = dialog.findViewById(R.id.btn_Tang);
        btn_Cancel = dialog.findViewById(R.id.btn_Cancel);
        btn_Confirm = dialog.findViewById(R.id.btn_Confirm);
    }
    private void init(){
        //CheckBox
        this.cb_Selected = itemView.findViewById(R.id.cb_Selected);
        //ImageView
        this.iv_Image = itemView.findViewById((R.id.iv_Image_cart));
        //TextView
        this.tv_TenSanPham = itemView.findViewById(R.id.tv_TenSanPham_cart);
        this.tv_Size = itemView.findViewById(R.id.tv_Size_cart);
        this.tv_Mau = itemView.findViewById(R.id.tv_Mau_cart);
        this.tv_SoLuongConLai = itemView.findViewById(R.id.tv_SoLuongConLai);
        this.tv_ThanhTien = itemView.findViewById(R.id.tv_ThanhTien_cart);
        //EditText
        this.ed_SoLuongDat = itemView.findViewById(R.id.ed_SoLuongDat);
        //Image Button
        this.ib_Edit = itemView.findViewById(R.id.ib_Edit);
        this.ib_Remove = itemView.findViewById(R.id.ib_Remove);
    }
}
