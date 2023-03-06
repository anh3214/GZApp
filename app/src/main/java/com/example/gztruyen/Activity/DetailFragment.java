package com.example.gztruyen.Activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gztruyen.R;
import com.example.gztruyen.adapters.ChaptersAdapter;
import com.example.gztruyen.adapters.TruyenTranhAdapter;
import com.example.gztruyen.model.ChapterModel;
import com.example.gztruyen.model.ComicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView item_truyen;
    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        bindingView(rootView);
        bindingAction(rootView);

        TruyenTranhAdapter adapter = new TruyenTranhAdapter(getTruyen());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(),3);
        item_truyen.setAdapter(adapter);
        item_truyen.setLayoutManager(gridLayoutManager);

        return rootView;
    }
    private List<ComicModel> getTruyen() {
//        List<ComicModel> models = new ArrayList<>();
//        ComicModel modelTruyen = new ComicModel("ẤDSD","Tiên Tôn Hổ","ádadsasd","https://bit.ly/2YoJ77H");
//        ComicModel modelTruyen1 = new ComicModel("ẤDSD","Voi Tu Tiên","ádadsasd","https://bit.ly/2BteuF2");
//        ComicModel modelTruyen2 = new ComicModel("ẤDSD","Pháp Sư bí Ẩn","ádadsasd","https://bit.ly/3fLJf72");
//        ComicModel modelTruyen3 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/173/chuyen-sinh-thanh-kiem.jpg");
//        ComicModel modelTruyen4 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/138/bong-mot-ngay-xuyen-thanh-hoang-hau-ac-d-7720.jpg");
//        ComicModel modelTruyen5 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/183/chuyen-khong-the.jpg");
//        ComicModel modelTruyen6 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/54/1001-cach-chinh-phuc-chong-yeu.jpg");
//        ComicModel modelTruyen7 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/72/tu-luc-bat-dau-lien-vo-dich.jpg");
//        ComicModel modelTruyen8 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/177/quyet-chien.jpg");
//
//        models.add(modelTruyen);
//        models.add(modelTruyen1);
//        models.add(modelTruyen2);
//        models.add(modelTruyen3);
//        models.add(modelTruyen4);
//        models.add(modelTruyen5);
//        models.add(modelTruyen6);
//        models.add(modelTruyen7);
//        models.add(modelTruyen8);
        return new ArrayList<>();
    }
    private void bindingView(View view){
        item_truyen = view.findViewById(R.id.item_truyen);
    }

    private void bindingAction(View view) {

    }
}