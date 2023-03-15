package com.example.gztruyen.fragment.truyentranh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.CommonUltil.FakeData;
import com.example.gztruyen.CommonUltil.StaticCode;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.ComonAdapter.ReadingComicAdapter;
import com.example.gztruyen.api.FireStoreApi;

import java.util.List;

public class FrmComicReading extends Fragment {

    private static FrmComicReading frm;

    public static FrmComicReading getInstance() {
        if (frm == null)
            frm = new FrmComicReading();
        return frm;
    }

    private RecyclerView rcvComicPage;
    private Bundle bundle;
    private String chap;
    private String nameComic;
    private int maxSize;

    private static final String BASE_URL = "gs://appproject-61e7e.appspot.com/TruyenTranh/";

    public FrmComicReading() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frm_comic_reading, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindingView(view);
        bindingAction(view);

        List<String> list = FakeData.getInstance().fakeListPageComic();

        ReadingComicAdapter adapter = new ReadingComicAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        rcvComicPage.setAdapter(adapter);
        rcvComicPage.setLayoutManager(layoutManager);
        FireStoreApi.getUrlImage(nameComic,
                adapter,
                ""
        );
    }

    private void bindingAction(View view) {
    }

    private void bindingView(View view) {
        bundle = getArguments();
        if (bundle != null) {
            nameComic = bundle.getString(StaticCode.COMIC_NAME_API);
            getInstance().setArguments(bundle);
        }
        rcvComicPage = view.findViewById(R.id.rcv_read_comic);
    }
}