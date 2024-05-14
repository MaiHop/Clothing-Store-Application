package com.example.myapplication.Presentation.Onboarding.Activity;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.R;

public class ViewPageOnboardingAdapter extends FragmentStatePagerAdapter {
    public ViewPageOnboardingAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new OnboardingFragment_1();
            case 1:
                return new OnboardingFragment_2();
            case 2:

                return new OnboardingFragment_3();
            default:
                return new OnboardingFragment_1();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
