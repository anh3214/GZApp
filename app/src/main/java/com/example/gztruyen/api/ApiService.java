package com.example.gztruyen.api;

import com.example.gztruyen.model.Chap;
import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.model.DocumentChap;
import com.example.gztruyen.model.QueryResponse;

import retrofit2.Call;
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

}
