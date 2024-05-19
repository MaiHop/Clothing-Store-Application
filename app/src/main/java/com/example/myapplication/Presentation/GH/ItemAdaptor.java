package com.example.myapplication.Presentation.GH;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.SimpleDateFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.DonHang;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ItemAdaptor extends RecyclerView.Adapter<ItemAdaptor.Viewholder> implements Filterable {
    private List<DonHang> items;
    private List<DonHang> itemsFull;
    private Context context;

    public ItemAdaptor(Context context, List<DonHang> items) {
        this.items = items;
        this.context = context;
        this.itemsFull = new ArrayList<>(items);
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        DonHang donHang = items.get(position);

        holder.titleText.setText(donHang.getListDonHangChiTiet().get(0).getSanPham().getTenSanPham());
        holder.priceText.setText("$" + donHang.getListDonHangChiTiet().get(0).getSanPham().getGiaban());
        holder.dateText.setText(new SimpleDateFormat("dd/MM/yyyy").format(donHang.getNgayThanhToan()));

        Picasso.get().load(donHang.getListDonHangChiTiet().get(0).getSanPham().getImageUrl()).into(holder.pic);

        holder.menuButton.setOnClickListener(v -> showPopupMenu(v, holder.getAdapterPosition()));
        holder.orderButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, FragmentTab.class);
            intent.putExtra("DONHANG", donHang);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView titleText, dateText, priceText;
        ImageView pic, menuButton;
        Button orderButton;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.datetxt);
            titleText = itemView.findViewById(R.id.titletxt);
            priceText = itemView.findViewById(R.id.pricetxt);
            pic = itemView.findViewById((R.id.pic));
            menuButton = itemView.findViewById(R.id.imageView3cham);
            orderButton = itemView.findViewById(R.id.btnTOrder);
        }
    }

    @Override
    public Filter getFilter() {
        return itemFilter;
    }

    private final Filter itemFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<DonHang> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(itemsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (DonHang donHang : itemsFull) {
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
            items.clear();
            items.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    private void showPopupMenu(View view, int position) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        popupMenu.getMenuInflater().inflate(R.menu.cancel_order, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.menu_cancel_order) {
                showCancelOrderDialog(view.getContext());
                return true;
            }
            return false;
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
        noButton.setOnClickListener(v -> dialog.dismiss());

        Button yesButton = dialog.findViewById(R.id.buttonyes);
        yesButton.setOnClickListener(v -> {
            dialog.dismiss();
            showYes(context);
        });
        dialog.show();
    }

    private void showYes(Context context) {
        final Dialog successDialog = new Dialog(context);
        successDialog.setContentView(R.layout.cancel_success);

        Window window = successDialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setGravity(Gravity.BOTTOM);
            window.getAttributes().windowAnimations = R.style.DialogAnimation;
        }

        new android.os.Handler().postDelayed(() -> successDialog.dismiss(), 2000);
        successDialog.show();
    }

    public void updateList(List<DonHang> newList) {
        items = newList;
        itemsFull = new ArrayList<>(newList);
        notifyDataSetChanged();
    }
}
