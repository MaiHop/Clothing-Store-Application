package com.example.myapplication.Presentation.PhucHoi.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.NhomSP;
import com.example.myapplication.Model.SanPham;
import com.example.myapplication.Presentation.PhucHoi.Apdapter.NhomSPAdapter;
import com.example.myapplication.Presentation.PhucHoi.Apdapter.SanPhamAdapter;
import com.example.myapplication.Presentation.PhucHoi.ViewModel.NhomSPVM;
import com.example.myapplication.Presentation.PhucHoi.ViewModel.SanPhamNewVM;
import com.example.myapplication.Presentation.PhucHoi.ViewModel.SanPhamVM;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SanPham_Fragment extends Fragment {
    View view;
    private RecyclerView recyclerView1,recyclerView2,recyclerView;
    private SanPhamAdapter sanPhamAdapter1,sanPhamAdapter2;
    private NhomSPAdapter nhomSPAdapter;
    private SanPhamVM sanPhamViewModel;
    private NhomSPVM nhomSPViewModel;
    private SanPhamNewVM sanPhamNewViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = getActivity().getLayoutInflater().inflate(R.layout.hoi_homepage, container, false);
        recyclerView1 = view.findViewById(R.id.view2);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        sanPhamAdapter1 = new SanPhamAdapter(new ArrayList<>(), getContext(), getLayoutInflater());
        recyclerView1.setAdapter(sanPhamAdapter1);

        // Danh sach 2
        recyclerView2 = view.findViewById(R.id.view1);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        sanPhamAdapter2 = new SanPhamAdapter(new ArrayList<>(), getContext(), getLayoutInflater());
        recyclerView2.setAdapter(sanPhamAdapter2);

        // Danh mục
        recyclerView = view.findViewById(R.id.viewdanhmuc);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        nhomSPAdapter = new NhomSPAdapter(new ArrayList<>(), getContext(), getLayoutInflater());
        recyclerView.setAdapter(nhomSPAdapter);

        // Khởi tạo ViewModel1
        sanPhamViewModel = new ViewModelProvider(this).get(SanPhamVM.class);

        // Lắng nghe LiveData để nhận danh sách sản phẩm
        sanPhamViewModel.getProductListLiveData().observe(getViewLifecycleOwner(), new Observer<List<SanPham>>() {
            @Override
            public void onChanged(List<SanPham> productList) {
                // Cập nhật Adapter khi dữ liệu thay đổi
                sanPhamAdapter1.setListProduct(productList);
            }
        });

        // Khởi tạo ViewModel2
        sanPhamNewViewModel = new ViewModelProvider(this).get(SanPhamNewVM.class);
        // Lắng nghe LiveData để nhận danh sách sản phẩm 2
        sanPhamNewViewModel.getProductListLiveData().observe(getViewLifecycleOwner(), new Observer<List<SanPham>>() {
            @Override
            public void onChanged(List<SanPham> productList) {
                // Cập nhật Adapter khi dữ liệu thay đổi
                sanPhamAdapter2.setListProduct(productList);
            }
        });

        // Khởi tạo Danh mục
        nhomSPViewModel = new ViewModelProvider(this).get(NhomSPVM.class);
        // Lắng nghe LiveData để nhận danh sách sản phẩm 2
        nhomSPViewModel.getNhomSPListLiveData().observe(getViewLifecycleOwner(), new Observer<List<NhomSP>>() {
            @Override
            public void onChanged(List<NhomSP> NhomSPList) {
                // Cập nhật Adapter khi dữ liệu thay đổi
                nhomSPAdapter.setListNhomSP(NhomSPList);
            }
        });
        return view;
    }
}
