//package com.example.myapplication.Presentation.GH;
//
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.myapplication.Model.DonHangQuaTrinh;
//import com.example.myapplication.R;
//
//import java.text.SimpleDateFormat;
//import java.util.Locale;
//
//public class DonHangChiTietVH extends RecyclerView.ViewHolder {
//    TextView orderStatus, orderDate, orderTime, orderDescription;
//    ImageView statusIndicator;
//
//    public DonHangChiTietVH(@NonNull View itemView) {
//        super(itemView);
//        orderStatus = itemView.findViewById(R.id.od_trangthai);
//        orderDate = itemView.findViewById(R.id.od_ngay);
//        orderTime = itemView.findViewById(R.id.orderTime);
//        orderDescription = itemView.findViewById(R.id.od_mota);
//        statusIndicator = itemView.findViewById(R.id.statusIndicator);
//    }
//
//    public void bind(DonHangQuaTrinh orderStatus, boolean isFirstItem) {
//        this.orderStatus.setText(orderStatus.getTrangThai());
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
//        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
//
//        String date = dateFormat.format(orderStatus.getNgay());
//        String time = timeFormat.format(orderStatus.getNgay());
//
//        this.orderDate.setText(date);
//        this.orderTime.setText(time);
//        this.orderDescription.setText(orderStatus.getMoTa());
//
//        if (isFirstItem) { // Assuming the first item is the current status
//            this.statusIndicator.setImageResource(R.drawable.hoi_ic_current_status);
//        } else {
//            this.statusIndicator.setImageResource(R.drawable.hoi_ic_past_status);
//        }
//    }
//}