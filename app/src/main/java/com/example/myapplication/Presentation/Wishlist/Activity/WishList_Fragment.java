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

import com.example.myapplication.Model2.SanPham;
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
    private YeuThichVM wishlist_VM;
    private List<SanPham> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = getActivity().getLayoutInflater().inflate(R.layout.c_hung_activity_wish_list, container, false);
//        navigateToWishlist();
        initUI();
//        setSupportActionBar(toolbar);
        imteBoLoc();
        recyclerViewSP.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerViewSP.setHasFixedSize(true);
        wishlist_VM = new ViewModelProvider(this).get(YeuThichVM.class);
//        wishlist_VM.getProductListWishLiveData().observe(getViewLifecycleOwner(), wishlists -> {
//            if(!(wishlists.isEmpty())){
//                list = wishlists;
//                Adapter_Item_SP_WishList adapterItemSpWishList = new Adapter_Item_SP_WishList(getContext(),wishlists,title,wishlist_VM);
//                recyclerViewSP.setAdapter(adapterItemSpWishList);
//            }
//        });

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
    public void imteBoLoc(){
        ArrayList<BoLoc_WishList> arrayBoLocList;

        Adapter_Item_BoLoc_WishList adapterItemBoLocWishList;

        recyclerViewBoLoc.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        arrayBoLocList = new ArrayList<>();
        arrayBoLocList.add(new BoLoc_WishList("Ao"));
        arrayBoLocList.add(new BoLoc_WishList("Quan"));
        arrayBoLocList.add(new BoLoc_WishList("pop"));
        arrayBoLocList.add(new BoLoc_WishList("Tui"));
        arrayBoLocList.add(new BoLoc_WishList("Giay"));

        adapterItemBoLocWishList = new Adapter_Item_BoLoc_WishList(getContext(),R.layout.c_hung_item_boloc,arrayBoLocList);
        recyclerViewBoLoc.setAdapter(adapterItemBoLocWishList);
    }
}



