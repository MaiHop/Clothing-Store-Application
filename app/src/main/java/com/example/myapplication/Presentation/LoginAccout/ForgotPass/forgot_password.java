package com.example.myapplication.Presentation.LoginAccout.ForgotPass;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Presentation.LoginAccout.Load_Dialog;
import com.example.myapplication.Presentation.LoginAccout.OTP.SP_OTP;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class forgot_password extends AppCompatActivity {
    TextInputEditText txtip_email_forgot;
    ImageView pack_forgot;
    Button btn_sendcode;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    String Email;
    TextView tv_error;
    Load_Dialog loadDialog = new Load_Dialog(forgot_password.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_forgot_password);

        initUI();
        Onclickbtn();

    }
    private void initUI(){
        txtip_email_forgot = findViewById(R.id.txtip_email_forgot);
        pack_forgot = findViewById(R.id.pack_forgot);
        btn_sendcode = findViewById(R.id.btn_sendOTP);
        tv_error = findViewById(R.id.tv_error);
    }
    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }
    public void Onclickbtn(){
        pack_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_sendcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Email = txtip_email_forgot.getText().toString().trim();
                if (!TextUtils.isEmpty(Email)){
                    if(isValidEmail(Email)){
                        FirebaseFirestore db = FirebaseFirestore.getInstance();
                        CollectionReference usersRef = db.collection("KhachHang");

                        usersRef.whereEqualTo("email", Email).get()
                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()) {
                                            if (!task.getResult().isEmpty()) {
                                                // Email exists in the database, call ResetPassWord()
                                                ResetPassWord();
                                            } else {
                                                // Email does not exist, show error message
                                                tv_error.setText("Email này chưa được đăng ký !!!");
                                                tv_error.setVisibility(View.VISIBLE);
                                            }
                                        } else {
                                            // Handle the error
                                            Log.e(TAG, "Lỗi khi kiểm tra email: ", task.getException());
                                        }
                                    }
                                });
                    }
                    else {
                        tv_error.setText("Email sai định dạng !!!");
                        tv_error.setVisibility(View.VISIBLE);
                    }
                }else {
                    tv_error.setText("Mời bạn điền Email để bắt đầu đặt lại Password");
                    tv_error.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    private void ResetPassWord(){
        mAuth.sendPasswordResetEmail(Email)
            .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                loadDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadDialog.dismissDialog();

                        Intent intent = new Intent(forgot_password.this,SP_OTP.class);
                        intent.putExtra("confirm_code", "forgot_password");
                        Toast.makeText(forgot_password.this,"Mời bạn xác thực bên email của bạn",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                },2000);
            }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(forgot_password.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });

    }

}