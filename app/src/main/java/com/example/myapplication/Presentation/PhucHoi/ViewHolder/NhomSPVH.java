package com.example.myapplication.Presentation.PhucHoi.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Domain.Model.NhomSP;
import com.example.myapplication.R;

public class NhomSPVH extends  RecyclerView.ViewHolder{
    public  TextView tenBoloc;
    public NhomSPVH(@NonNull View itemView) {
        super(itemView);
        tenBoloc = itemView.findViewById(R.id.tenBoLoc);

    }

    public void bind(NhomSP nhomSP) {
        tenBoloc.setText(nhomSP.getTen());
    }
}
