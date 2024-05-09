package com.example.myapplication.Presentation.Cart.Test;

import com.example.myapplication.Domain.Model.KieuSP;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class KieuSP_option2 {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<KieuSP> list_kieu = new ArrayList<>();



    public List<KieuSP> returnListKieuSP(List<KieuSP> list_test){
        readListKieuSP(new OnKieuSPAvaiableInFirestore() {
            @Override
            public void getListKieuSP(List<KieuSP> list) {
                returnListKieuSP(list);

            }
        });
        return list_test;
    }

    public void readListKieuSP(OnKieuSPAvaiableInFirestore onKieuSPAvaiableInFirestore){
        list_kieu.clear();
        db.collection("KieuSanPham").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if(!queryDocumentSnapshots.isEmpty()){
                            if(!queryDocumentSnapshots.isEmpty()){
                                List<DocumentSnapshot> list_doc = queryDocumentSnapshots.getDocuments();
                                for(DocumentSnapshot doc : list_doc){
                                    KieuSP kieu = new com.example.myapplication.Domain.Model.KieuSP();
                                    kieu.setId(doc.getId());
                                    kieu.setTen(doc.getString("Ten"));
                                    list_kieu.add(kieu);
                                }
                            }
                        }
                        onKieuSPAvaiableInFirestore.getListKieuSP(list_kieu);
                    }
                });
    }

    public interface OnKieuSPAvaiableInFirestore {
        void getListKieuSP(List<KieuSP> list);
    }
}
