package com.example.myapplication.Presentation.PhucHoi.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Model.KichThuoc;
import com.example.myapplication.Model.KieuSP;
import com.example.myapplication.Model.Mau;
import com.example.myapplication.Model.NhomSP;
import com.example.myapplication.Model.SanPham;
import com.example.myapplication.Presentation.PhucHoi.Apdapter.ColorAdapterPH;
import com.example.myapplication.Presentation.PhucHoi.Apdapter.KieuSPAdapter;
import com.example.myapplication.Presentation.PhucHoi.Apdapter.SanPhamAdapter;
import com.example.myapplication.Presentation.PhucHoi.Apdapter.SizeAdapterPH;
import com.example.myapplication.Presentation.PhucHoi.ViewModel.KichThuocVM;
import com.example.myapplication.Presentation.PhucHoi.ViewModel.KieuSPVM;
import com.example.myapplication.Presentation.PhucHoi.ViewModel.MauVM;
import com.example.myapplication.Presentation.PhucHoi.ViewModel.SanPhamVM;
import com.example.myapplication.R;
import com.google.android.material.slider.RangeSlider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhMucActivity extends AppCompatActivity {

    private RecyclerView recyclerView, recyclerViewkieuSP;
    private SanPhamAdapter sanPhamAdapter;
    private SanPhamVM sp_VM;
    private List<SanPham> sanPhamList;
    private TextView tvNhomSPName, emptyTextView;
    private SearchView searchView;
    private List<SanPham> originalSanPhamList = new ArrayList<>();
    private String nhomSPId;
    private Button sortButton, filterButton;
    private KieuSPVM kieuSPViewModel;
    private KieuSPAdapter kieuSPAdapter;
    private boolean checkkieusp = false;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hoi_sanpham_layout);

        tvNhomSPName = findViewById(R.id.tendanhmuc);
        searchView = findViewById(R.id.editTextText2);
        emptyTextView = findViewById(R.id.emptyTextView);
        sortButton = findViewById(R.id.btnSort);
        filterButton = findViewById(R.id.btnFilter);
        ImageView backButton = findViewById(R.id.imageViewBack);

        recyclerView = findViewById(R.id.viewwomen);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nhomSPId = getIntent().getStringExtra("nhomSPId");
        updateSanPhamList(nhomSPId);

        NhomSP nhomSP = findNhomSPById(nhomSPId);
        if (nhomSP != null) {
            tvNhomSPName.setText(nhomSP.getTen());
        }

        List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
        sanPhamAdapter = new SanPhamAdapter(filteredList, this, getLayoutInflater());
        recyclerView.setAdapter(sanPhamAdapter);

        updateListAndEmptyView(filteredList);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<SanPham> searchedList = searchSanPhamByNhomSPId(originalSanPhamList, nhomSPId, newText);
                sanPhamAdapter.updateList(searchedList);
                updateListAndEmptyView(searchedList);
                return false;
            }
        });

        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSortDialog();
            }
        });

        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFilterDialog();
            }
        });

        // Khởi tạo Danh mục
        recyclerViewkieuSP = findViewById(R.id.viewkieusp);
        recyclerViewkieuSP.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        kieuSPAdapter = new KieuSPAdapter(new ArrayList<>(), this, getLayoutInflater());
        recyclerViewkieuSP.setAdapter(kieuSPAdapter);
        kieuSPViewModel = new ViewModelProvider(this).get(KieuSPVM.class);

        kieuSPViewModel.getNhomSPListLiveData().observe(this, new Observer<List<KieuSP>>() {
            @Override
            public void onChanged(List<KieuSP> kieuSPList) {
                if (kieuSPList != null && !kieuSPList.isEmpty()) {
                    kieuSPAdapter.setListNhomSP(kieuSPList);
                }
            }
        });

        kieuSPAdapter.setOnItemClickListener(new KieuSPAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String kieuSPId) {
                List<SanPham> filteredList = getSanPhamByKieuSPId(kieuSPId, nhomSPId);
                sanPhamAdapter.updateList(filteredList);
                updateListAndEmptyView(filteredList);
            }
        });
    }

    private void updateSanPhamList(String nhomSPId) {
        CartRepository cartRepository = new CartRepository();
        sanPhamList = filterSanPhamByNhomSPId(cartRepository.getSanPham(), nhomSPId);
        originalSanPhamList.clear();
        originalSanPhamList.addAll(sanPhamList);
    }

    private List<SanPham> filterSanPhamByNhomSPId(List<SanPham> sanPhamList, String nhomSPId) {
        List<SanPham> filteredList = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            if (sanPham.getNhomSanPham().getId().equals(nhomSPId)) {
                filteredList.add(sanPham);
            }
        }
        return filteredList;
    }

    private void showSortDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chọn cách sắp xếp");
        String[] options = {"Giá tăng dần", "Giá giảm dần", "Tên A-Z", "Tên Z-A"};
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        sortByPriceAscending();
                        break;
                    case 1:
                        sortByPriceDescending();
                        break;
                    case 2:
                        sortByNameAscending();
                        break;
                    case 3:
                        sortByNameDescending();
                        break;
                }
            }
        });
        builder.show();
    }

    private KichThuoc findSizeByName(List<KichThuoc> sizes, String name) {
        for (KichThuoc size : sizes) {
            if (size.getTen().equals(name)) {
                return size;
            }
        }
        return null;
    }

    private Mau findColorByName(List<Mau> colors, String name) {
        for (Mau color : colors) {
            if (color.getTen().equals(name)) {
                return color;
            }
        }
        return null;
    }

    private List<SanPham> filterSanPham(KichThuoc size, Mau color, KieuSP kieuSP, float minPrice, float maxPrice) {
        List<SanPham> filteredList = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            if ((size == null || sanPham.getKichThuoc().getId().equals(size.getId())) &&
                    (color == null || sanPham.getMau().getId().equals(color.getId())) &&
                    (kieuSP == null || sanPham.getKieuSanPham().getId().equals(kieuSP.getId())) &&
                    (sanPham.getGiaban() >= minPrice && sanPham.getGiaban() <= maxPrice)) {
                filteredList.add(sanPham);
            }
        }
        return filteredList;
    }


    public List<SanPham> getSanPhamByKieuSPId(String kieuSPId, String nhomSPId) {
        List<SanPham> filteredList = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            if (sanPham.getKieuSanPham().getId().equals(kieuSPId) &&
                    sanPham.getNhomSanPham().getId().equals(nhomSPId)) {
                filteredList.add(sanPham);
            }
        }
        return filteredList;
    }

    private NhomSP findNhomSPById(String nhomSPId) {
        CartRepository cartRepository = new CartRepository();
        List<NhomSP> nhomSPList = cartRepository.getListNhomSP();
        for (NhomSP nhomSP : nhomSPList) {
            if (nhomSP.getId().equals(nhomSPId)) {
                return nhomSP;
            }
        }
        return null;
    }

    private List<SanPham> searchSanPhamByNhomSPId(List<SanPham> sanPhamList, String nhomSPId, String keyword) {
        List<SanPham> searchedList = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            if (sanPham.getNhomSanPham().getId().equals(nhomSPId) &&
                    sanPham.getTenSanPham().toLowerCase().contains(keyword.toLowerCase())) {
                searchedList.add(sanPham);
            }
        }
        return searchedList;
    }

    private void updateListAndEmptyView(List<SanPham> newList) {
        if (newList.isEmpty()) {
            emptyTextView.setVisibility(View.VISIBLE);
        } else {
            emptyTextView.setVisibility(View.GONE);
        }
    }

    private void sortByPriceAscending() {
        List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
        Collections.sort(filteredList, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return Double.compare(sp1.getGiaban(), sp2.getGiaban());
            }
        });
        sanPhamAdapter.updateList(filteredList);
    }

    private void sortByPriceDescending() {
        List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
        Collections.sort(filteredList, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return Double.compare(sp2.getGiaban(), sp1.getGiaban());
            }
        });
        sanPhamAdapter.updateList(filteredList);
    }

    private void sortByNameAscending() {
        List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
        Collections.sort(filteredList, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return sp1.getTenSanPham().compareToIgnoreCase(sp2.getTenSanPham());
            }
        });
        sanPhamAdapter.updateList(filteredList);
    }

    private void sortByNameDescending() {
        List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
        Collections.sort(filteredList, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return sp2.getTenSanPham().compareToIgnoreCase(sp1.getTenSanPham());
            }
        });
        sanPhamAdapter.updateList(filteredList);
    }

    private void showFilterDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.hoi_filter, null);
        RecyclerView viewLoaiSp = dialogView.findViewById(R.id.viewLoaiSP);
        RecyclerView viewSize = dialogView.findViewById(R.id.viewSize);
        RecyclerView viewColor = dialogView.findViewById(R.id.viewColor);
        RangeSlider rangeSlider = dialogView.findViewById(R.id.range_slider);
        Button applyButton = dialogView.findViewById(R.id.buttonApply);
        Button resetButton = dialogView.findViewById(R.id.buttonReset);

        viewLoaiSp.setLayoutManager(new LinearLayoutManager(this));
        KieuSPAdapter adapterKieuSP = new KieuSPAdapter(new ArrayList<>(), this, getLayoutInflater());
        KieuSPVM kieuSPViewModel = new ViewModelProvider(this).get(KieuSPVM.class);
        kieuSPViewModel.getNhomSPListLiveData().observe(this, new Observer<List<KieuSP>>() {
            @Override
            public void onChanged(List<KieuSP> kieuSPList) {
                adapterKieuSP.setListNhomSP(kieuSPList);
            }
        });
        viewLoaiSp.setAdapter(adapterKieuSP);

        viewSize.setLayoutManager(new LinearLayoutManager(this));
        SizeAdapterPH adapterSize = new SizeAdapterPH(new ArrayList<>(), getLayoutInflater());
        KichThuocVM kichthuocSPViewModel = new ViewModelProvider(this).get(KichThuocVM.class);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        viewSize.setLayoutManager(layoutManager);
        kichthuocSPViewModel.getKichThuocListLiveData().observe(this, new Observer<List<KichThuoc>>() {
            @Override
            public void onChanged(List<KichThuoc> kichThuocList) {
                adapterSize.setListKichThuoc(kichThuocList);
            }
        });
        viewSize.setAdapter(adapterSize);

        viewColor.setLayoutManager(new LinearLayoutManager(this));
        ColorAdapterPH adapterColor = new ColorAdapterPH(new ArrayList<>(), this, getLayoutInflater());
        MauVM mauViewModel = new ViewModelProvider(this).get(MauVM.class);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        viewColor.setLayoutManager(layoutManager1);
        mauViewModel.getMauListLiveData().observe(this, new Observer<List<Mau>>() {
            @Override
            public void onChanged(List<Mau> mauList) {
                adapterColor.setListMau(mauList);
            }
        });
        viewColor.setAdapter(adapterColor);

        // Create and show the dialog
        builder.setView(dialogView);
        dialog = builder.create();
        dialog.show();

        // Handling Apply button click event
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KichThuoc selectedSize = adapterSize.getSelectedSize();
                Mau selectedColor = adapterColor.getSelectedColor();
                KieuSP selectedKieuSP = adapterKieuSP.getSelectedKieuSP();
                float minPrice = rangeSlider.getValues().get(0);
                float maxPrice = rangeSlider.getValues().get(1);
//                float maxPrice = rangeSlider.getValues().get(1);
                List<SanPham> filteredList = filterSanPham(selectedSize, selectedColor, selectedKieuSP,minPrice,maxPrice);
                sanPhamAdapter.updateList(filteredList);
                updateListAndEmptyView(filteredList);
                dialog.dismiss();
            }
        });

        // Handling Reset button click event
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rangeSlider.setValues(rangeSlider.getValueFrom(), rangeSlider.getValueTo());
                adapterSize.clearSelection();
                adapterColor.clearSelection();
                adapterKieuSP.clearSelection();
            }
        });
        rangeSlider.setValues(0.0f, 500.0f);

    }
}
