package com.example.myapplication.Presentation.Homepage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Homepage.DTO.Products;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.Viewholder> {
    private  ArrayList<Products> items;

    private  Context context;

    public ProductListAdapter(ArrayList<Products> items) {
        this.items = items;
        this.context = context;
    }


    @NonNull
    @Override
    public ProductListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoi_item_product,parent,false);
        context =parent.getContext();

        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.Viewholder holder, int position) {
//        holder.tiltetxt.setText(items.get(position).getTilte());
//        holder.pricetxt.setText(items.get(position).getPrice());
//        holder.scoretxt.setText(items.get(position).getCore());
//        holder.pic.setImageResource(sanPhamWishList.getHinh());
        Products productlist = items.get(position);
        holder.tiltetxt.setText(productlist.getTilte());
        holder.pricetxt.setText("$"+ productlist.getPrice());
        holder.scoretxt.setText(productlist.getCore());
        holder.pic.setImageResource(productlist.getPicture());




    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class Viewholder  extends  RecyclerView.ViewHolder{
        TextView tiltetxt,scoretxt,pricetxt;
        ImageView pic;

        public Viewholder(@NonNull View itemView) {

            super(itemView);
            tiltetxt = itemView.findViewById(R.id.titletxt);
            scoretxt = itemView.findViewById(R.id.scoretxt);
            pricetxt = itemView.findViewById(R.id.pricetxt);
            pic = itemView.findViewById((R.id.imgproduct));
        }
    }
}
