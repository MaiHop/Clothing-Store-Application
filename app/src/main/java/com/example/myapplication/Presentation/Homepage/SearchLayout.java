    package com.example.myapplication.Presentation.Homepage;

    import android.content.Context;
    import android.util.AttributeSet;
    import android.view.LayoutInflater;
    import android.widget.EditText;
    import android.widget.ImageView;
    import android.widget.LinearLayout;
    import android.widget.TextView;

    import androidx.annotation.Nullable;

    import com.example.myapplication.R;

    public class SearchLayout extends LinearLayout {
        private ImageView imageViewBack;
        private EditText editTextSearch;
        private ImageView imageViewNotification;
        private TextView textViewTitle;

        public SearchLayout(Context context) {
            super(context);
            init(context);
        }

        public SearchLayout(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public SearchLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context);
        }

        private void init(Context context) {
            LayoutInflater inflater = LayoutInflater.from(context);
            inflater.inflate(R.layout.hoi_search_layout, this);

            // Thêm dòng này để chỉ định rằng bạn đang tìm các thành phần trong layout của chính lớp SearchLayout
            imageViewBack = findViewById(R.id.imageViewBack);
            editTextSearch = findViewById(R.id.editTextText2);
            imageViewNotification = findViewById(R.id.imageView);
            textViewTitle = findViewById(R.id.textView4);
        }


        // Các phương thức getter để truy cập các thành phần UI từ bên ngoài lớp này (nếu cần)
        public ImageView getImageViewBack() {
            return imageViewBack;
        }

        public EditText getEditTextSearch() {
            return editTextSearch;
        }

        public ImageView getImageViewNotification() {
            return imageViewNotification;
        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }
    }