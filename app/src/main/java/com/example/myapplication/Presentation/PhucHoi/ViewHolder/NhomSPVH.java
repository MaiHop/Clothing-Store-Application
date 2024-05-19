package com.example.myapplication.Presentation.PhucHoi.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.NhomSP;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;
//import com.bumptech.glide.Glide;
public class NhomSPVH extends  RecyclerView.ViewHolder{
    public  TextView tenBoloc;
    public  ImageView imageBoloc;
    public NhomSPVH(@NonNull View itemView) {
        super(itemView);
        tenBoloc = itemView.findViewById(R.id.tenBoLoc);
        imageBoloc = itemView.findViewById(R.id.imageBoloc);

    }

    public void bind(NhomSP nhomSP) {
        tenBoloc.setText(nhomSP.getTen());
        Picasso.get().load(nhomSP.getImageURL()).into(imageBoloc);
    }
}
