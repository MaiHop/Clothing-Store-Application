package com.example.myapplication.Presentation.Homepage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Homepage.DTO.Sort;
import com.example.myapplication.R;

import java.util.ArrayList;

public class SortListAdapter extends RecyclerView.Adapter<SortListAdapter.ViewHolder> {
    private ArrayList<Sort> itemsSort;

    public SortListAdapter(ArrayList<Sort> items) {
        this.itemsSort = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.sort, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sort sort = itemsSort.get(position);
        holder.titleTextView.setText(sort.getTitle());
        holder.radioButton.setChecked(sort.isChecked());

        holder.radioButton.setOnCheckedChangeListener(null); // Xóa lắng nghe sự kiện trước đó

        holder.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Thiết lập isChecked của mục được chọn thành true
                    for (Sort item : itemsSort) {
                        item.setChecked(item == sort); // Đặt isChecked của mục tương ứng
                    }
                    notifyDataSetChanged(); // Cập nhật lại RecyclerView
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsSort.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        RadioButton radioButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.sorttxt);
            radioButton = itemView.findViewById(R.id.sortradio);
        }
    }
}
