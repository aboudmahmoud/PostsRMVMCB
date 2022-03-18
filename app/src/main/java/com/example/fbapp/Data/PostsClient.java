package com.example.fbapp.Data;

import com.example.fbapp.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String baseUrl="https://jsonplaceholder.typicode.com/";
    private PostInterFace postInterFace;
    private static PostsClient getInstane;

    public PostsClient()
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        postInterFace=retrofit.create(PostInterFace.class);
    }

    public static PostsClient getGetInstane() {
        if (getInstane==null)
        {
            getInstane= new PostsClient();
        }
        return getInstane;
    }

    public Observable<List<PostModel>> getPosts()
    {
        return postInterFace.getposts();
    }

}
