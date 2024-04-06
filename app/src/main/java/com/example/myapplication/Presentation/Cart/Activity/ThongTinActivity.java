package com.example.myapplication.Presentation.Cart.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class ThongTinActivity extends AppCompatActivity {
    private TextView toolbar_thongtin_title;
    private EditText ed_NhapCode;
    private Button btn_XacNhanCode, btn_ThongTin_OK;
    private RecyclerView rv_Choose_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_info);

        init();
    }
    private void init(){
        toolbar_thongtin_title = findViewById(R.id.toolbar_thongtin_title);
        ed_NhapCode = findViewById(R.id.ed_NhapCode);
        btn_XacNhanCode = findViewById(R.id.btn_XacNhanCode);
        btn_ThongTin_OK = findViewById(R.id.btn_ThongTin_OK);
        rv_Choose_info = findViewById(R.id.rv_Choose_info);
    }
}