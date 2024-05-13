package com.example.myapplication.Presentation.PhucHoi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.Domain.Model.SanPham;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        List<SanPham> list = new ArrayList<>();
        FirebaseFirestore.getInstance().collection("SanPham").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> list_doc = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot doc : list_doc) {
                        SanPham sp = doc.toObject(SanPham.class);
                        sp.setId(doc.getId());
                        list.add(sp);
                    }
                }
                Log.d("Test", String.valueOf(list.size()));
            }
        });
    }
}