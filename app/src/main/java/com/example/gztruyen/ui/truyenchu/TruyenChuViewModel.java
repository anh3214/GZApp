package com.example.gztruyen.ui.truyenchu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class TruyenChuViewModel extends ViewModel {
    private final ArrayList<String> mText;

    public TruyenChuViewModel() {
        mText = new ArrayList<String>();
        mText.add("https://firebasestorage.googleapis.com/v0/b/appproject-61e7e.appspot.com/o/TruyenChu%2FThuyHu%2FAvatar%2Fthhuyhu.jpg?alt=media&token=69e1fc50-eb5b-4bb5-8bf4-c9db22793351");
        mText.add("https://firebasestorage.googleapis.com/v0/b/appproject-61e7e.appspot.com/o/TruyenChu%2FTamQuocDienNghia%2FAvatar%2Ftamquocdiennghia.jpg?alt=media&token=1c7e2a94-3ee8-4f1d-86a0-25ac5793849d");
        mText.add("https://firebasestorage.googleapis.com/v0/b/appproject-61e7e.appspot.com/o/TruyenChu%2FHongLauMong%2FAvatar%2Fhonglaumong.jpg?alt=media&token=bac148d6-c4d2-4554-bd07-0eab1aa59804");
    }

    public ArrayList<String> getText() {
        return mText;
    }
}
