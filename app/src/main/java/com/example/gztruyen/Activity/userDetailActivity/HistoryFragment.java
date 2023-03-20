package com.example.gztruyen.Activity.userDetailActivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gztruyen.CommonUltil.Common;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.HistoryAdapter;
import com.example.gztruyen.dbsqlite.DBContextHistory;
import com.example.gztruyen.model.ChapterModel;

import java.util.Collections;
import java.util.List;


public class HistoryFragment extends Fragment {

    private RecyclerView rcvHistory;

    private DBContextHistory db;

    private boolean isLogin;

    public HistoryFragment() {
        // Required empty public constructor
    }

    private void bindingView(View view){
        rcvHistory = view.findViewById(R.id.rcvHistory);
        db = new DBContextHistory(this.getContext());
        isLogin = Common.getInstance().checkIsLogin(view.getContext());
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
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);
        bindingView(rootView);
        bindingAction(rootView);
        if(isLogin){
            List<ChapterModel> chapHistories = db.listAll();
            Collections.reverse(chapHistories);
//        for(int i = 0; i < 20; i++){
//            chapHistories.add(new ChapterModel((long) i,String.valueOf(R.drawable.img_loading_img),"name"+i, "time"));
//        }
            HistoryAdapter adapter = new HistoryAdapter(chapHistories);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
            rcvHistory.setAdapter(adapter);
            rcvHistory.setLayoutManager(layoutManager);

        }
        return rootView;
    }
}