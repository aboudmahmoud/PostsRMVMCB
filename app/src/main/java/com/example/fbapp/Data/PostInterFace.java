package com.example.fbapp.Data;

import com.example.fbapp.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterFace {
    @GET("posts")
    public Observable<List<PostModel>> getposts();
}
