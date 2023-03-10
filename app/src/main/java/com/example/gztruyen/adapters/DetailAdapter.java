package com.example.gztruyen.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.gztruyen.model.ComicModel;

import java.util.List;

public class DetailAdapter extends FragmentStatePagerAdapter {

    public ComicModel comicModel;

    public DetailAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    public void updateData(ComicModel data) {
        this.comicModel = data;
        if(data != null){
            notifyDataSetChanged();
        }
    }
}
