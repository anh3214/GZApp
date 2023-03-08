package com.example.gztruyen.ui.userdetail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.gztruyen.Activity.userDetailActivity.MyMangaAdapter;
import com.example.gztruyen.R;
import com.google.android.material.tabs.TabLayout;

public class UserDetailFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private EditText username;
    private Button btnChangeName;
    private ImageView avatar;

    private void bindingView(View view){
        tabLayout = view.findViewById(R.id.tabLayout2);
        viewPager = view.findViewById(R.id.viewPaper2);
        username = view.findViewById(R.id.edtUserName);
        btnChangeName = view.findViewById(R.id.btnChangeName);
        avatar = view.findViewById(R.id.userAvatar);
    }

    private void bindingAction(View view){

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_user_detail, container, false);
        bindingView(rootView);
        bindingAction(rootView);

        MyMangaAdapter myMangaAdapter = new MyMangaAdapter(requireActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(myMangaAdapter);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}