package com.example.myapplication.UI.GH;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class Test_arrived extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.button_test);

            Button buttonShowDialog = findViewById(R.id.button2);
            buttonShowDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialogOrderArrived();
                }
            });
        }

        private void showDialogOrderArrived() {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.order_arrived);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                window.getAttributes().windowAnimations = R.style.DialogAnimation;
            }
            Button buttonLeaveReview = dialog.findViewById(R.id.button);
            buttonLeaveReview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Intent intent = new Intent(Test_arrived.this, ReviewActivity.class);
                    startActivity(intent);
                }
            });
            Button buttonMaybeLater = dialog.findViewById(R.id.button3);
            buttonMaybeLater.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        }
    }
