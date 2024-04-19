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
import android.widget.Toast;

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
import com.example.myapplication.Presentation.Cart.Repository.CartRepository;
import com.example.myapplication.Presentation.Cart.ViewModel.CartVM;
import com.example.myapplication.Presentation.Cart.ViewModel.KichThuocVM;
import com.example.myapplication.Presentation.Cart.ViewModel.MauVM;
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
    public SPEditDialog(Context context, DonHangChiTiet donHangChiTiet, CartVM cartVM) {
        this.context = context;
        this.donHangChiTiet= donHangChiTiet;
        this.cartVM = cartVM;
        this.init_dialog(context,donHangChiTiet);
    }
    public void showEditSanPhamDialog(){
        rv_size.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        KichThuocVM size_vm = new ViewModelProvider((ViewModelStoreOwner) context).get(KichThuocVM.class);
        size_vm.getListKichThuocLiveData().observe((LifecycleOwner) context, new Observer<List<KichThuoc>>() {
            @Override
            public void onChanged(List<KichThuoc> kichThuocs) {
                for(int i =0; i<kichThuocs.size(); i++){
                    KichThuoc kt = kichThuocs.get(i);
                    if(kt.getId().equals(donHangChiTiet.getSanPham().getKichThuoc().getId())){
                        kt.setChecked(true);
                        kichThuocs.set(i,kt);
                    }
                }
                SizeAdapter adapter = new SizeAdapter(context, kichThuocs);
                rv_size.setAdapter(adapter);
            }
        });

        RecyclerView rv_color =dialog.findViewById(R.id.rv_color);

        rv_color.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        MauVM color_vm = new ViewModelProvider((ViewModelStoreOwner) context).get(MauVM.class);
        color_vm.getListMauLiveData().observe((LifecycleOwner) context, new Observer<List<Mau>>() {
            @Override
            public void onChanged(List<Mau> maus) {
                CartRepository res = new CartRepository();
                List<DonHangChiTiet> list = res.getGioHang();
                for(int i =0; i<maus.size(); i++){
                    Mau m = maus.get(i);
                    if(m.getId().equals(donHangChiTiet.getSanPham().getMau().getId())){
                        m.setChecked(true);
                        maus.set(i,m);
                    }
                }
                for(DonHangChiTiet dh : list){
                    for(Mau m : maus){
                        if(dh.getSanPham().getTenSanPham().equals(donHangChiTiet.getSanPham().getTenSanPham()) ){
                            if(dh.getSanPham().getMau().getId().equals(m.getId())){
                                m.setAble(false);
                            }
                            if(m.getId().equals(donHangChiTiet.getSanPham().getMau().getId())){
                                m.setAble(true);
                            }
                        }
                    }
                }

                ColorAdapter adapter = new ColorAdapter(context, maus, size_vm, donHangChiTiet.getSanPham());
                rv_color.setAdapter(adapter);
            }
        });

        Picasso.get().load(donHangChiTiet.getSanPham().getImageUrl()).into(iv_Image_cart);
        tv_TenSanPham_cart.setText(donHangChiTiet.getSanPham().getTenSanPham());
        tv_SoLuongConLai.setText("Stock : "+donHangChiTiet.getSanPham().getSoLuong());
        ed_SoLuongDat.setText(String.valueOf(donHangChiTiet.getSoLuong()));
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
                cartVM.addCart();
//                CartRepository res = new CartRepository();
//                List<SanPham> listsp = res.getSanPham();
//                DonHangChiTiet donHangChiTiet1 = new DonHangChiTiet();
//                DonHangChiTiet dh1 = new DonHangChiTiet();
//                dh1.setIdDonHang("cc");
//                dh1.setSanPham(listsp.get(4));
//                dh1.setSoLuong(1);
//                dh1.setThanhTien(listsp.get(0).getGiaban()*dh1.getSoLuong());
//                dh1.setThanhTienKhuyenMai(0);
//                dh1.setChecked(true);
//                list.add(donHangChiTiet1);

//                Toast.makeText(context, "qty", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void init_dialog(Context context, DonHangChiTiet donHangChiTiet){
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_bottom_cart);
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
