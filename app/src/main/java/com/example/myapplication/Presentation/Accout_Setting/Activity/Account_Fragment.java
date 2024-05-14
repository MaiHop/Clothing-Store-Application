package com.example.myapplication.Presentation.Accout_Setting.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class Account_Fragment extends Fragment {
    TextView tv_nameAccount,tv_mailAccount, tv_addrress;
    LinearLayout ln_myprofile,ln_logout;
    ImageView img_account;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.c_hung_activity_acoout,container,false);
        initUI();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        Picasso.get().load(mUser.getPhotoUrl().toString()).into(img_account);
        tv_nameAccount.setText(mUser.getDisplayName());
        tv_mailAccount.setText(mUser.getEmail());
        btnLinerLayout();
        return view;
    }
    private void initUI(){
        tv_nameAccount = view.findViewById(R.id.tv_nameAccount);
        tv_mailAccount = view.findViewById(R.id.tv_mailAccount);
        tv_addrress = view.findViewById(R.id.tv_address);
        ln_logout = view.findViewById(R.id.ln_logout);
        ln_myprofile = view.findViewById(R.id.ln_myprofile);
        img_account = view.findViewById(R.id.imgAccout);

    }
    private void btnLinerLayout(){
        ln_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        ln_myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(getContext(), MyProfile.class);
                startActivity(intent);
            }
        });
    }
    private void showDialog() {
        final Dialog dialog = new Dialog(getActivity());
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.c_hung_activity_logout);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.getAttributes().windowAnimations = R.style.DialogAnimation;
            window.setGravity(Gravity.BOTTOM);
        }

        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button btnConfirmLogout = dialog.findViewById(R.id.btn_logout);
        btnConfirmLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(), HomeThamGia.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
