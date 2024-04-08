package com.example.myapplication.Presentation.Cart.Helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.myapplication.R;

public class LoadingDialog {
    private Activity activity;
    private AlertDialog dialog;

    public LoadingDialog(Activity activity) {
        this.activity = activity;
    }

    public void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_processing_payments, null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();
    }

    public void dissmissDialog(){
        dialog.dismiss();
    }
}
