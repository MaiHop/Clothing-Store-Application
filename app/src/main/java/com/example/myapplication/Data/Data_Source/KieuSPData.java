package com.example.myapplication.Data.Data_Source;

import android.util.Log;

import com.example.myapplication.Domain.Model.KieuSP;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class KieuSPData {

    public List<KieuSP> getListKieuSP(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        List<KieuSP> list = new ArrayList<>();
        db.collection("KieuSanPham").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if(!queryDocumentSnapshots.isEmpty()){
                            if(!queryDocumentSnapshots.isEmpty()){
                                List<DocumentSnapshot> list_doc = queryDocumentSnapshots.getDocuments();
                                for(DocumentSnapshot doc : list_doc){
                                    KieuSP kieu = new KieuSP();
                                    kieu.setId(doc.getId());
                                    kieu.setTen(doc.getString("Ten"));
                                    list.add(kieu);
                                }
                            }
                        }

                    }
                });
        return list;
    }
    public Task<KieuSP> getKieuSanPhamById(String id){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("KieuSanPham").document(id);

        return docRef.get().continueWith(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    KieuSP kieu = new KieuSP();
                    kieu.setId(document.getId());
                    kieu.setTen(document.getString("Ten"));
                    // Gán các thuộc tính khác của kieu ở đây (nếu có)
                    return kieu;
                } else {
                    // Xử lý trường hợp không tìm thấy dữ liệu
                    return null;
                }
            } else {
                // Xử lý trường hợp lỗi
                return null;
            }
        });
    }


}
