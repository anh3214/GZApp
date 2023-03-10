package com.example.gztruyen.api;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.Activity.DetailFragment;
import com.example.gztruyen.adapters.ApiAdapter;
import com.example.gztruyen.adapters.ChaptersAdapter;
import com.example.gztruyen.adapters.DetailAdapter;
import com.example.gztruyen.adapters.ReadingComicAdapter;
import com.example.gztruyen.adapters.TopTruyenAdapter;
import com.example.gztruyen.adapters.TruyenChuAdapter;
import com.example.gztruyen.adapters.TruyenTranhAdapter;
import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.model.DocumentChap;
import com.example.gztruyen.model.QueryResponse;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FireStoreApi {

    public static List<ComicModel> getAllCommic(TruyenTranhAdapter adapter) {
        List<ComicModel> comicModelss = new ArrayList<>();
        List<String> url = new ArrayList<>();
        ApiAdapter.getInstance().basicIformationComic(new Callback<QueryResponse<ComicModel>>() {
            @Override
            public void onResponse(@NonNull Call<QueryResponse<ComicModel>> call, @NonNull Response<QueryResponse<ComicModel>> response) {
                if (response.isSuccessful()) {
                    QueryResponse<ComicModel> queryResponse = response.body();
                    // Xử lý kết quả trả về ở đây
                    comicModelss.addAll(queryResponse.getDocuments());
                    Log.d("Data", "" + comicModelss.size());
                    if (comicModelss.size() > 0) {
                        adapter.updateData(comicModelss);
                        for (ComicModel comic : comicModelss) {
                            getUrlImage(comic.getFields().getImageShow().getReferenceValue(), adapter, comic.getName());
                        }
                    }
                } else {
                    Log.d("Error", "Get data falseSSE");
                }
            }

            @Override
            public void onFailure(Call<QueryResponse<ComicModel>> call, Throwable t) {
                Log.d("Error", "Get data false: " + t);
            }
        }, "TruyenTranh");
        return comicModelss;
    }

    public static List<ComicModel> getAllStory(TruyenChuAdapter adapter) {
        List<ComicModel> storyModelss = new ArrayList<>();
        ApiAdapter.getInstance().basicIformationComic(new Callback<QueryResponse<ComicModel>>() {
            @Override
            public void onResponse(@NonNull Call<QueryResponse<ComicModel>> call, @NonNull Response<QueryResponse<ComicModel>> response) {
                if (response.isSuccessful()) {
                    QueryResponse<ComicModel> queryResponse = response.body();
                    // Xử lý kết quả trả về ở đây
                    storyModelss.addAll(queryResponse.getDocuments());
                    Log.d("Data Story Size",""+storyModelss.size());
                    if(storyModelss.size() > 0){
                        adapter.updateData(storyModelss);
                        for (ComicModel comic : storyModelss) {
                            getUrlImageStory(comic.getFields().getImageShow().getReferenceValue(), adapter, comic.getName());
                        }
                    }
                } else {
                    Log.d("Error", "Get data falseSSE");
                }
            }

            @Override
            public void onFailure(Call<QueryResponse<ComicModel>> call, Throwable t) {
                Log.d("Error", "Get data false: " + t);
            }
        }, "TruyenChu");
        return storyModelss;
    }

    public static List<DocumentChap> getAllChap(ChaptersAdapter adapter, String type, String name) {

        List<DocumentChap> chaps = new ArrayList<>();
        ApiAdapter.getInstance().getAllChap(new Callback<QueryResponse<DocumentChap>>() {
            @Override
            public void onResponse(Call<QueryResponse<DocumentChap>> call, Response<QueryResponse<DocumentChap>> response) {
                if (response.isSuccessful()) {
                    QueryResponse<DocumentChap> queryResponse = response.body();
                    // Xử lý kết quả trả về ở đây
                    chaps.addAll(
                            queryResponse.getDocuments()
                    );

                    if (chaps.size() > 0) {
                        adapter.setChapterList(chaps);
                    }
                } else {
                    Log.d("Error", "Get data falseSSE");
                }
            }

            @Override
            public void onFailure(Call<QueryResponse<DocumentChap>> call, Throwable t) {
                Log.d("Error", "Get data false: " + t);
            }
        }, type, name);
        return chaps;
    }

    public static List<String> getUrlImage(String path, RecyclerView.Adapter adapter, String name) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl(path); // path thư mục của bạn
        List<Task<Uri>> tasks = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        // Lấy danh sách các file trong thư mục
        Task<ListResult> listTask = storageRef.listAll();
        listTask.addOnSuccessListener(listResult -> {
            // Lấy tất cả các URL ảnh
            for (StorageReference item : listResult.getItems()) {
                Task<Uri> uriTask = item.getDownloadUrl();
                tasks.add(uriTask);
            }

            // Đợi tất cả các nhiệm vụ hoàn thành
            Tasks.whenAllComplete(tasks).addOnSuccessListener(result -> {
                for (Task<Uri> task : tasks) {
                    if (task.isSuccessful()) {
                        urls.add(task.getResult().toString());
                    }
                }
                try {
                    ReadingComicAdapter adapter1 = adapter instanceof ReadingComicAdapter ? ((ReadingComicAdapter) adapter) : null;
                    adapter1.updateAdapter(urls);
                } catch (Exception ex) {
                    TruyenTranhAdapter adapter2 = adapter instanceof TruyenTranhAdapter ? ((TruyenTranhAdapter) adapter) : null;
                    adapter2.updateUrl(urls, name);
                }

                Log.d("Demo", "" + urls);
            });
        });
        return urls;
    }

    public static List<String> getUrlImageStory(String path, RecyclerView.Adapter adapter, String name) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl(path); // path thư mục của bạn
        List<Task<Uri>> tasks = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        // Lấy danh sách các file trong thư mục
        Task<ListResult> listTask = storageRef.listAll();
        listTask.addOnSuccessListener(listResult -> {
            // Lấy tất cả các URL ảnh
            for (StorageReference item : listResult.getItems()) {
                Task<Uri> uriTask = item.getDownloadUrl();
                tasks.add(uriTask);
            }

            // Đợi tất cả các nhiệm vụ hoàn thành
            Tasks.whenAllComplete(tasks).addOnSuccessListener(result -> {
                for (Task<Uri> task : tasks) {
                    if (task.isSuccessful()) {
                        urls.add(task.getResult().toString());
                    }
                }
                try {
                    ReadingComicAdapter adapter1 = adapter instanceof ReadingComicAdapter ? ((ReadingComicAdapter) adapter) : null;
                    adapter1.updateAdapter(urls);
                } catch (Exception ex) {
                    TruyenChuAdapter adapter2 = adapter instanceof TruyenChuAdapter ? ((TruyenChuAdapter) adapter) : null;
                    adapter2.updateUrlStory(urls, name);
                }

                Log.d("Demo", "" + urls);
            });
        });
        return urls;
    }

    public static List<String> getChapter(String path, TruyenTranhAdapter adapter, String name) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl(path); // path thư mục của bạn
        List<Task<Uri>> tasks = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        // Lấy danh sách các file trong thư mục
        Task<ListResult> listTask = storageRef.listAll();
        listTask.addOnSuccessListener(listResult -> {
            // Lấy tất cả các URL ảnh
            for (StorageReference item : listResult.getItems()) {
                Task<Uri> uriTask = item.getDownloadUrl();
                tasks.add(uriTask);
            }

            // Đợi tất cả các nhiệm vụ hoàn thành
            Tasks.whenAllComplete(tasks).addOnSuccessListener(result -> {
                for (Task<Uri> task : tasks) {
                    if (task.isSuccessful()) {
                        urls.add(task.getResult().toString());
                    }
                }
                adapter.updateUrl(urls, name);
                Log.d("Demo", "" + urls);
            });
        });
        return urls;
    }

    public static List<ComicModel> getAllCommicBXH(TopTruyenAdapter adapter){
        List<ComicModel> comicModelss = new ArrayList<>();
        List<String> url = new ArrayList<>();
        ApiAdapter.getInstance().basicIformationComic(new Callback<QueryResponse<ComicModel>>() {
            @Override
            public void onResponse(@NonNull Call<QueryResponse<ComicModel>> call, @NonNull Response<QueryResponse<ComicModel>> response) {
                if (response.isSuccessful()) {
                    QueryResponse<ComicModel> queryResponse = response.body();
                    // Xử lý kết quả trả về ở đây
                    comicModelss.addAll(queryResponse.getDocuments());
                    Log.d("Data",""+comicModelss.size());
                    if(comicModelss.size() > 0){
                        adapter.updateData(comicModelss);
                        for (ComicModel comic: comicModelss) {
                            getUrlImageTopTruyen(comic.getFields().getImageShow().getReferenceValue(), adapter,comic.getName());

                        }
                    }
                } else {
                    Log.d("Error","Get data falseSSE");
                }
            }

            @Override
            public void onFailure(Call<QueryResponse<ComicModel>> call, Throwable t) {
                Log.d("Error","Get data false: " + t);
            }
        },"TruyenTranh");
        return comicModelss;
    }

    public static List<ComicModel> getAllStoryBXH(TopTruyenAdapter adapter){
        List<ComicModel> storyModelss = new ArrayList<>();
        ApiAdapter.getInstance().basicIformationComic(new Callback<QueryResponse<ComicModel>>() {
            @Override
            public void onResponse(@NonNull Call<QueryResponse<ComicModel>> call, @NonNull Response<QueryResponse<ComicModel>> response) {
                if (response.isSuccessful()) {
                    QueryResponse<ComicModel> queryResponse = response.body();
                    // Xử lý kết quả trả về ở đây
                    storyModelss.addAll(queryResponse.getDocuments());
                    Log.d("Data",""+storyModelss.size());
                    if(storyModelss.size() > 0){
                        adapter.updateData(storyModelss);
                        for (ComicModel comic: storyModelss) {
                            getUrlImageTopTruyen(comic.getFields().getImageShow().getReferenceValue(), adapter,comic.getName());
                        }
                    }
                } else {
                    Log.d("Error","Get data falseSSE");
                }
            }

            @Override
            public void onFailure(Call<QueryResponse<ComicModel>> call, Throwable t) {
                Log.d("Error","Get data false: " + t);
            }
        },"TruyenChu");
        return storyModelss;
    }

    public static List<String> getUrlImageTopTruyen(String path, RecyclerView.Adapter adapter, String name){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl(path); // path thư mục của bạn
        List<Task<Uri>> tasks = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        // Lấy danh sách các file trong thư mục
        Task<ListResult> listTask = storageRef.listAll();
        listTask.addOnSuccessListener(listResult -> {
            // Lấy tất cả các URL ảnh
            for (StorageReference item : listResult.getItems()) {
                Task<Uri> uriTask = item.getDownloadUrl();
                tasks.add(uriTask);
            }

            // Đợi tất cả các nhiệm vụ hoàn thành
            Tasks.whenAllComplete(tasks).addOnSuccessListener(result -> {
                for (Task<Uri> task : tasks) {
                    if (task.isSuccessful()) {
                        urls.add(task.getResult().toString());
                    }
                }
                try {
                    ReadingComicAdapter adapter1 = adapter instanceof ReadingComicAdapter ? ((ReadingComicAdapter) adapter) : null;
                    adapter1.updateAdapter(urls);
                }catch (Exception ex){
                    TopTruyenAdapter adapter2 = adapter instanceof TopTruyenAdapter ? ((TopTruyenAdapter) adapter) : null;
                    adapter2.updateUrl(urls,name);
                }

                Log.d("Demo",""+urls);
            });
        });
        return urls;
    }

//    public static void getComic(DetailAdapter adapter, String name, String type){
//        List<ComicModel> comicModelss = new ArrayList<>();
//        List<String> url = new ArrayList<>();
//        ComicModel comicModel = new ComicModel();
//        ApiAdapter.getInstance().basicIformationComic(new Callback<QueryResponse<ComicModel>>() {
//            @Override
//            public void onResponse(@NonNull Call<QueryResponse<ComicModel>> call, @NonNull Response<QueryResponse<ComicModel>> response) {
//                if (response.isSuccessful()) {
//                    QueryResponse<ComicModel> queryResponse = response.body();
//                    // Xử lý kết quả trả về ở đây
//                    comicModelss.addAll(queryResponse.getDocuments());
//                    Log.d("Data",""+comicModelss.size());
//                    if(comicModelss.size() > 0){
//
//                        for (ComicModel c: comicModelss) {
//                            if(c.getFields().getTitle().getStringValue().equals(name)){
//                                Log.d("Get Comic: ", c.getFields().getTitle().getStringValue());
//                                adapter.updateData(c);
//                            }
//                        }
//                    }
//                } else {
//                    Log.d("Error","Get data falseSSE");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<QueryResponse<ComicModel>> call, Throwable t) {
//                Log.d("Error","Get data false: " + t);
//            }
//        },"TruyenTranh");
//    }
}
