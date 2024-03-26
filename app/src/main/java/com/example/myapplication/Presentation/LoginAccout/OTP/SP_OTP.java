package com.example.myapplication.Presentation.LoginAccout.OTP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;

public class SP_OTP extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sup_otp);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        editText1.addTextChangedListener(new GenericTextWatcher(editText1));
        editText2.addTextChangedListener(new GenericTextWatcher(editText2));
        editText3.addTextChangedListener(new GenericTextWatcher(editText3));
        editText4.addTextChangedListener(new GenericTextWatcher(editText4));
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

}