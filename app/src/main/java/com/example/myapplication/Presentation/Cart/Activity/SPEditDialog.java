package com.example.myapplication.Presentation.Cart.Activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Apdapter.ColorAdapter;
import com.example.myapplication.Presentation.Cart.Apdapter.SizeAdapter;
import com.example.myapplication.Presentation.Cart.Model.DonHangChiTiet;
import com.example.myapplication.Presentation.Cart.Model.KichThuoc;
import com.example.myapplication.Presentation.Cart.Model.Mau;
import com.example.myapplication.Presentation.Cart.Model.SanPham;
import com.example.myapplication.Presentation.Cart.ViewModel.CartVM;
import com.example.myapplication.Presentation.Cart.ViewModel.KichThuocVM;
import com.example.myapplication.Presentation.Cart.ViewModel.MauVM;
import com.example.myapplication.Presentation.Cart.ViewModel.SanPhamVM;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SPEditDialog {
    private Context context;
    private DonHangChiTiet donHangChiTiet;
    private RecyclerView rv_size;
    private Dialog dialog;
    private EditText ed_SoLuongDat;
    private TextView tv_TenSanPham_cart, tv_ThanhTien_cart,tv_SoLuongConLai;
    private Button btn_Giam, btn_Tang, btn_Cancel, btn_Confirm  ;
    private ImageView iv_Image_cart;
    private CartVM cartVM;
    private List<DonHangChiTiet> list;
    private int qty =1;
    private KichThuocVM size_vm;
    private MauVM color_vm;
    private SanPham sp_find;
    public SPEditDialog(Context context, DonHangChiTiet donHangChiTiet, CartVM cartVM) {
        this.context = context;
        this.donHangChiTiet= donHangChiTiet;
        this.cartVM = cartVM;
        this.init_dialog(context,donHangChiTiet);
    }
    public void showEditSanPhamDialog(){
        RecyclerView rv_color =dialog.findViewById(R.id.rv_color);

        rv_color.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        color_vm = new ViewModelProvider((ViewModelStoreOwner) context).get(MauVM.class);
        color_vm.getListMauProductEditLiveData(donHangChiTiet.getSanPham()).observe((LifecycleOwner) context, new Observer<List<Mau>>() {
            @Override
            public void onChanged(List<Mau> maus) {
                ColorAdapter adapter = new ColorAdapter(context, maus, size_vm, new ColorAdapter.ItemClickListener() {
                    @Override
                    public void onItemClick(Mau mau) {
                       if(mau.isAble()){
                           mau.setChecked(true);
                       }
                        sp_find = donHangChiTiet.getSanPham();
                        sp_find.setMau(mau);
                        size_vm.showListSize(sp_find);


                    }
                });
                rv_color.setAdapter(adapter);

            }
        });

        rv_size.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        size_vm = new ViewModelProvider((ViewModelStoreOwner) context).get(KichThuocVM.class);
        size_vm.getListKichThuocLiveData(donHangChiTiet.getSanPham()).observe((LifecycleOwner) context, new Observer<List<KichThuoc>>() {
            @Override
            public void onChanged(List<KichThuoc> kichThuocs) {
                SizeAdapter adapter = new SizeAdapter(context, kichThuocs, new SizeAdapter.ItemClickListener() {
                    @Override
                    public void onItemClick(KichThuoc kichthuoc) {
                        if(kichthuoc.isAble()){
                            kichthuoc.setChecked(true);
                        }
                        sp_find.setKichThuoc(kichthuoc);
                        SanPhamVM sp_vm = new SanPhamVM();
                        sp_find = sp_vm.getSanPham(sp_find);
                        Picasso.get().load(sp_find.getImageUrl()).into(iv_Image_cart);
                        tv_TenSanPham_cart.setText(sp_find.getTenSanPham());
                        tv_SoLuongConLai.setText("Stock : "+sp_find.getSoLuong());
                        ed_SoLuongDat.setText(String.valueOf(donHangChiTiet.getSoLuong()));
                        tv_ThanhTien_cart.setText(String.valueOf(sp_find.getGiaban()*donHangChiTiet.getSoLuong()));
                    }
                });
                rv_size.setAdapter(adapter);
            }

        });

        Picasso.get().load(donHangChiTiet.getSanPham().getImageUrl()).into(iv_Image_cart);
        tv_TenSanPham_cart.setText(donHangChiTiet.getSanPham().getTenSanPham());
        tv_SoLuongConLai.setText("Stock : "+donHangChiTiet.getSanPham().getSoLuong());
        ed_SoLuongDat.setText(String.valueOf(donHangChiTiet.getSoLuong()));
        tv_ThanhTien_cart.setText(String.valueOf(donHangChiTiet.getThanhTien()));
        qty = donHangChiTiet.getSoLuong();
        btn_Giam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qty>1 ){
                    qty-=1;
                    ed_SoLuongDat.setText(String.valueOf(qty));
                    tv_ThanhTien_cart.setText(String.valueOf(qty*donHangChiTiet.getSanPham().getGiaban()));
                }else {
                    qty=1;
                    ed_SoLuongDat.setText(String.valueOf(qty));
                    tv_ThanhTien_cart.setText(String.valueOf(qty*donHangChiTiet.getSanPham().getGiaban()));
                }
            }
        });
        btn_Tang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qty == donHangChiTiet.getSanPham().getSoLuong()) {
                    btn_Tang.setEnabled(false);
                }else {
                    qty+=1;
                    ed_SoLuongDat.setText(String.valueOf(qty));
                    tv_ThanhTien_cart.setText(String.valueOf(qty*donHangChiTiet.getSanPham().getGiaban()));
                }

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
                if(sp_find !=null){
                    donHangChiTiet.setSanPham(sp_find);
                    donHangChiTiet.setThanhTien(sp_find.getGiaban()*donHangChiTiet.getSoLuong());
                }
                donHangChiTiet.setThanhTien(Double.parseDouble(tv_ThanhTien_cart.getText().toString()));
                donHangChiTiet.setSoLuong(Integer.parseInt(ed_SoLuongDat.getText().toString()));

                cartVM.editCart(donHangChiTiet);
                dialog.hide();
            }
        });
    }
    private void init_dialog(Context context, DonHangChiTiet donHangChiTiet){
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.mh_dialog_bottom_cart);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        rv_size =dialog.findViewById(R.id.rv_size);
        ed_SoLuongDat = dialog.findViewById(R.id.ed_SoLuongDat);
        tv_TenSanPham_cart = dialog.findViewById(R.id.tv_TenSanPham_cart);
        tv_ThanhTien_cart = dialog.findViewById(R.id.tv_ThanhTien_cart);
        tv_SoLuongConLai = dialog.findViewById(R.id.tv_SoLuongConLai);
        btn_Giam = dialog.findViewById(R.id.btn_Giam);
        btn_Tang = dialog.findViewById(R.id.btn_Tang);
        btn_Cancel = dialog.findViewById(R.id.btn_Cancel);
        btn_Confirm = dialog.findViewById(R.id.btn_Confirm);
        iv_Image_cart = dialog.findViewById(R.id.iv_Image_cart);
    }
}
