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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Domain.Model.NhomSP;
import com.example.myapplication.Domain.Model.SanPham;
import com.example.myapplication.Domain.Repository.CartRepository;
import com.example.myapplication.Presentation.PhucHoi.Apdapter.SanPhamAdapter;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhMucActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SanPhamAdapter sanPhamAdapter;
    private List<SanPham> sanPhamList;
    private TextView tvNhomSPName, emptyTextView;
    private SearchView searchView;
    private List<SanPham> originalSanPhamList = new ArrayList<>();
    private String nhomSPId;
    private Button sortButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hoi_women_layout);

        tvNhomSPName = findViewById(R.id.tendanhmuc);
        searchView = findViewById(R.id.editTextText2);
        emptyTextView = findViewById(R.id.emptyTextView);
        sortButton = findViewById(R.id.btnSort); // Đổi id thành id của button sắp xếp
        ImageView backButton = findViewById(R.id.imageViewBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.viewwomen);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Lấy nhomSPId từ Intent
        nhomSPId = getIntent().getStringExtra("nhomSPId");

        // Tìm và hiển thị tên của NhomSP lên tvNhomSPName
        NhomSP nhomSP = findNhomSPById(nhomSPId);
        if (nhomSP != null) {
            tvNhomSPName.setText(nhomSP.getTen());
        }

        // Lấy danh sách sản phẩm từ CartRepository
        CartRepository cartRepository = new CartRepository();
        sanPhamList = cartRepository.getSanPham();
        // Lưu danh sách sản phẩm ban đầu
        originalSanPhamList = new ArrayList<>(sanPhamList);

        // Lọc danh sách sản phẩm theo nhomSPId ban đầu và thiết lập adapter cho RecyclerView
        List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
        sanPhamAdapter = new SanPhamAdapter(filteredList, this, getLayoutInflater());
        recyclerView.setAdapter(sanPhamAdapter);

        updateListAndEmptyView(filteredList);

        // Set up search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Lọc danh sách sản phẩm theo từ khóa tìm kiếm và nhóm sản phẩm
                List<SanPham> searchedList = searchSanPhamByNhomSPId(originalSanPhamList, nhomSPId, newText);
                // Cập nhật RecyclerView với danh sách sản phẩm đã lọc
                sanPhamAdapter.updateList(searchedList);
                // Hiển thị hoặn ẩn emptyTextView dựa trên kết quả tìm kiếm
                updateListAndEmptyView(searchedList);
                return false;
            }
        });

        // Gán sự kiện click cho nút sắp xếp
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSortDialog(); // Hiển thị dialog sắp xếp khi click vào nút sắp xếp
            }
        });
    }

    // Phương thức hiển thị dialog sắp xếp
    private void showSortDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chọn cách sắp xếp");
        String[] options = {"Giá tăng dần", "Giá giảm dần", "Tên A-Z", "Tên Z-A"};
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        // Sắp xếp theo giá tăng dần
                        sortByPriceAscending();
                        break;
                    case 1:
                        // Sắp xếp theo giá giảm dần
                        sortByPriceDescending();
                        break;
                    case 2:
                        // Sắp xếp theo tên A-Z
                        sortByNameAscending();
                        break;
                    case 3:
                        // Sắp xếp theo tên Z-A
                        sortByNameDescending();
                        break;
                }
            }
        });
        builder.show();
    }

    // Các phương thức sắp xếp sản phẩm
    private void sortByPriceAscending() {
        // Lấy danh sách sản phẩm theo nhóm sản phẩm hiện tại
        List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
        // Thực hiện sắp xếp theo giá tăng dần
        Collections.sort(filteredList, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return Double.compare(sp1.getGiaban(), sp2.getGiaban());
            }
        });
        sanPhamAdapter.updateList(filteredList);
    }

    private void sortByPriceDescending() {
        // Lấy danh sách sản phẩm theo nhóm sản phẩm hiện tại
        List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
        // Thực hiện sắp xếp theo giá giảm dần
        Collections.sort(filteredList, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return Double.compare(sp2.getGiaban(), sp1.getGiaban());
            }
        });
        sanPhamAdapter.updateList(filteredList);
    }

    private void sortByNameAscending() {
        // Lấy danh sách sản phẩm theo nhóm sản phẩm hiện tại
        List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
        // Thực hiện sắp xếp theo tên A-Z
        Collections.sort(filteredList, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return sp1.getTenSanPham().compareToIgnoreCase(sp2.getTenSanPham());
            }
        });
        sanPhamAdapter.updateList(filteredList);
    }

    private void sortByNameDescending() {
        // Lấy danh sách sản phẩm theo nhóm sản phẩm hiện tại
        List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
        // Thực hiện sắp xếp theo tên Z-A
        Collections.sort(filteredList, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return sp2.getTenSanPham().compareToIgnoreCase(sp1.getTenSanPham());
            }
        });
        sanPhamAdapter.updateList(filteredList);
    }

    // Phương thức lọc danh sách sản phẩm theo nhóm sản phẩm (nhomSPId)
    private List<SanPham> filterSanPhamByNhomSPId(List<SanPham> sanPhamList, String nhomSPId) {
        List<SanPham> filteredList = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            if (sanPham.getNhomSanPham().getId().equals(nhomSPId)) {
                filteredList.add(sanPham);
            }
        }
        return filteredList;
    }

    // Phương thức tìm NhomSP theo nhomSPId
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

    // Phương thức tìm kiếm sản phẩm theo từ khóa và nhóm sản phẩm
    private List<SanPham> searchSanPhamByNhomSPId(List<SanPham> sanPhamList, String nhomSPId, String keyword) {
        List<SanPham> searchedList = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            if (sanPham.getNhomSanPham().getId().equals(nhomSPId) && sanPham.getTenSanPham().toLowerCase().contains(keyword.toLowerCase())) {
                searchedList.add(sanPham);
            }
        }
        return searchedList;
    }

    // Phương thức cập nhật RecyclerView và hiển thị hoặn ẩn emptyTextView dựa trên danh sách sản phẩm
    private void updateListAndEmptyView(List<SanPham> newList) {
        // Hiển thị hoặn ẩn emptyTextView dựa trên kết quả tìm kiếm
        if (newList.isEmpty()) {
            emptyTextView.setVisibility(View.VISIBLE);
        } else {
            emptyTextView.setVisibility(View.GONE);
        }
    }
}

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.hoi_women_layout);
//
//        tvNhomSPName = findViewById(R.id.tendanhmuc);
//        searchView = findViewById(R.id.editTextText2);
//        emptyTextView = findViewById(R.id.emptyTextView);
//        ImageView backButton = findViewById(R.id.imageViewBack);
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//
//        recyclerView = findViewById(R.id.viewwomen);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//
//        // Lấy nhomSPId từ Intent
//        String nhomSPId = getIntent().getStringExtra("nhomSPId");
//
//        // Tìm và hiển thị tên của NhomSP lên tvNhomSPName
//        NhomSP nhomSP = findNhomSPById(nhomSPId);
//        if (nhomSP != null) {
//            tvNhomSPName.setText(nhomSP.getTen());
//        }
//
//        // Lấy danh sách sản phẩm từ CartRepository
//        CartRepository cartRepository = new CartRepository();
//        sanPhamList = cartRepository.getSanPham();
//
//        // Lọc danh sách sản phẩm theo nhomSPId ban đầu và thiết lập adapter cho RecyclerView
//        List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
//        sanPhamAdapter = new SanPhamAdapter(filteredList, this, getLayoutInflater());
//        recyclerView.setAdapter(sanPhamAdapter);
//
//        updateListAndEmptyView(filteredList);
//        // Set up search functionality
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                // Lọc danh sách sản phẩm theo từ khóa tìm kiếm
//                List<SanPham> searchedList = searchSanPham(sanPhamList, newText);
//                // Cập nhật RecyclerView với danh sách sản phẩm đã lọc
//                sanPhamAdapter.updateList(searchedList);
//                return false;
//            }
//        });
//    }
//
//    // Phương thức lọc danh sách sản phẩm theo nhóm sản phẩm (nhomSPId)
//    private List<SanPham> filterSanPhamByNhomSPId(List<SanPham> sanPhamList, String nhomSPId) {
//        List<SanPham> filteredList = new ArrayList<>();
//        for (SanPham sanPham : sanPhamList) {
//            if (sanPham.getNhomSanPham().getId().equals(nhomSPId)) {
//                filteredList.add(sanPham);
//            }
//        }
//        return filteredList;
//    }
//
//    // Phương thức tìm NhomSP theo nhomSPId
//    private NhomSP findNhomSPById(String nhomSPId) {
//        CartRepository cartRepository = new CartRepository();
//        List<NhomSP> nhomSPList = cartRepository.getListNhomSP();
//        for (NhomSP nhomSP : nhomSPList) {
//            if (nhomSP.getId().equals(nhomSPId)) {
//                return nhomSP;
//            }
//        }
//        return null;
//    }
//
//    // Phương thức tìm kiếm sản phẩm theo từ khóa
//    private List<SanPham> searchSanPham(List<SanPham> sanPhamList, String keyword) {
//        List<SanPham> searchedList = new ArrayList<>();
//        for (SanPham sanPham : sanPhamList) {
//            if (sanPham.getTenSanPham().toLowerCase().contains(keyword.toLowerCase())) {
//                searchedList.add(sanPham);
//            }
//        }
//        return searchedList;
//    }
//    // Hiển thị hoặc ẩn emptyTextView dựa trên danh sách sản phẩm
//
//
//    // Method to update list and show/hide emptyTextView
//    private void updateListAndEmptyView(List<SanPham> newList) {
//        sanPhamList = newList;
//        sanPhamAdapter.updateList(newList);
//
//        // Show or hide emptyTextView based on the list size
//        if (newList.isEmpty()) {
//            emptyTextView.setVisibility(View.VISIBLE);
//        } else {
//            emptyTextView.setVisibility(View.GONE);
//        }
//    }
//@Override
//protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.hoi_women_layout);
//
//    tvNhomSPName = findViewById(R.id.tendanhmuc);
//    searchView = findViewById(R.id.editTextText2);
//    emptyTextView = findViewById(R.id.emptyTextView);
//    ImageView backButton = findViewById(R.id.imageViewBack);
//    backButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            finish();
//        }
//    });
//
//    recyclerView = findViewById(R.id.viewwomen);
//    recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//
//    // Lấy nhomSPId từ Intent
//    String nhomSPId = getIntent().getStringExtra("nhomSPId");
//
//    // Tìm và hiển thị tên của NhomSP lên tvNhomSPName
//    NhomSP nhomSP = findNhomSPById(nhomSPId);
//    if (nhomSP != null) {
//        tvNhomSPName.setText(nhomSP.getTen());
//    }
//
//    // Lấy danh sách sản phẩm từ CartRepository
//    CartRepository cartRepository = new CartRepository();
//    sanPhamList = cartRepository.getSanPham();
//    // Lưu danh sách sản phẩm ban đầu
//    originalSanPhamList = new ArrayList<>(sanPhamList);
//
//    // Lọc danh sách sản phẩm theo nhomSPId ban đầu và thiết lập adapter cho RecyclerView
//    List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
//    sanPhamAdapter = new SanPhamAdapter(filteredList, this, getLayoutInflater());
//    recyclerView.setAdapter(sanPhamAdapter);
//
//    updateListAndEmptyView(filteredList);
//
//    // Set up search functionality
//    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//        @Override
//        public boolean onQueryTextSubmit(String query) {
//            return false;
//        }
//
//        @Override
//        public boolean onQueryTextChange(String newText) {
//            // Lọc danh sách sản phẩm theo từ khóa tìm kiếm
//            List<SanPham> searchedList = searchSanPham(sanPhamList, newText);
//            // Cập nhật RecyclerView với danh sách sản phẩm đã lọc
//            sanPhamAdapter.updateList(searchedList);
//            // Hiển thị hoặc ẩn emptyTextView dựa trên kết quả tìm kiếm
//            updateListAndEmptyView(searchedList);
//            return false;
//        }
//    });
//}
//
//    // Phương thức lọc danh sách sản phẩm theo nhóm sản phẩm (nhomSPId)
//    private List<SanPham> filterSanPhamByNhomSPId(List<SanPham> sanPhamList, String nhomSPId) {
//        List<SanPham> filteredList = new ArrayList<>();
//        for (SanPham sanPham : sanPhamList) {
//            if (sanPham.getNhomSanPham().getId().equals(nhomSPId)) {
//                filteredList.add(sanPham);
//            }
//        }
//        return filteredList;
//    }
//
//    // Phương thức tìm NhomSP theo nhomSPId
//    private NhomSP findNhomSPById(String nhomSPId) {
//        CartRepository cartRepository = new CartRepository();
//        List<NhomSP> nhomSPList = cartRepository.getListNhomSP();
//        for (NhomSP nhomSP : nhomSPList) {
//            if (nhomSP.getId().equals(nhomSPId)) {
//                return nhomSP;
//            }
//        }
//        return null;
//    }
//
//    // Phương thức tìm kiếm sản phẩm theo từ khóa
//    private List<SanPham> searchSanPham(List<SanPham> sanPhamList, String keyword) {
//        List<SanPham> searchedList = new ArrayList<>();
//        for (SanPham sanPham : sanPhamList) {
//            if (sanPham.getTenSanPham().toLowerCase().contains(keyword.toLowerCase())) {
//                searchedList.add(sanPham);
//            }
//        }
//        return searchedList;
//    }
//
//    // Method to update list and show/hide emptyTextView
//    private void updateListAndEmptyView(List<SanPham> newList) {
//        // Show or hide emptyTextView based on the list size
//        if (newList.isEmpty()) {
//            emptyTextView.setVisibility(View.VISIBLE);
////            searchView.setQuery("", false); // Xóa từ khóa tìm kiếm
//            sanPhamAdapter.updateList(originalSanPhamList); // Sử dụng lại danh sách sản phẩm ban đầu
//        } else {
//            emptyTextView.setVisibility(View.GONE);
//        }
//    }

//@Override
//protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.hoi_women_layout);
//
//    tvNhomSPName = findViewById(R.id.tendanhmuc);
//    searchView = findViewById(R.id.editTextText2);
//    emptyTextView = findViewById(R.id.emptyTextView);
//    ImageView backButton = findViewById(R.id.imageViewBack);
//    backButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            finish();
//        }
//    });
//
//    recyclerView = findViewById(R.id.viewwomen);
//    recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//
//    // Lấy nhomSPId từ Intent
//    String nhomSPId = getIntent().getStringExtra("nhomSPId");
//
//    // Tìm và hiển thị tên của NhomSP lên tvNhomSPName
//    NhomSP nhomSP = findNhomSPById(nhomSPId);
//    if (nhomSP != null) {
//        tvNhomSPName.setText(nhomSP.getTen());
//    }
//
//    // Lấy danh sách sản phẩm từ CartRepository
//    CartRepository cartRepository = new CartRepository();
//    sanPhamList = cartRepository.getSanPham();
//    // Lưu danh sách sản phẩm ban đầu
//    originalSanPhamList = new ArrayList<>(sanPhamList);
//
//    // Lọc danh sách sản phẩm theo nhomSPId ban đầu và thiết lập adapter cho RecyclerView
//    List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
//    sanPhamAdapter = new SanPhamAdapter(filteredList, this, getLayoutInflater());
//    recyclerView.setAdapter(sanPhamAdapter);
//
//    updateListAndEmptyView(filteredList);
//
//    // Set up search functionality
//    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//        @Override
//        public boolean onQueryTextSubmit(String query) {
//            return false;
//        }
//
//        @Override
//        public boolean onQueryTextChange(String newText) {
//            // Lọc danh sách sản phẩm theo từ khóa tìm kiếm
//            List<SanPham> searchedList = searchSanPham(sanPhamList, newText);
//            // Cập nhật RecyclerView với danh sách sản phẩm đã lọc
//            sanPhamAdapter.updateList(searchedList);
//            // Hiển thị hoặc ẩn emptyTextView dựa trên kết quả tìm kiếm
//            updateListAndEmptyView(searchedList);
//            return false;
//        }
//    });
//}
//
//    // Phương thức lọc danh sách sản phẩm theo nhóm sản phẩm (nhomSPId)
//    private List<SanPham> filterSanPhamByNhomSPId(List<SanPham> sanPhamList, String nhomSPId) {
//        List<SanPham> filteredList = new ArrayList<>();
//        for (SanPham sanPham : sanPhamList) {
//            if (sanPham.getNhomSanPham().getId().equals(nhomSPId)) {
//                filteredList.add(sanPham);
//            }
//        }
//        return filteredList;
//    }
//
//    // Phương thức tìm NhomSP theo nhomSPId
//    private NhomSP findNhomSPById(String nhomSPId) {
//        CartRepository cartRepository = new CartRepository();
//        List<NhomSP> nhomSPList = cartRepository.getListNhomSP();
//        for (NhomSP nhomSP : nhomSPList) {
//            if (nhomSP.getId().equals(nhomSPId)) {
//                return nhomSP;
//            }
//        }
//        return null;
//    }
//
//    // Phương thức tìm kiếm sản phẩm theo từ khóa
//    private List<SanPham> searchSanPham(List<SanPham> sanPhamList, String keyword) {
//        List<SanPham> searchedList = new ArrayList<>();
//        for (SanPham sanPham : sanPhamList) {
//            if (sanPham.getTenSanPham().toLowerCase().contains(keyword.toLowerCase())) {
//                searchedList.add(sanPham);
//            }
//        }
//        return searchedList;
//    }
//
//    // Method to update list and show/hide emptyTextView
//    private void updateListAndEmptyView(List<SanPham> newList) {
//        // Cập nhật RecyclerView với danh sách sản phẩm đã lọc
//        sanPhamAdapter.updateList(newList);
//
//        // Hiển thị hoặc ẩn emptyTextView dựa trên kết quả tìm kiếm
//        if (newList.isEmpty()) {
//            emptyTextView.setVisibility(View.VISIBLE);
//        } else {
//            emptyTextView.setVisibility(View.GONE);
//        }
//    }



