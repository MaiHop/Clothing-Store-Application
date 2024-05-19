package com.example.myapplication.SharedPreferences;

import android.content.Context;

import com.example.myapplication.Model2.KhachHang;

public class DataLocalManager {

    private static final String PREF_FIRST_INSTALL = "PREF_FIRST_INSTALL";
    private static final String USER = "USER";

    private static DataLocalManager instance;
    private MySharedPreferences mySharedPreferences;

    public static void init(Context context){
        instance = new DataLocalManager();
        instance.mySharedPreferences = new MySharedPreferences(context);
    }

    public static DataLocalManager getInstance(){
        if (instance == null){
            instance = new DataLocalManager();
        }
        return instance;
    }

    public static void setFirstInstall( boolean isFirst){
        DataLocalManager.getInstance().mySharedPreferences.putBooleanValue(PREF_FIRST_INSTALL, isFirst);
    }

    public static boolean getFirstInstall(){
        return DataLocalManager.getInstance().mySharedPreferences.getBooleanValue(PREF_FIRST_INSTALL);
    }
    public static void setUser(KhachHang khachHang){
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(USER, khachHang);
    }
    public static KhachHang getUser(){
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(USER);
    }
}
