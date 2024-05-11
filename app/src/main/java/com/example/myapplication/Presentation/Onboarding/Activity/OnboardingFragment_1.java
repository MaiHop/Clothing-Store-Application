package com.example.myapplication.Presentation.Onboarding.Activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

public class OnboardingFragment_1 extends Fragment {
    View mView;
    public OnboardingFragment_1(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_onboarding_1, container, false);
        return mView;
    }
}