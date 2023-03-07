package com.example.gztruyen.Activity.userDetailActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.gztruyen.Activity.ChaptersFragment;
import com.example.gztruyen.Activity.DetailFragment;

public class MyMangaAdapter extends FragmentStatePagerAdapter {
    public MyMangaAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HistoryFragment();
            case 1:
                return new FollowFragment();

            default:
                return new HistoryFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Lịch sử";
                break;
            case 1:
                title = "Theo dõi";
                break;
        }
        return title;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
