package com.example.myapplication.UI.GH;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ItemAdaptor extends RecyclerView.Adapter<ItemAdaptor.Viewholder> {
    private ArrayList<ItemDomain> item;
    private Context context;
    public ItemAdaptor(ArrayList<ItemDomain> item) {
        this.item = item;
        this.context = context;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        context =parent.getContext();
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        ItemDomain itemlist = item.get(position);
        holder.tiltetxt.setText(itemlist.getTitle());
        holder.pricetxt.setText("$"+ itemlist.getPrice());
        holder.datetxt.setText(itemlist.getDate());
        holder.pic.setImageResource(itemlist.getPic());

//        holder.imageView3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showPopupMenu(v);
//            }
//        });

    }
    @Override
    public int getItemCount() {
        return item.size();
    }

    public class Viewholder  extends  RecyclerView.ViewHolder{
        TextView tiltetxt,datetxt,pricetxt;
        ImageView pic,imageView3;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            datetxt = itemView.findViewById(R.id.datetxt);
            tiltetxt = itemView.findViewById(R.id.titletxt);
            pricetxt = itemView.findViewById(R.id.pricetxt);
            pic = itemView.findViewById((R.id.pic));
//            imageView3 = itemView.findViewById(R.id.imageView3);
        }
    }
//    private void showPopupMenu(View view) {
//        PopupMenu popupMenu = new PopupMenu(context, view);
//        popupMenu.getMenuInflater().inflate(R.menu.cancel_order, popupMenu.getMenu());
//        popupMenu.show();
//    }


}

