package com.example.myapplication.Presentation.ButtonNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    private BottomNavigationView btn_navigation1;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_home);
        init();
        setUpViewPager();
        btn_navigation1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.PageHome){
                    viewPager.setCurrentItem(0);
                }
                else if (item.getItemId() == R.id.PageWishList) {
                    viewPager.setCurrentItem(1);
                }
                else if (item.getItemId() == R.id.PageCart) {
                    viewPager.setCurrentItem(2);
                }
                else if (item.getItemId() == R.id.PageOrder) {
                    viewPager.setCurrentItem(3);
                }else if (item.getItemId() == R.id.PageAccount) {
                    viewPager.setCurrentItem(4);
                }
                return true;
            }
        });
    }
    private void init(){
        btn_navigation1 = findViewById(R.id.bottom_navigation1);
        viewPager = findViewById(R.id.view_page);
    }
    private void setUpViewPager(){
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPageAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        btn_navigation1.getMenu().findItem(R.id.PageHome).setChecked(true);
                        break;
                    case 1:
                        btn_navigation1.getMenu().findItem(R.id.PageWishList).setChecked(true);
                        break;
                    case 2:
                        btn_navigation1.getMenu().findItem(R.id.PageCart).setChecked(true);
                        break;
                    case 3:
                        btn_navigation1.getMenu().findItem(R.id.PageOrder).setChecked(true);
                        break;
                    case 4:
                        btn_navigation1.getMenu().findItem(R.id.PageAccount).setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}