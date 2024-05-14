package com.example.myapplication.Presentation.PhucHoi.Apdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.SanPham;
import com.example.myapplication.Presentation.PhucHoi.Activity.ChiTietSanPhamActivity;

import com.example.myapplication.Presentation.PhucHoi.ViewHolder.SanPhamVH;
import com.example.myapplication.R;

import java.util.List;
public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamVH> {
    private List<SanPham> list_product;


    private Context context;

    private LayoutInflater minflater;

    public SanPhamAdapter(List<SanPham> list_product, Context context, LayoutInflater minflater) {
        this.list_product = list_product;
        this.context = context;
        this.minflater = minflater;

    }

    @NonNull
    @Override
    public SanPhamVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoi_item_product, parent, false);
        return new SanPhamVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamVH holder, int position) {
        SanPham product = list_product.get(position);
        holder.bind(product);
        // Xử lý sự kiện khi người dùng nhấn vào sản phẩm
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang màn hình chi tiết sản phẩm
                Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
                intent.putExtra("product", product); // Truyền dữ liệu sản phẩm qua Intent
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return list_product.size();
    }



    public void setListProduct(List<SanPham> productList) {
        this.list_product = productList;
        notifyDataSetChanged(); // Thông báo cho RecyclerView biết là danh sách đã thay đổi
    }
    public void updateList(List<SanPham> sanPhamList) {
        this.list_product = sanPhamList;
        notifyDataSetChanged();
    }
    public List<SanPham> getListProduct() {
        return list_product;
    }
}
