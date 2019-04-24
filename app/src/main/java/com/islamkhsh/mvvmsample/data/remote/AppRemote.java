package com.islamkhsh.mvvmsample.data.remote;


import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import java.util.List;

import com.islamkhsh.mvvmsample.common.Constants;
import com.islamkhsh.mvvmsample.data.remote.model.Repo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ESLAM on 12/25/2018.
 */

public class AppRemote implements RemoteHelper {

    private GithubService githubService;

    //singleton pattern
    private static final Object LOCK = new Object();
    private static volatile AppRemote sInstance;

    public static AppRemote getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new AppRemote();
                }
            }
        }
        return sInstance;
    }

    private AppRemote() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        githubService = retrofit.create(GithubService.class);
    }


    @Override
    public MutableLiveData<List<Repo>> getRepoList(String userName) {
        final MutableLiveData<List<Repo>> responseLiveData = new MutableLiveData<>();

        githubService.getAllRepos(userName).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful())
                    responseLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

        return responseLiveData;
    }
}
