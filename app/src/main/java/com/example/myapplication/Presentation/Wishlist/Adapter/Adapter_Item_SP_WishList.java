package com.example.myapplication.Presentation.Wishlist.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model2.SanPham;
import com.example.myapplication.Presentation.PhucHoi.Activity.ChiTietSanPhamActivity;
import com.example.myapplication.Presentation.Wishlist.ViewHolder.WishListVH;
import com.example.myapplication.Presentation.Wishlist.ViewModel.YeuThichVM;
import com.example.myapplication.R;
import com.example.myapplication.SharedPreferences.DataLocalManager;
import com.example.myapplication.UI.MainActivity;

import java.util.List;

public class Adapter_Item_SP_WishList extends RecyclerView.Adapter<WishListVH>   {

    private Context context;
    private int layout;
    private LayoutInflater minflater;
    private List<SanPham> arr_item_SP_WL;
    private SanPham sanPham;
    private YeuThichVM wishlishVM;

    private TextView title;


    public Adapter_Item_SP_WishList(Context context, List<SanPham> arr_item_SP_WL, TextView title,YeuThichVM wishlishVM) {
        this.context = context;
        this.minflater = LayoutInflater.from(context);
        this.title = title;
        this.arr_item_SP_WL = arr_item_SP_WL;
        this.wishlishVM = wishlishVM;
    }

    @NonNull
    @Override
    public WishListVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.c_hung_item_sp_wishlist,parent,false
        );
        return new WishListVH(itemView);
    }
    @Override
    public int getItemCount() {
        return arr_item_SP_WL.size();
    }

    @Override
    public void onBindViewHolder(@NonNull WishListVH holder, int position) {
        SanPham sanPham =  arr_item_SP_WL.get(position);
        title.setText("Wishlist("+arr_item_SP_WL.size()+")");
        holder.updateUI(sanPham);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang màn hình chi tiết sản phẩm
                Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
                intent.putExtra("product", sanPham); // Truyền dữ liệu sản phẩm qua Intent
                context.startActivity(intent);
            }
        });
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(minflater.getContext(), "ID: "+ DataLocalManager.getUser().getTen(), Toast.LENGTH_SHORT).show();
                arr_item_SP_WL.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(),arr_item_SP_WL.size());
//                holder.removeItem(context,minflater);
                title.setText("Wishlist("+arr_item_SP_WL.size()+")");
            }
        });
    }



//    public void setListProductWish(List<SanPham> productList) {
//        this.arr_item_SP_WL = productList;
//        notifyDataSetChanged(); // Thông báo cho RecyclerView biết là danh sách đã thay đổi
//    }
}
