package com.example.myapplication.Presentation.Accout_Setting.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

public class MyProfile extends AppCompatActivity {
    ImageView img_Avata,img_pack_myprofile;
    TextView txtip_fullname,txtip_email;

    Spinner spinnerGender;
    EditText DP_Data;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser mUser = mAuth.getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_my_profile);
        init();

        Picasso.get().load(mUser.getPhotoUrl().toString()).into(img_Avata);
        txtip_fullname.setText(mUser.getDisplayName());
        txtip_email.setText(mUser.getEmail());
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedGender = parent.getItemAtPosition(position).toString();
                // Sử dụng giá trị đã chọn ở đây
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Xử lý khi không có mục nào được chọn
            }
        });
        DP_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        img_pack_myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Xử lý khi người dùng chọn ngày tháng năm
                String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                DP_Data.setText(selectedDate);
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    private void init(){
        img_Avata = findViewById(R.id.img_Avata);
        txtip_fullname = findViewById(R.id.txtip_fullname);
        txtip_email = findViewById(R.id.txtip_email);
        spinnerGender = findViewById(R.id.spin_gender);
        img_pack_myprofile = findViewById(R.id.img_pack_myprofile);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);
        DP_Data = findViewById(R.id.DP_Data);

    }
    public void updateProfile(String newName, Uri newPhotoUri) {

        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(newName)
                .setPhotoUri(newPhotoUri)
                .build();

        mUser.updateProfile(profileUpdates)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        
                    }
                });
    }
}