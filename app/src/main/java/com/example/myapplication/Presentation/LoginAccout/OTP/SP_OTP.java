package com.example.myapplication.Presentation.LoginAccout.OTP;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.Presentation.LoginAccout.Load_Dialog;
import com.example.myapplication.Presentation.LoginAccout.SignIn.logout;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SP_OTP extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4;
    ImageView img_back;

    Button btn_confirmCode;
//    final String confirm_code = getIntent().getStringExtra("confirm_code");
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_sup_otp);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        img_back = findViewById(R.id.img_pack_OTP);
        btn_confirmCode = findViewById(R.id.Confirm_code);

        editText1.addTextChangedListener(new GenericTextWatcher(editText1));
        editText2.addTextChangedListener(new GenericTextWatcher(editText2));
        editText3.addTextChangedListener(new GenericTextWatcher(editText3));
        editText4.addTextChangedListener(new GenericTextWatcher(editText4));


        OnclickImage(img_back);
        Onclickbtn(btn_confirmCode);

    }

    private class GenericTextWatcher implements TextWatcher {
        private View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Nếu độ dài của văn bản trong ô là 1, chuyển con trỏ tới ô tiếp theo
            if (charSequence.length() == 1) {
                //them
                editText1.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (s.length() == 1) {
                            editText2.requestFocus();
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });

                editText2.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (s.length() == 1) {
                            editText3.requestFocus();
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });

                editText3.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (s.length() == 1) {
                            editText4.requestFocus();
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });
                //xoá
                editText2.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                            if (editText2.getText().length() == 0) {
                                editText1.requestFocus();
                                return true;
                            }
                        }
                        return false;
                    }
                });

                editText3.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                            if (editText3.getText().length() == 0) {
                                editText2.requestFocus();
                                return true;
                            }
                        }
                        return false;
                    }
                });

                editText4.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                            if (editText4.getText().length() == 0) {
                                editText3.requestFocus();
                                return true;
                            }
                        }
                        return false;
                    }
                });
            }

        }
        @Override
        public void afterTextChanged(Editable editable) {
        }
    }
    public void OnclickImage(ImageView imgv){
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void Onclickbtn(Button btn){
        final Load_Dialog loadDialog = new Load_Dialog(SP_OTP.this);

        String confirm_code = getIntent().getStringExtra("confirm_code");
        String email = getIntent().getStringExtra("Email");
        String password = getIntent().getStringExtra("Password");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("forgot_password".equals(confirm_code)){
                    intent = new Intent(SP_OTP.this, HomeThamGia.class);
                    startActivity(intent);
                }
                else if("sign_up".equals(confirm_code)){
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                if(mAuth.getCurrentUser().isEmailVerified()){
                                    loadDialog.startLoadingDialog();
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            loadDialog.dismissDialog();
                                            intent = new Intent(SP_OTP.this, logout.class);
                                            startActivity(intent);
                                        }
                                    },2000);
                                }
                                else {
                                    loadDialog.startLoadingDialog();
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            loadDialog.dismissDialog();
                                            Toast.makeText(SP_OTP.this,"Hãy xác nhận Email của bạn trước khi đăng nhập!",Toast.LENGTH_SHORT).show();
                                        }
                                    },1000);
                                }
                            }
                            else {
                                Toast.makeText(SP_OTP.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }
            }
        });
    }

}