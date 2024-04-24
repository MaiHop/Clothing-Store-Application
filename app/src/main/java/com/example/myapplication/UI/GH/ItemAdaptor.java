package com.example.myapplication.UI.GH;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ItemAdaptor extends RecyclerView.Adapter<ItemAdaptor.Viewholder> {
    private ArrayList<ItemDomain> item;
    private Context context;

    public ItemAdaptor(Context context, ArrayList<ItemDomain> item) {
        this.item = item;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        context = parent.getContext();
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        ItemDomain itemlist = item.get(position);
        holder.tiltetxt.setText(itemlist.getTitle());
        holder.pricetxt.setText("$" + itemlist.getPrice());
        holder.datetxt.setText(itemlist.getDate());
        holder.pic.setImageResource(itemlist.getPic());

        holder.imageView3cham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
        holder.btnTOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tiltetxt, datetxt, pricetxt;
        ImageView pic, imageView3cham;
        Button btnTOrder;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            datetxt = itemView.findViewById(R.id.datetxt);
            tiltetxt = itemView.findViewById(R.id.titletxt);
            pricetxt = itemView.findViewById(R.id.pricetxt);
            pic = itemView.findViewById((R.id.pic));
            imageView3cham = itemView.findViewById(R.id.imageView3cham);
            btnTOrder = itemView.findViewById(R.id.btnTOrder);
        }
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        popupMenu.getMenuInflater().inflate(R.menu.cancel_order, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_cancel_order) {
                    showCancelOrderDialog(view.getContext());
                    return true;
                }
                return false;
            }
        });

        popupMenu.show();
    }

    private void showCancelOrderDialog(Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_cancel_order);

        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.getAttributes().windowAnimations = R.style.DialogAnimation;
            window.setGravity(Gravity.BOTTOM);
        }

        Button noButton = dialog.findViewById(R.id.buttonno);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // Đóng dialog
            }
        });

        Button yesButton = dialog.findViewById(R.id.buttonyes);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                showYes(context);
            }
        });
        dialog.show();
    }
    private void showYes(Context context) {
        final Dialog successDialog = new Dialog(context);
        successDialog.setContentView(R.layout.cancel_success);

        // Đặt các thuộc tính cho window của dialog mới, giống như bạn đã làm cho dialog hủy đơn
        Window window = successDialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setGravity(Gravity.BOTTOM);
            window.getAttributes().windowAnimations = R.style.DialogAnimation;
        }

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                successDialog.dismiss();
            }
        }, 2000); // Đóng dialog sau 2 giây

        successDialog.show();
    }
}


