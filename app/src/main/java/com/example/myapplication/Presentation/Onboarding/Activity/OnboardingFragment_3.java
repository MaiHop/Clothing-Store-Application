package com.example.myapplication.Presentation.Onboarding.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class OnboardingFragment_3 extends Fragment {

    View mView;
    public OnboardingFragment_3(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_onboarding_3, container, false);
        return mView;
    }
    private void initUI(){

    }
}