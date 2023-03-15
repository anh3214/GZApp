package com.example.gztruyen.adapters.ComonAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.gztruyen.fragment.ChaptersFragment;
import com.example.gztruyen.fragment.DetailFragment;

public class ViewMangaDetailAdapter extends FragmentStatePagerAdapter {
    public ViewMangaDetailAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DetailFragment();
            case 1:
                return new ChaptersFragment();

            default:
                return new DetailFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "thông tin";
                break;
            case 1:
                title = "chapters";
                break;
        }
        return title;
    }


    @Override
    public int getCount() {
        return 2;
    }
}
