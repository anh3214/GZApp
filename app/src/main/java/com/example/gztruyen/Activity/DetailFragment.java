package com.example.gztruyen.Activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gztruyen.CommonUltil.FakeData;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.ChaptersAdapter;
import com.example.gztruyen.adapters.DetailAdapter;
import com.example.gztruyen.adapters.TopTruyenAdapter;
import com.example.gztruyen.adapters.TruyenTranhAdapter;
import com.example.gztruyen.api.FireStoreApi;
import com.example.gztruyen.model.ChapterModel;
import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.model.DocumentChap;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment {
    private RecyclerView item_truyen;
    private TruyenTranhAdapter adapter;
    private TextView descriptionTitle;

    String type;
    String nameFiel;
    String description;

    public DetailFragment() {
        // Required empty public constructor
    }

    private static DetailFragment instance;
    public static DetailFragment getInstance(){
        if(instance == null)
            instance = new DetailFragment();
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = instance.getArguments();
        type = b.getString("type");
        nameFiel = b.getString("name");
        description = b.getString("description");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        bindingView(rootView);
        bindingAction(rootView);

         adapter = new TruyenTranhAdapter();
        adapter.updateData(getTruyen(adapter));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(),3);
        item_truyen.setAdapter(adapter);
        item_truyen.setLayoutManager(gridLayoutManager);
        descriptionTitle.setText(description);

        return rootView;
    }
    private List<ComicModel> getTruyen(TruyenTranhAdapter adapter) {
        List<ComicModel> list = FireStoreApi.getAllCommic(adapter);
        return list;

    }
    private void bindingView(View view){
        item_truyen = view.findViewById(R.id.item_truyen);
        descriptionTitle = view.findViewById(R.id.descriptionContent);
    }

    private void bindingAction(View view) {

    }


    public String cutURLName(String name){
        int index = name.lastIndexOf("/") + 1; // t??m v??? tr?? c???a d???u "/" cu???i c??ng
        String result = name.substring(index); // l???y ph???n t??? t??? v??? tr?? ???? ?????n h???t chu???i
        return result;
    }




}