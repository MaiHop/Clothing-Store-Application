package com.example.myapplication.Presentation.LoginAccout.ForgotPass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.Presentation.LoginAccout.Load_Dialog;
import com.example.myapplication.R;

public class DatLai_Password extends AppCompatActivity {
    Intent intent;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_dat_lai_password);
        btn = findViewById(R.id.btn_DatLai_Pass);

        btnOnClick(btn);
    }
    public void btnOnClick(Button btn){
        final Load_Dialog loadDialog = new Load_Dialog(DatLai_Password.this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadDialog.dismissDialog();
                        intent = new Intent(DatLai_Password.this, HomeThamGia.class);
                        startActivity(intent);
                    }
                },2000);
            }
        });
    }
}