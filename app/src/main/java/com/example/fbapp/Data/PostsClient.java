package com.example.fbapp.Data;

import com.example.fbapp.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String baseUrl="https://jsonplaceholder.typicode.com/";
    private PostInterFace postInterFace;
    private static PostsClient getInstane;

    public PostsClient()
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();
        postInterFace=retrofit.create(PostInterFace.class);
    }

    public static PostsClient getGetInstane() {
        if (getInstane==null)
        {
            getInstane= new PostsClient();
        }
        return getInstane;
    }

    public Call<List<PostModel>> getPosts()
    {
        return postInterFace.getposts();
    }

}
