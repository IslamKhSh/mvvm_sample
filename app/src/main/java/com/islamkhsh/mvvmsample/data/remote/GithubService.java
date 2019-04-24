package com.islamkhsh.mvvmsample.data.remote;

import java.util.List;

import com.islamkhsh.mvvmsample.data.remote.model.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ESLAM on 12/25/2018.
 */

public interface GithubService {

    @GET("users/{user_name}/repos")
    Call<List<Repo>> getAllRepos(@Path("user_name") String userName);

}
