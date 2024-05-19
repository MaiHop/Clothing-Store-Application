package com.example.myapplication.Presentation.PhucHoi.ViewHolder;

import androidx.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.KieuSP;
import com.example.myapplication.Model.NhomSP;
import com.example.myapplication.R;
public class KieuSPVH extends RecyclerView.ViewHolder {

    public  TextView tenkieuSP;
    public KieuSPVH(@NonNull View itemView) {
        super(itemView);
        tenkieuSP = itemView.findViewById(R.id.tenkieusp);


    }

    public void bind(KieuSP kieuSP) {
        tenkieuSP.setText(kieuSP.getTen());
    }


}
