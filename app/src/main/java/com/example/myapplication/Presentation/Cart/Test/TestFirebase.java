package com.example.myapplication.Presentation.Cart.Test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.Domain.Model.KieuSP;
import com.example.myapplication.Presentation.Cart.ViewModel.CartVM;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TestFirebase extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_firebase);

        KieuSP_ViewModel kieuSPViewModel = new ViewModelProvider(this).get(KieuSP_ViewModel.class);
        kieuSPViewModel.getListCartLiveData().observe(this, new Observer<List<KieuSP>>() {
            @Override
            public void onChanged(List<KieuSP> kieuSPS) {
                Log.d("KieuSP", String.valueOf(kieuSPS.size()));
            }
        });

        KieuSP sp = kieuSPViewModel.getKieuSPbyId("1");
        Log.d("KieuSP", sp.getTen());



    }


}