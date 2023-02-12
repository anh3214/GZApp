package com.example.gztruyen.ui.truyenchu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TruyenChuViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public TruyenChuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Chu fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
