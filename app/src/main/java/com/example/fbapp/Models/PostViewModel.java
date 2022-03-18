package com.example.fbapp.Models;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fbapp.Data.PostsClient;
import com.example.fbapp.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;

import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
   public MutableLiveData<List<PostModel>> postsMutableliveData= new MutableLiveData<>();
String TAG="aboud";
    public void getPosts()
    {
   /*    Observable<List<PostModel>> observable =PostsClient.getGetInstane().getPosts().
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o->postsMutableliveData.setValue(o)
                ,error-> Log.d("aboud", "Erroris: " +error.getMessage()));*/

        Single<List<PostModel>> observable =PostsClient.getGetInstane().getPosts().
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o->postsMutableliveData.setValue(o)
                ,error-> Log.d("aboud", "Erroris: " +error.getMessage()));

        //one way
       /* Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                postsMutableliveData.setValue((List<PostModel>)o);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };*/
        //Scend way
      /*  Observer<List<PostModel>> observer = new Observer<List<PostModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<PostModel> postModels) {
                postsMutableliveData.setValue(postModels);
            }

            @Override
            public void onError(@NonNull Throwable e) {
 System.out.println("Error is "+e.getMessage());
                Log.d("Aboud", "onError:"+ e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };*/
        //   observable.subscribe(observer);
    }
}
