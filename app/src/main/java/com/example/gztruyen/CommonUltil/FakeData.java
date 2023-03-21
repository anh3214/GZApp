package com.example.gztruyen.CommonUltil;

import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.model.PageComic;

import java.util.ArrayList;
import java.util.List;

public class FakeData {

    private static FakeData instance;

    public static FakeData getInstance(){
        if(instance == null)
            instance = new FakeData();
        return instance;
    }
    public List<String> fakeListPageComic(){
        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 35; i++) {
//            list.add(
//                    ("https://www.kotaku.com.au/wp-content/uploads/sites/3/2022/11/30/reading-manga-one-punch-man.png")
//            );
//        }
        return list;
    }

    public List<ComicModel> fakeDataComic() {
        List<ComicModel> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            ComicModel c = new ComicModel("12" + i, null, "test des", "bac");
//            list.add(c);
//        }
        return list;
    }
}
