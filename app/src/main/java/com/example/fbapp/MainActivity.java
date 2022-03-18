package com.example.fbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.fbapp.Adapter.PostAdapter;
import com.example.fbapp.Models.PostViewModel;
import com.example.fbapp.databinding.ActivityMainBinding;
import com.example.fbapp.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        postViewModel= new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.getPosts();
        PostAdapter adapter = new PostAdapter();
        binding.RV.setLayoutManager(new LinearLayoutManager(this));
        binding.RV.setAdapter(adapter);
        postViewModel.postsMutableliveData.observe(this,(Observer) (postModels) ->{ adapter.setPosts((List<PostModel>) postModels);} );

    }
}