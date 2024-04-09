package com.example.myapplication.Presentation.Homepage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Homepage.DTO.Boloc;
import com.example.myapplication.Presentation.Homepage.DTO.Size;
import com.example.myapplication.R;

import java.util.ArrayList;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.ViewHolder>{
    private ArrayList<Size> itemsSize;
    public SizeAdapter (ArrayList<Size> items){
        this.itemsSize = items;
    }
    @NonNull
    @Override
    public SizeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_size, parent, false);
        return new SizeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SizeAdapter.ViewHolder holder, int position) {
        Size size = itemsSize.get(holder.getAdapterPosition()); // Sử dụng holder.getAdapterPosition() để lấy vị trí item hiện tại

        holder.titlesize.setText(size.getSize());

        // Xác định trạng thái của item và thiết lập nền tương ứng
        if (size.isSelected()) {
            holder.titlesize.setBackgroundResource(R.drawable.item_size_selecter); // Đổi thành drawable đã chọn
        } else {
            holder.titlesize.setBackgroundResource(R.drawable.item_size_defaut); // Đổi về drawable mặc định
        }

        // Xử lý sự kiện click để chuyển đổi trạng thái của item khi được chọn
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    // Đảo ngược trạng thái của item khi được click
                    Size clickedSize = itemsSize.get(adapterPosition);
                    clickedSize.setSelected(!clickedSize.isSelected());

                    // Cập nhật lại giao diện sau khi thay đổi trạng thái
                    notifyItemChanged(adapterPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsSize.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titlesize;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titlesize = itemView.findViewById(R.id.tenSize);

        }
    }
}
