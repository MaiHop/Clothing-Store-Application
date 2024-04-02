package com.example.myapplication.Presentation.Homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class SortListAdapter extends RecyclerView.Adapter<SortListAdapter.Viewholder>{
    private ArrayList<Sort> items;

    private Context context;

    public SortListAdapter(ArrayList<Sort> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public SortListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.sort,parent,false);
        context =parent.getContext();
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SortListAdapter.Viewholder holder, int position) {
        Sort sortlist = items.get(position);
        holder.tiltetxt.setText(sortlist.getTitle());
        holder.radio.setChecked(sortlist.isChecked());
//        holder.radio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                // Cập nhật trạng thái của RadioButton tương ứng trong danh sách dữ liệu
//                sortlist.setChecked(isChecked);
//            }
//        });
        holder.radio.setTag(position);

        // Xóa bất kỳ lắng nghe sự kiện nào trước đó để tránh xử lý sự kiện trùng lặp
        holder.radio.setOnCheckedChangeListener(null);

        // Đặt lắng nghe sự kiện mới cho RadioButton
        holder.radio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Lặp qua danh sách dữ liệu và đặt isChecked của các mục khác thành false
                    for (int i = 0; i < items.size(); i++) {
                        if (i != (int) holder.radio.getTag()) {
                            items.get(i).setChecked(false);
                        }
                    }
                    notifyDataSetChanged(); // Cập nhật lại RecyclerView
                }
                // Cập nhật trạng thái của RadioButton tương ứng trong danh sách dữ liệu
                sortlist.setChecked(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tiltetxt;
        RadioButton radio;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            tiltetxt = itemView.findViewById(R.id.sorttxt);
            radio = itemView.findViewById(R.id.sortradio);
        }
    }
}
