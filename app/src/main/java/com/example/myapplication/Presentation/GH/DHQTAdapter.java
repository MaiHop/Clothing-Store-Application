package com.example.myapplication.Presentation.GH;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.DonHangQuaTrinh;
import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class DHQTAdapter extends RecyclerView.Adapter<DHQTAdapter.ViewHolder> {
    private List<DonHangQuaTrinh> orderStatusList;

    public DHQTAdapter(List<DonHangQuaTrinh> orderStatusList) {
        this.orderStatusList = orderStatusList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoi_item_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DonHangQuaTrinh dhqt = orderStatusList.get(position);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(dhqt.getNgay());
        holder.tvDate.setText(formattedDate);
        holder.tvDescription.setText(dhqt.getMoTa());
        holder.tvStatus.setText(dhqt.getTrangThai());

        if (position == 0) { // Assuming the first item is the current status
            holder.statusIndicator.setImageResource(R.drawable.hoi_ic_current_status);
        } else {
            holder.statusIndicator.setImageResource(R.drawable.hoi_ic_past_status);
        }
    }

    @Override
    public int getItemCount() {
        return orderStatusList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvDescription, tvStatus,tvTime;
        ImageView statusIndicator;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.od_ngay);
            tvDescription = itemView.findViewById(R.id.od_mota);
//            tvTime = itemView.findViewById(R.id.od_time);
            tvStatus = itemView.findViewById(R.id.od_trangthai);
            statusIndicator = itemView.findViewById(R.id.statusIndicator);
        }
    }
}

