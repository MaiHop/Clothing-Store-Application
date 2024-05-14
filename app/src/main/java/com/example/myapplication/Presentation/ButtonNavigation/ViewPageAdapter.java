package com.example.myapplication.Presentation.ButtonNavigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.Presentation.Accout_Setting.Activity.Account_Fragment;

import com.example.myapplication.Presentation.Cart.Activity.GioHangFragment;
import com.example.myapplication.Presentation.GH.MainFragment;
import com.example.myapplication.Presentation.PhucHoi.Activity.SanPham_Fragment;
import com.example.myapplication.Presentation.Wishlist.Activity.WishList_Fragment;

public class ViewPageAdapter extends FragmentStatePagerAdapter {
    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SanPham_Fragment();
            case 1:
                return new WishList_Fragment();
            case 2:
                return new GioHangFragment();
            case 3:
                return new MainFragment();
            case 4:
                return new Account_Fragment();
            default:
                return new SanPham_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
