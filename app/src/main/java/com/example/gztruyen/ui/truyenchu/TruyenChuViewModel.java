package com.example.gztruyen.ui.truyenchu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class TruyenChuViewModel extends ViewModel {
    private final ArrayList<String> mText;

    public TruyenChuViewModel() {
        mText = new ArrayList<String>();
        mText.add("https://bit.ly/2YoJ77H");
        mText.add("https://bit.ly/2BteuF2");
        mText.add("https://bit.ly/3fLJf72");
    }

    public ArrayList<String> getText() {
        return mText;
    }
}
