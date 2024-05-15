package com.example.myapplication.Presentation.Accout_Setting.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Model.KhachHang;
import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.Presentation.LoginAccout.SingUp.sign_up;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MyProfile extends AppCompatActivity {
    ImageView img_Avata,img_pack_myprofile;
    TextView txtip_fullname,txtip_email,txtip_phone;

    Spinner spinnerGender;
    EditText DP_Data;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser mUser = mAuth.getCurrentUser();
    FirebaseFirestore database = FirebaseFirestore.getInstance();

    private static final int PICK_IMAGE_REQUEST = 1;
    Uri mImageUri;

    Button btn_image;



    Button btn_UPdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_my_profile);
        init();

        loadUserData();
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

        btn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        btnUpdate();


    }
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            mImageUri = data.getData();
            Picasso.get().load(mImageUri).into(img_Avata);
        }
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
        btn_UPdate = findViewById(R.id.btn_saveUpdate);
        txtip_phone = findViewById(R.id.txtip_phone);
        btn_image = findViewById(R.id.btn_image);
    }

    public void updateProfile(String newName) {

        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(newName)
//                .setPhotoUri(newPhotoUri)
                .build();
        mUser.updateProfile(profileUpdates)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        KhachHang khachHang = new KhachHang();
                        khachHang.setTen(mUser.getDisplayName());
//                        khachHang.setGioiTinh(newGender);
                        database.collection("KhachHang").document(khachHang.getIdKhachHang())
                                .set(khachHang)
                                .addOnSuccessListener(aVoid -> {
                                    Log.d("Firestore", "DocumentSnapshot successfully written!");
                                })
                                .addOnFailureListener(e -> {
                                    Log.e("Firebase", "Failed to write user to database", e);
                                });
                    }
                });
    }

//    public void updateFirestoreDetails(String userId, int gender) {
//        KhachHang khachHang = new KhachHang();
//        khachHang.setGioiTinh(gender);
//        database.collection("KhachHang").document(userId)
//                .set(khachHang)
//                .addOnSuccessListener(aVoid -> Log.d("Firestore", "DocumentSnapshot successfully written!"))
//                .addOnFailureListener(e -> Log.w("Firestore", "Error writing document", e));
//    }
    public void btnUpdate(){
        btn_UPdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = txtip_fullname.getText().toString();
                int newGender = Integer.parseInt(spinnerGender.getSelectedItem().toString());
                updateProfile(newName);
//                updateFirestoreDetails(mUser.getUid(), newGender);
                if (mImageUri != null) {
                    uploadImageToFirebase(mImageUri);
                }
            }
        });
    }
    private void loadUserData() {
        Picasso.get().load(mUser.getPhotoUrl().toString()).into(img_Avata);
        txtip_fullname.setText(mUser.getDisplayName());
        txtip_email.setText(mUser.getEmail());
        if (mUser != null) {
            DocumentReference docRef = database.collection("KhachHang").document(mUser.getUid());
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            // Hiển thị giới tính
//                            String gioiTinhString = document.getString("gioiTinh");
//                            int gender = Integer.parseInt(gioiTinhString);
//                            String genderString;
//                            if (gender == 0) {
//                                genderString = "Nam";
//                            } else {
//                                genderString = "Nữ";
//                            }
//                            int spinnerPosition = ((ArrayAdapter<String>) spinnerGender.getAdapter()).getPosition(genderString);
//                            spinnerGender.setSelection(spinnerPosition);
                        } else {
                            Log.d("Firestore", "No such document");
                        }
                    } else {
                        Log.d("Firestore", "get failed with ", task.getException());
                    }
                }
            });
        }
    }

    private void uploadImageToFirebase(Uri imageUri) {
        if (imageUri != null) {
            StorageReference fileReference = FirebaseStorage.getInstance().getReference("imageUrl")
                    .child(System.currentTimeMillis() + "." + getFileExtension(imageUri));

            fileReference.putFile(imageUri).continueWithTask(task -> {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }
                return fileReference.getDownloadUrl();
            }).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Uri downloadUri = task.getResult();
                    updateFirebaseUserProfile(downloadUri);
                } else {
                    showDialogFailed();
                }
            });
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void updateFirebaseUserProfile(Uri imageUrl) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setPhotoUri(imageUrl)
                    .build();

            user.updateProfile(profileUpdates)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Picasso.get().load(imageUrl).into(img_Avata);
                            Log.d("Firestore", "No such document");
                        } else {
                            Log.d("Firestore", "get failed with ", task.getException());
                        }
                    });
        }
    }

    private void showDialogSuccess() {
        final Dialog successDialog = new Dialog(MyProfile.this);
        successDialog.setContentView(R.layout.cancel_success);

        // Đặt các thuộc tính cho window của dialog mới, giống như bạn đã làm cho dialog hủy đơn
        Window window = successDialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setGravity(Gravity.BOTTOM);
            window.getAttributes().windowAnimations = R.style.DialogAnimation;
        }

        successDialog.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                successDialog.dismiss();
            }
        }, 2000); // Đóng dialog sau 2 giây

    }
    private void showDialogFailed() {
        final Dialog failedDialog = new Dialog(MyProfile.this);
        failedDialog.setContentView(R.layout.c_hung_update_false);

        // Đặt các thuộc tính cho window của dialog mới, giống như bạn đã làm cho dialog hủy đơn
        Window window = failedDialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setGravity(Gravity.BOTTOM);
            window.getAttributes().windowAnimations = R.style.DialogAnimation;
        }

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                failedDialog.dismiss();
            }
        }, 2000); // Đóng dialog sau 2 giây

        failedDialog.show();
    }
}