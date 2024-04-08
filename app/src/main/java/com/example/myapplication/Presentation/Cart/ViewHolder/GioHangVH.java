package com.example.myapplication.Presentation.Cart.ViewHolder;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
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
import com.example.myapplication.Presentation.Cart.Model.Cart;
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;
import com.example.myapplication.R;

import java.util.List;

public class GioHangVH extends RecyclerView.ViewHolder {
    public TextView tv_TenSanPham, tv_Size, tv_Mau, tv_SoLuong, tv_ThanhTien;
    public ImageButton ib_Edit, ib_Remove;
    public ImageView iv_Image;
    public CheckBox cb_Selected;
    public ConstraintLayout layout_item_cart;
    public GioHangVH(@NonNull View itemView) {
        super(itemView);

        //CheckBox
        this.cb_Selected = itemView.findViewById(R.id.cb_Selected);
        //ImageView
        this.iv_Image = itemView.findViewById((R.id.iv_Image_cart));
        //TextView
        this.tv_TenSanPham = itemView.findViewById(R.id.tv_TenSanPham_cart);
        this.tv_Size = itemView.findViewById(R.id.tv_Size_cart);
        this.tv_Mau = itemView.findViewById(R.id.tv_Mau_cart);
        this.tv_SoLuong = itemView.findViewById(R.id.tv_SoLuong_cart);
        this.tv_ThanhTien = itemView.findViewById(R.id.tv_ThanhTien_cart);
        //Image Button
        this.ib_Edit = itemView.findViewById(R.id.ib_Edit);

        this.ib_Remove = itemView.findViewById(R.id.ib_Remove);
//        this.layout_item_cart = itemView.findViewById(R.id.layout_item_cart);
//        this.layout_item_cart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onClick
//            }
//        });
        //Button



    }



    public void updateUI(Cart cart){
        this.iv_Image.setImageResource(cart.getImage());
        this.tv_TenSanPham.setText(cart.getTenSanPham());
        this.tv_Size.setText("Size : "+cart.getSize());
        this.tv_Mau.setText("Color : "+cart.getMau());
        this.tv_SoLuong.setText("Qty :"+cart.getSoLuong());
        this.tv_ThanhTien.setText("$"+cart.getThanhTien());
        this.cb_Selected.setSelected(cart.isChecked());
    }

    public void updateTotal(List<Cart> list,Button button){
        double total = 0;
        int count =0;
        for(Cart cart : list){
            if(cart.isChecked()){
                total += cart.getThanhTien();
                count++;
            }
        }
        button.setText("Checkout ("+count+") - "+"$"+total);
    }
    private int qty =1;
    public void showdialog(Context context){

        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_bottom_cart);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        CartRepository re = new CartRepository();
        List<String> list = re.getListSize();

        RecyclerView rv_size =dialog.findViewById(R.id.rv_size);

        SizeAdapter sizeAdapter =new SizeAdapter(context, list);
        rv_size.setAdapter(sizeAdapter);
        rv_size.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));

        RecyclerView rv_color =dialog.findViewById(R.id.rv_color);

        ColorAdapter colortAdapter =new ColorAdapter(context, list);
        rv_color.setAdapter(colortAdapter);
        rv_color.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));


        TextView tv_SoLuongDat = dialog.findViewById(R.id.tv_SoLuongDat);
        Button btn_Giam = dialog.findViewById(R.id.btn_Giam);
        Button btn_Tang = dialog.findViewById(R.id.btn_Tang);
        Button btn_Cancel = dialog.findViewById(R.id.btn_Cancel);
        Button btn_Confirm = dialog.findViewById(R.id.btn_Confirm);
        btn_Giam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qty>1){
                    qty-=1;
                    tv_SoLuongDat.setText(String.valueOf(qty));
                }else {
                    qty=1;
                    tv_SoLuongDat.setText(String.valueOf(qty));
                }
//                Toast.makeText(context, "Trừ", Toast.LENGTH_SHORT).show();
            }
        });
        btn_Tang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qty+=1;
                tv_SoLuongDat.setText(String.valueOf(qty));
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
        //                Toast.makeText(context,"Removed form Cart!", Toast.LENGTH_SHORT).show();
    }
}
