package com.example.gztruyen.ui.truyentranh;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class TruyenTranhViewModel extends ViewModel {
    private final ArrayList<String> mText;

    public TruyenTranhViewModel() {
        mText = new ArrayList<String>();
        mText.add("https://firebasestorage.googleapis.com/v0/b/appproject-61e7e.appspot.com/o/TruyenTranh%2FNaruto%2FAvatar%2Fanh_1.jpg?alt=media&token=06c06a6d-295a-4f91-8eaa-25266fb04bfb");
        mText.add("https://firebasestorage.googleapis.com/v0/b/appproject-61e7e.appspot.com/o/TruyenTranh%2FTaKhongPhaiconCungCuaVanKhi%2FAvatar%2Fta-khong-phai-con-cung-cua-khi-van.jpg?alt=media&token=508da9be-d10a-45e3-aa5d-7b2019631186");
        mText.add("https://firebasestorage.googleapis.com/v0/b/appproject-61e7e.appspot.com/o/TruyenTranh%2FTaKhongPhaiconCungCuaVanKhi%2FAvatar%2Fta-khong-phai-con-cung-cua-khi-van.jpg?alt=media&token=508da9be-d10a-45e3-aa5d-7b2019631186");
    }

    public ArrayList<String> getText() {
        return mText;
    }
}
