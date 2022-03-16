package com.example.fbapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fbapp.R;
import com.example.fbapp.databinding.PostItemBinding;
import com.example.fbapp.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private List<PostModel> post=new ArrayList<>();


    public void setPosts(List<PostModel> postes)
    {
post=postes;
notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item,parent,false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        PostModel postModel = post.get(position);
        holder.bind(postModel);

    }

    @Override
    public int getItemCount() {
        return post.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder{
private PostItemBinding binding;
private PostModel postModel;
        public PostHolder(@NonNull View itemView) {
            super(itemView);
            binding=PostItemBinding.bind(itemView);
        }

        void bind(PostModel postModel)
        {
            binding.TitleTV.setText(postModel.getTitle());
            binding.bodyTV.setText(postModel.getBody());
            binding.userIDTv.setText(String.valueOf(postModel.getUserId()));

        }
    }
}
