package com.example.myapplication.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myapplication.Model.KhachHang;
import com.google.gson.Gson;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

public class MySharedPreferences {

    private static final String MY_SHARED_PREFERENCES = "MY_SHARED_PREFERENCES";
    private Context mContext;

    public MySharedPreferences(Context mContext) {
        this.mContext = mContext;
    }

    public void putBooleanValue(String key,boolean value){
        SharedPreferences sharedPreferences  = mContext.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBooleanValue(String key){
        SharedPreferences sharedPreferences  = mContext.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        return  sharedPreferences.getBoolean(key,false);
    }

    public void putStringValue(String key,KhachHang khachHang){
        SharedPreferences sharedPreferences  = mContext.getSharedPreferences(MY_SHARED_PREFERENCES,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        String userJSONString = new Gson().toJson(khachHang);
        editor.putString(key, userJSONString);
        editor.apply();
    }
    public KhachHang getStringValue(String key){
        SharedPreferences sharedPreferences  = mContext.getSharedPreferences(MY_SHARED_PREFERENCES,
                Context.MODE_PRIVATE);
        KhachHang khachHang = new KhachHang();
        String userJSONString = sharedPreferences.getString(key, null);
        if (userJSONString != null) {
            return new Gson().fromJson(userJSONString, KhachHang.class);
        }
        return  null;
    }
}
