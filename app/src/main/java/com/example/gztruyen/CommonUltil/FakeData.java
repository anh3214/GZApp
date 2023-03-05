package com.example.gztruyen.CommonUltil;

import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.model.PageComic;

import java.util.ArrayList;
import java.util.List;

public class FakeData {
    public List<PageComic> fakeListPageComic(){
        List<PageComic> list = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            list.add(
                    new PageComic("https://www.kotaku.com.au/wp-content/uploads/sites/3/2022/11/30/reading-manga-one-punch-man.png")
            );
        }
        return list;
    }

    public List<PageComic> fakeListNextPageComic(){
        List<PageComic> list = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            list.add(
                    new PageComic("https://www.wikihow.com/images_en/thumb/5/5c/Read-Manga-Step-12.jpg/v4-460px-Read-Manga-Step-12.jpg.webp")
            );
        }
        return list;
    }

    public List<ComicModel> fakeDataComic() {
        List<ComicModel> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ComicModel c = new ComicModel("12" + i, null, "test des", "bac");
            list.add(c);
        }
        return list;
    }
}
