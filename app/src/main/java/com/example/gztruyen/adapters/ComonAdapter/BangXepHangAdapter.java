package com.example.gztruyen.adapters.ComonAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.gztruyen.fragment.BangXHFragment;

public class BangXepHangAdapter extends FragmentStatePagerAdapter{

    public BangXepHangAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new BangXHFragment(0);
            case 1:
                return new BangXHFragment(1);
            default:
                return new BangXHFragment(0);
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "TRUYỆN TRANH";
                break;
            case 1:
                title = "TIỂU THUYẾT";
                break;
        }
        return title;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
