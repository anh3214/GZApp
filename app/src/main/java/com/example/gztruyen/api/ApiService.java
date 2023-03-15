package com.example.gztruyen.api;

import com.example.gztruyen.model.Category;
import com.example.gztruyen.model.ChapterModel1;
import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.model.CommicModel;
import com.example.gztruyen.model.DocumentChap;
import com.example.gztruyen.model.Page;
import com.example.gztruyen.model.QueryResponse;
import com.example.gztruyen.model.TruyenHot;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService{
    @GET("databases/(default)/documents/{type}")
    Call<QueryResponse<ComicModel>> basicIformationComic(
            @Path("type") String collection
    );
    @GET("databases/(default)/documents/{type}/{name}/Chap")
    Call<QueryResponse<DocumentChap>> getAllChap(
            @Path("type") String type,
            @Path("name") String collection
    );
    @GET("databases/(default)/documents/{type}")
    Call<QueryResponse<TruyenHot>> getAllHot(
            @Path("type") String collection
    );

    @GET("/Categories")
    Call<QueryResponse<Category>> getAllCategory();

    @GET("Commics/{type}")
    Call<QueryResponse<CommicModel>> gettAllCommic(
            @Path("type") int type
    );
    @GET("Chapters/{commic}")
    Call<QueryResponse<ChapterModel1>> getAllChapByCommic(
            @Path("commic") int commic
    );
    @GET("Pages/{chap}")
    Call<QueryResponse<Page>> getPage(
            @Path("chap") int chap
    );
}
