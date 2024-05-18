package com.example.myapplication.Presentation.GH;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.SimpleDateFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.DonHang;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdaptor extends RecyclerView.Adapter<ItemAdaptor.Viewholder> {
    private List<DonHang> item;
    private ArrayList<DonHang> itemsFull;
    private Context context;

    public ItemAdaptor(Context context, List<DonHang> item) {
        this.item = item;
        this.context = context;
        this.itemsFull = new ArrayList<>(item);
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        context = parent.getContext();
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdaptor.Viewholder holder, int position) {
        DonHang donHang = item.get(position);

        holder.tiltetxt.setText(donHang.getListDonHangChiTiet().get(0).getSanPham().getTenSanPham());
        holder.pricetxt.setText("$" + donHang.getListDonHangChiTiet().get(0).getSanPham().getGiaban());
        holder.datetxt.setText(new SimpleDateFormat("dd/MM/yyyy").format(donHang.getNgayThanhToan()));

//        Picasso.get().load(donHang.getListDonHangChiTiet().get(0).getSanPham().getImageUrl()).into(pic);

        holder.imageView3cham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
        holder.btnTOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FragmentTab.class);
                intent.putExtra("DONHANG", donHang);
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

    public Filter getFilter() {
        return itemFilter;
    }

    private Filter itemFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<DonHang> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(itemsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (DonHang donHang : itemsFull) {
                    // Tìm kiếm theo tên sản phẩm
                    if (donHang.getListDonHangChiTiet().get(0).getSanPham().getTenSanPham().toLowerCase().contains(filterPattern)) {
                        filteredList.add(donHang);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            item.clear();
            item.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

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