package com.example.gztruyen.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.gztruyen.R;
import com.example.gztruyen.adapters.BangXepHangAdapter;
import com.example.gztruyen.adapters.ViewMangaDetailAdapter;
import com.google.android.material.tabs.TabLayout;

public class activity_bangxephang extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    private void bindingView(){
        tabLayout = findViewById(R.id.tabLayoutBxh);
        viewPager = findViewById(R.id.viewPaperBxh);
    }

    private void bindingAction(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangxephang);
        bindingView();
        bindingAction();


        BangXepHangAdapter bangXepHangAdapter = new BangXepHangAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(bangXepHangAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}