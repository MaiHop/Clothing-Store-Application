//package com.example.myapplication.Presentation.LoginAccout;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.view.LayoutInflater;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.myapplication.R;
//
//public class Load_Dialog extends AppCompatActivity {
//    private Activity activity;
//    private AlertDialog alertDialog;
//    public Load_Dialog(Activity myacivity){
//        activity = myacivity;
//    }
//
//    public void startLoadingDialog(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        LayoutInflater inflater = activity.getLayoutInflater();
//        builder.setView(inflater.inflate(R.layout.c_hung_custom_dialog_loading,null));
//        builder.setCancelable(true);
//
//        alertDialog = builder.create();
//        alertDialog.show();
//    }
//
//    public void dismissDialog(){
//        if (alertDialog != null && alertDialog.isShowing()) {
//            alertDialog.dismiss();
//        }
//    }
//}
package com.example.myapplication.Presentation.LoginAccout;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Load_Dialog extends AppCompatActivity {
    private Activity activity;
    private AlertDialog alertDialog;

    public Load_Dialog(Activity myActivity) {
        this.activity = myActivity;
    }

    public void startLoadingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        // Đảm bảo layout được inflate mà không được thêm vào ViewGroup cha.
        builder.setView(inflater.inflate(R.layout.c_hung_custom_dialog_loading, null, false));
        builder.setCancelable(true);

        alertDialog = builder.create();
        // Loại bỏ khoảng trắng không mong muốn xung quanh layout dialog
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alertDialog.show();
    }

    public void dismissDialog() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }
}

