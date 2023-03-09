package com.example.gztruyen.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.gztruyen.R;
import com.example.gztruyen.adapters.ViewMangaDetailAdapter;
import com.google.android.material.tabs.TabLayout;

public class MangaDetailActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView imageView;

    private void bindingView(){
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPaper);
        imageView = findViewById(R.id.imageView4);
    }

    private void bindingAction(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_detail);
        bindingView();
        bindingAction();

        ViewMangaDetailAdapter mangaDetailAdapter = new ViewMangaDetailAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(mangaDetailAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //imageView
    }

}