package com.example.myapplication.Presentation.LoginAccout.SingUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Presentation.LoginAccout.ForgotPass.forgot_password;
import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.Presentation.LoginAccout.OTP.SP_OTP;
import com.example.myapplication.Presentation.LoginAccout.SignIn.sign_in;
import com.example.myapplication.R;

public class sign_up extends AppCompatActivity {
    ImageView imagePack;
    TextView tv_sigin;
    Button btn_SignUp;
    Class<?> SP_OTP = SP_OTP.class,
            Home_ThamGia = HomeThamGia.class,
            Sign_in= sign_in.class ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        imagePack=findViewById(R.id.pack_signup);
        tv_sigin = findViewById(R.id.tv_sigin);
        btn_SignUp = findViewById(R.id.btn_SignUp);

        Onclickbtn(btn_SignUp,SP_OTP);
        OnclickImage(imagePack,Home_ThamGia);
        OnclickText(tv_sigin,Sign_in);
    }
    public void Onclickbtn(Button btn, Class<?> class_activity){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sign_up.this,class_activity);
                intent.putExtra("confirm_code", "sign_up");
                startActivity(intent);
            }
        });
    }
    public void OnclickImage(ImageView imgv, Class<?> class_activity){
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sign_up.this,class_activity);
                startActivity(intent);
            }
        });
    }
    public void OnclickText(TextView tv, Class<?> class_activity){
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sign_up.this,class_activity);
                startActivity(intent);
            }
        });
    }

}