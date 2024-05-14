package com.example.myapplication.Presentation.Wishlist.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.SanPham;
import com.example.myapplication.Presentation.Wishlist.Adapter.Adapter_Item_BoLoc_WishList;
import com.example.myapplication.Presentation.Wishlist.Adapter.Adapter_Item_SP_WishList;
import com.example.myapplication.Presentation.Wishlist.Model.BoLoc_WishList;
import com.example.myapplication.Presentation.Wishlist.ViewModel.YeuThichVM;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class WishList_Fragment extends Fragment {
    RecyclerView recyclerViewBoLoc,recyclerViewSP;
    TextView title;
    private YeuThichVM YeuThichVM;
    View view;
    private Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = getActivity().getLayoutInflater().inflate(R.layout.c_hung_activity_wish_list, container, false);
//        navigateToWishlist();
        initUI();
//        setSupportActionBar(toolbar);
        ArrayList<BoLoc_WishList> arrayBoLocList;

        Adapter_Item_BoLoc_WishList adapterItemBoLocWishList;
        Adapter_Item_SP_WishList adapterItemSpWishList;


        recyclerViewBoLoc.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewSP.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerViewSP.setHasFixedSize(true);

        arrayBoLocList = new ArrayList<>();
        arrayBoLocList.add(new BoLoc_WishList("Ao"));
        arrayBoLocList.add(new BoLoc_WishList("Quan"));
        arrayBoLocList.add(new BoLoc_WishList("pop"));
        arrayBoLocList.add(new BoLoc_WishList("Tui"));
        arrayBoLocList.add(new BoLoc_WishList("Giay"));

        // Khởi tạo ViewModel1
        adapterItemSpWishList = new Adapter_Item_SP_WishList(new ArrayList<>(),getContext(),R.layout.c_hung_item_sp_wishlist);
        recyclerViewSP.setAdapter(adapterItemSpWishList);
        YeuThichVM = new ViewModelProvider(this).get(YeuThichVM.class);

        // Lắng nghe LiveData để nhận danh sách sản phẩm
        YeuThichVM.getProductListWishLiveData().observe(getViewLifecycleOwner(), new Observer<List<SanPham>>() {
            @Override
            public void onChanged(List<SanPham> productList) {
                // Cập nhật Adapter khi dữ liệu thay đổi
                adapterItemSpWishList.setListProductWish(productList);
            }
        });

        adapterItemBoLocWishList = new Adapter_Item_BoLoc_WishList(getContext(),R.layout.c_hung_item_boloc,arrayBoLocList);
        recyclerViewBoLoc.setAdapter(adapterItemBoLocWishList);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initUI(){
        toolbar = view.findViewById(R.id.toolbar_WishList);
        recyclerViewBoLoc = view.findViewById(R.id.RV_itemboloc_wishlist);
        recyclerViewSP = view.findViewById(R.id.RV_item_Sp_wishlist);
        title = view.findViewById(R.id.title);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }
}



