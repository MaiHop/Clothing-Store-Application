package com.example.myapplication.Presentation.Homepage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Homepage.DTO.Boloc;
import com.example.myapplication.R;

import java.util.ArrayList;

public class BoclocAdapter extends RecyclerView.Adapter<BoclocAdapter.ViewHolder> {
    private ArrayList<Boloc> itemsBoloc;

    public BoclocAdapter(ArrayList<Boloc> items) {
        this.itemsBoloc = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.hoi_item_boloc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Boloc boloc = itemsBoloc.get(position);
        holder.titleboloc.setText(boloc.getTilte());



    }

    @Override
    public int getItemCount() {
        return itemsBoloc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleboloc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleboloc = itemView.findViewById(R.id.tenBoLoc);

        }
    }
}
