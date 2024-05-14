package com.example.myapplication.Presentation.Cart.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Presentation.Cart.Apdapter.CartAdapter;
import com.example.myapplication.Domain.Model.DonHang;
import com.example.myapplication.Domain.Model.DonHangChiTiet;
import com.example.myapplication.Presentation.Cart.ViewModel.GioHangVM;
import com.example.myapplication.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class GioHangFragment extends Fragment {
    private RecyclerView rv_ListCart;
    private Button btn_DatHang;
    private TextView toolbar_title;
    private Toolbar toolbar_cart;
    private List<DonHangChiTiet> list;
    private GioHangVM gioHangVM;
    private SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mh_activity_cart, container, false);
        init(view);
        rv_ListCart = view.findViewById(R.id.rv_ListCart);
        rv_ListCart.setLayoutManager(new LinearLayoutManager(getContext()));
        gioHangVM = new ViewModelProvider(this).get(GioHangVM.class);
        gioHangVM.getListCartLiveData().observe(getViewLifecycleOwner(), donHangChiTiets -> {
            list = donHangChiTiets;
            CartAdapter adapter = new CartAdapter(getContext(), donHangChiTiets, btn_DatHang, toolbar_title, gioHangVM);
            rv_ListCart.setAdapter(adapter);
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.mh_menu_toolbar_cart, menu);
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
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void dathang() {
        DonHang dh = new DonHang();
        dh.setListDonHangChiTiet(list);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("DonHangs")
                .add(dh)
                .addOnSuccessListener(documentReference -> Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show());
    }

    private void init(View view){
        toolbar_title = view.findViewById((R.id.toolbar_cart_title));
        btn_DatHang = view.findViewById(R.id.btn_DatHang);
        toolbar_cart = view.findViewById(R.id.toolbar_cart);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_cart);
        toolbar_cart.setLogo(R.drawable.mh_baseline_check_box_outline_blank_24);
        btn_DatHang.setOnClickListener(v -> dathang());
    }
}
