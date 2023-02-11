package com.example.gztruyen.ui.truyentranh;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TruyenTranhViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public TruyenTranhViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Tranh fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
