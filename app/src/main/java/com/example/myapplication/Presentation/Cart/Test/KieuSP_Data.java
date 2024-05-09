package com.example.myapplication.Presentation.Cart.Test;

import com.example.myapplication.Domain.Model.KieuSP;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class KieuSP_Data {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<KieuSP> list_kieu = new ArrayList<>();
    KieuSP kieuSP ;
    OnKieuSPAvaiableInFirestore onKieuSPAvaiableInFirestore;
    public KieuSP_Data(OnKieuSPAvaiableInFirestore onKieuSPAvaiableInFirestore) {
        this.onKieuSPAvaiableInFirestore = onKieuSPAvaiableInFirestore;
    }

    public void readListKieuSP(){
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

    public void getKieuSanPham(String id){
        kieuSP = new KieuSP();
        db.collection("KieuSanPham").document(id).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot != null){
                            kieuSP.setId(documentSnapshot.getId());
                            kieuSP.setTen(documentSnapshot.getString("Ten"));
                        }
                        onKieuSPAvaiableInFirestore.getKieuSP(kieuSP);
                    }
                });
    }
    public interface OnKieuSPAvaiableInFirestore {
        void getListKieuSP(List<KieuSP> list);
        void getKieuSP(KieuSP kieusp);
    }
}
