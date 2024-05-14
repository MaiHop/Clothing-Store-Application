package com.example.myapplication.Presentation.PhucHoi.Activity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class RangeSeekBar extends androidx.appcompat.widget.AppCompatSeekBar {
    private int mMinValue;
    private int mMaxValue;
    private int mCurrentValue;

    public RangeSeekBar(Context context) {
        super(context);
    }

    public RangeSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RangeSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setRange(int minValue, int maxValue) {
        mMinValue = minValue;
        mMaxValue = maxValue;
    }

    public void setCurrentValue(int value) {
        mCurrentValue = value;
        setProgress(value - mMinValue);
    }

    @Override
    public synchronized void setProgress(int progress) {
        super.setProgress(progress);
        mCurrentValue = progress + mMinValue;
    }

    public int getCurrentValue() {
        return mCurrentValue;
    }
}
