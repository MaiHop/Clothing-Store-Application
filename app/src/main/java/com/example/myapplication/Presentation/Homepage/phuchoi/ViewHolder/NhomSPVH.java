package com.example.myapplication.Presentation.Homepage.phuchoi.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Homepage.phuchoi.Model.NhomSP;
import com.example.myapplication.R;

public class NhomSPVH extends  RecyclerView.ViewHolder{
    private TextView tenBoloc;
    public NhomSPVH(@NonNull View itemView) {
        super(itemView);
        tenBoloc = itemView.findViewById(R.id.tenBoLoc);

    }

    public void bind(NhomSP nhomSP) {
        tenBoloc.setText(nhomSP.getTen());
    }
}
