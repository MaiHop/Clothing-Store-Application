package com.example.myapplication.Presentation.Cart.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Presentation.Cart.Apdapter.CartAdapter;
import com.example.myapplication.Domain.Model.DonHang;
import com.example.myapplication.Domain.Model.DonHangChiTiet;
import com.example.myapplication.Presentation.Cart.ViewModel.GioHangVM;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class GioHangActivity extends AppCompatActivity {
    private RecyclerView rv_ListCart;
    private Button btn_DatHang;
    private TextView toolbar_title;
    private Toolbar toolbar_cart;
    private List<DonHangChiTiet> list;
    private GioHangVM gioHangVM;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mh_activity_cart);

        init();
        this.rv_ListCart =findViewById(R.id.rv_ListCart);

        this.rv_ListCart.setLayoutManager(new LinearLayoutManager(this));
        gioHangVM = new ViewModelProvider(this).get(GioHangVM.class);
        gioHangVM.getListCartLiveData().observe(this, new Observer<List<DonHangChiTiet>>() {
            @Override
            public void onChanged(List<DonHangChiTiet> donHangChiTiets) {
                list= donHangChiTiets;
                CartAdapter adapter = new CartAdapter(GioHangActivity.this, donHangChiTiets, btn_DatHang, toolbar_title, gioHangVM);
                rv_ListCart.setAdapter(adapter);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mh_menu_toolbar_cart, menu);
        searchView = (SearchView) menu.findItem(R.id.item_search_cart).getActionView();
        searchView.setQueryHint("Nhập tên sản phẩm");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                gioHangVM.filterCart(newText.toLowerCase());
                return false;
            }
        });
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if(id == R.id.item_search_cart){
//
//            return true;
//        }else {
//            return super.onOptionsItemSelected(item);
//        }
//    }
    private void dathang() {
        DonHang dh =new DonHang();
        dh.setListDonHangChiTiet(list);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("DonHangs")
                .add(dh)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(GioHangActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(GioHangActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
//        Intent intent = new Intent(this, ThanhToanActivity.class);
//        intent.putExtra("DonHang_api", dh);
//        startActivity(intent);
    }
    private void init(){
        this.toolbar_title = findViewById((R.id.toolbar_cart_title));
        this.btn_DatHang = findViewById(R.id.btn_DatHang);
        this.toolbar_cart = findViewById(R.id.toolbar_cart);
        setSupportActionBar(toolbar_cart);
        toolbar_cart.setLogo(R.drawable.mh_baseline_check_box_outline_blank_24);



        this.btn_DatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                toolbar_title.setVisibility(View.GONE);
                dathang();
            }
        });

    }


}