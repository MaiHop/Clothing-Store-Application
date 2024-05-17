package com.example.myapplication.Presentation.GH;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.DonHangQuaTrinh;
import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class DonHangChiTietAdapter extends RecyclerView.Adapter<DonHangChiTietAdapter.ViewHolder> {
    private List<DonHangQuaTrinh> orderStatusList;

    public DonHangChiTietAdapter(List<DonHangQuaTrinh> orderStatusList) {
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
    }

    @Override
    public int getItemCount() {
        return orderStatusList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvDescription, tvStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.od_ngay);
            tvDescription = itemView.findViewById(R.id.od_mota);
            tvStatus = itemView.findViewById(R.id.od_trangthai);
        }
    }
}
