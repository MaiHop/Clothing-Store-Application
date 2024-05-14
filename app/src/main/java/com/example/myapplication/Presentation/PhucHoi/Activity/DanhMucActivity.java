package com.example.myapplication.Presentation.PhucHoi.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.KichThuoc;
import com.example.myapplication.Model.Mau;
import com.example.myapplication.Model.NhomSP;
import com.example.myapplication.Model.SanPham;
import com.example.myapplication.Data.Data_Source.CartRepository;
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
    private Button sortButton, filterButton;


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

        NhomSP nhomSP = findNhomSPById(nhomSPId);
        if (nhomSP != null) {
            tvNhomSPName.setText(nhomSP.getTen());
        }

        CartRepository cartRepository = new CartRepository();
        sanPhamList = cartRepository.getSanPham();
        originalSanPhamList = new ArrayList<>(sanPhamList);

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


//        // Tìm và hiển thị tên của NhomSP_api lên tvNhomSPName
//        NhomSP nhomSP = findNhomSPById(nhomSPId);
//        if (nhomSP != null) {
//            tvNhomSPName.setText(nhomSP.getTen());
//
//        }
    }
        private List<SanPham> filterSanPhamByNhomSPId (List < SanPham > sanPhamList, String nhomSPId)
        {
            List<SanPham> filteredList = new ArrayList<>();
            for (SanPham sanPham : sanPhamList) {
                if (sanPham.getNhomSanPham().getId().equals(nhomSPId)) {
                    filteredList.add(sanPham);
                }
            }
            return filteredList;
        }


        // Phương thức tìm NhomSP_api theo nhomSPId

        private NhomSP findNhomSPById (String nhomSPId){
            CartRepository cartRepository = new CartRepository();
            List<NhomSP> nhomSPList = cartRepository.getListNhomSP();
            for (NhomSP nhomSP : nhomSPList) {
                if (nhomSP.getId().equals(nhomSPId)) {
                    return nhomSP;
                }
            }
            return null;
        }

        private List<SanPham> searchSanPhamByNhomSPId (List < SanPham > sanPhamList, String
        nhomSPId, String keyword){
            List<SanPham> searchedList = new ArrayList<>();
            for (SanPham sanPham : sanPhamList) {
                if (sanPham.getNhomSanPham().getId().equals(nhomSPId) && sanPham.getTenSanPham().toLowerCase().contains(keyword.toLowerCase())) {
                    searchedList.add(sanPham);
                }
            }
            return searchedList;
        }

        private void updateListAndEmptyView (List < SanPham > newList) {
            if (newList.isEmpty()) {
                emptyTextView.setVisibility(View.VISIBLE);
            } else {
                emptyTextView.setVisibility(View.GONE);
            }
        }

        private void showSortDialog () {
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

        private void sortByPriceAscending () {
            List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
            Collections.sort(filteredList, new Comparator<SanPham>() {
                @Override
                public int compare(SanPham sp1, SanPham sp2) {
                    return Double.compare(sp1.getGiaban(), sp2.getGiaban());
                }
            });
            sanPhamAdapter.updateList(filteredList);
        }

        private void sortByPriceDescending () {
            List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
            Collections.sort(filteredList, new Comparator<SanPham>() {
                @Override
                public int compare(SanPham sp1, SanPham sp2) {
                    return Double.compare(sp2.getGiaban(), sp1.getGiaban());
                }
            });
            sanPhamAdapter.updateList(filteredList);
        }

        private void sortByNameAscending () {
            List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
            Collections.sort(filteredList, new Comparator<SanPham>() {
                @Override
                public int compare(SanPham sp1, SanPham sp2) {
                    return sp1.getTenSanPham().compareToIgnoreCase(sp2.getTenSanPham());
                }
            });
            sanPhamAdapter.updateList(filteredList);
        }

        private void sortByNameDescending () {
            List<SanPham> filteredList = filterSanPhamByNhomSPId(sanPhamList, nhomSPId);
            Collections.sort(filteredList, new Comparator<SanPham>() {
                @Override
                public int compare(SanPham sp1, SanPham sp2) {
                    return sp2.getTenSanPham().compareToIgnoreCase(sp1.getTenSanPham());
                }
            });
            sanPhamAdapter.updateList(filteredList);
        }

        private void showFilterDialog () {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = getLayoutInflater().inflate(R.layout.hoi_loc, null);
            builder.setView(view);

            Spinner spinnerSize = view.findViewById(R.id.spinner_size);
            Spinner spinnerColor = view.findViewById(R.id.spinner_color);
            Button btnApply = view.findViewById(R.id.btn_apply);
            SeekBar seekBarPrice = view.findViewById(R.id.seekbar_price);

            TextView minValueTextView = view.findViewById(R.id.text_min_value);
            TextView maxValueTextView = view.findViewById(R.id.text_max_value);

            CartRepository cartRepository = new CartRepository();
            List<KichThuoc> listSize = cartRepository.getListSize();
            List<Mau> listColor = cartRepository.getListMau();


            List<String> sizeNames = new ArrayList<>();
            sizeNames.add("None");
            for (KichThuoc size : listSize) {
                sizeNames.add(size.getTen());
            }

            List<String> colorNames = new ArrayList<>();
            colorNames.add("None");
            for (Mau color : listColor) {
                colorNames.add(color.getTen());
            }

            ArrayAdapter<String> sizeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sizeNames);
            sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSize.setAdapter(sizeAdapter);

            ArrayAdapter<String> colorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colorNames);
            colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerColor.setAdapter(colorAdapter);

            AlertDialog dialog = builder.create();
            dialog.show();

            btnApply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lấy tên kích thước đã chọn từ Spinner
                    String selectedSizeName = (String) spinnerSize.getSelectedItem();
                    // Lấy tên màu đã chọn từ Spinner
                    String selectedColorName = (String) spinnerColor.getSelectedItem();
                    // Kiểm tra nếu tùy chọn là "None" thì gán giá trị null
                    KichThuoc selectedSize = selectedSizeName.equals("None") ? null : findSizeByName(listSize, selectedSizeName);
                    Mau selectedColor = selectedColorName.equals("None") ? null : findColorByName(listColor, selectedColorName);

                    // Lấy giá trị hiện tại của thanh SeekBar giá
                    int maxPrice = seekBarPrice.getProgress();

                    // Lọc sản phẩm theo kích thước, màu và giá
                    List<SanPham> filteredList = filterSanPham(selectedSize, selectedColor, maxPrice);
                    sanPhamAdapter.updateList(filteredList);
                    dialog.dismiss();
                }
            });

            // Xử lý sự kiện khi người dùng kéo thanh SeekBar
            seekBarPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    // Cập nhật giá trị hiển thị của hai đầu của khoảng giá trị được chọn
                    // Hiển thị giá trị tương ứng lên TextView
                    minValueTextView.setText(String.valueOf(progress));
                    maxValueTextView.setText(String.valueOf(progress + 200)); // Ví dụ: khoảng giá trị là 200
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // Không cần xử lý trong trường hợp này
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // Không cần xử lý trong trường hợp này
                }
            });
        }

        // Phương thức tìm kiếm đối tượng KichThuoc theo tên
        private KichThuoc findSizeByName (List < KichThuoc > sizes, String name){
            for (KichThuoc size : sizes) {
                if (size.getTen().equals(name)) {
                    return size;
                }
            }
            return null;
        }

        // Phương thức tìm kiếm đối tượng Mau theo tên
        private Mau findColorByName (List < Mau > colors, String name){
            for (Mau color : colors) {
                if (color.getTen().equals(name)) {
                    return color;
                }
            }
            return null;
        }

        // Phương thức lọc sản phẩm theo kích thước, màu và giá
        private List<SanPham> filterSanPham (KichThuoc size, Mau color,int maxPrice){
            List<SanPham> filteredList = new ArrayList<>();
            for (SanPham sanPham : sanPhamList) {
                // Kiểm tra nếu sản phẩm có kích thước được chọn, ID màu trùng khớp và giá không vượt quá giá tối đa
                if ((size == null || sanPham.getKichThuoc().getId().equals(size.getId())) &&
                        (color == null || sanPham.getMau().getId().equals(color.getId())) &&
                        sanPham.getGiaban() <= maxPrice) {
                    filteredList.add(sanPham);
                }
            }
            return filteredList;
        }

    }





