package com.example.myapplication.Presentation.Onboarding.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ShareActionProvider;

import com.example.myapplication.Presentation.ButtonNavigation.ViewPageAdapter;
import com.example.myapplication.Presentation.LoginAccout.HomeThamGia;
import com.example.myapplication.R;

import me.relex.circleindicator.CircleIndicator;

public class OnBoarding extends AppCompatActivity {
    Button btn_skip,btn_continue, btn_start;
    ViewPager viewPager;
    CircleIndicator circleIndicator;

    ViewPageOnboardingAdapter viewPageOnboardingAdapter;
    LinearLayout LL_1,LL_2;

    SharedPreferences sharedPreferences;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_hung_activity_on_boarding);

        initUI();

        viewPageOnboardingAdapter = new ViewPageOnboardingAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPageOnboardingAdapter);

        circleIndicator.setViewPager(viewPager);

        btn();
        viewpage();


    }
    private void initUI(){
        btn_continue = findViewById(R.id.btn_continue);
        btn_skip = findViewById(R.id.btn_skip);
        btn_start = findViewById(R.id.btn_start);
        viewPager = findViewById(R.id.vpg_Onboarding);
        circleIndicator = findViewById(R.id.circlein_dicator);
        LL_1 = findViewById(R.id.LL_1);
        LL_2 = findViewById(R.id.LL_2);

    }
    public void btn(){
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem()<2){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    if (viewPager.getCurrentItem()==2){
                        animation = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.bottom_anim);
                        LL_2.setAnimation(animation);
                        LL_2.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoarding.this, HomeThamGia.class);
                startActivity(intent);
            }
        });

    }
    public void viewpage(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2){
                    LL_1.setVisibility(View.GONE);
                    LL_2.setVisibility(View.VISIBLE);
                }
                else {
                    LL_1.setVisibility(View.VISIBLE);
                    LL_2.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}