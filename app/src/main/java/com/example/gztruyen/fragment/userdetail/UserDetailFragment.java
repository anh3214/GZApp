package com.example.gztruyen.fragment.userdetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.gztruyen.Activity.LoginActivity;
import com.example.gztruyen.Activity.userDetailActivity.MyMangaAdapter;
import com.example.gztruyen.CommonUltil.Common;
import com.example.gztruyen.CommonUltil.StaticCode;
import com.example.gztruyen.R;
import com.example.gztruyen.fragment.truyentranh.TruyenTranhFragment;
import com.google.android.material.tabs.TabLayout;

public class UserDetailFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private EditText username;
    private Button btnChangeName;
    private Button btnLogout;
    private ImageView avatar;
    private boolean isLogin;

    private void bindingView(View view) {
        isLogin = Common.getInstance().checkIsLogin(view.getContext());
        tabLayout = view.findViewById(R.id.tabLayout2);
        viewPager = view.findViewById(R.id.viewPaper2);
        username = view.findViewById(R.id.edtUserName);
        btnChangeName = view.findViewById(R.id.btnChangeName);
        avatar = view.findViewById(R.id.userAvatar);
        btnLogout = view.findViewById(R.id.btnLogout);
        username.setEnabled(false);
        username.setText("Hello, user");
        if (!isLogin) {
            btnChangeName.setText("Login");
            btnLogout.setEnabled(false);
            btnLogout.setVisibility(View.INVISIBLE);
        } else {
            username.setText(Common
                    .getInstance()
                    .getDataFromPref(view.getContext(), StaticCode.USERNAME)
                    .toString());
            btnChangeName.setText("Đổi tên");
            btnLogout.setEnabled(true);
            btnLogout.setVisibility(View.VISIBLE);
        }
    }

    private void bindingAction(View view) {
        btnChangeName.setOnClickListener(this::loginOrChangeName);
        btnLogout.setOnClickListener(this::logoutOnClick);
    }

    private void logoutOnClick(View view) {
        Common.getInstance().logout(view.getContext());
        Toast.makeText(view.getContext(), "Logged out successfully!", Toast.LENGTH_SHORT).show();
        username.setText("Hello, user");
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .attach(new TruyenTranhFragment())
                .disallowAddToBackStack()
                .commitNow();
        btnChangeName.setText("Login");
        btnLogout.setEnabled(false);
        btnLogout.setVisibility(View.INVISIBLE);
        Intent i = new Intent(view.getContext(), LoginActivity.class);
        startActivity(i);
    }

    private void loginOrChangeName(View view) {
        if (isLogin) {

        } else {
            Intent i = new Intent(view.getContext(), LoginActivity.class);
            startActivity(i);
        }
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