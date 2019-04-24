package com.islamkhsh.mvvmsample.ui.activity.main;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import com.islamkhsh.mvvmsample.data.remote.model.Repo;
import com.islamkhsh.mvvmsample.ui.base.BaseViewModel;

/**
 * Created by ESLAM on 12/25/2018.
 */

public class MainViewModel extends BaseViewModel  {


    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Repo>> getRepoList(String userName) {
        return getRepositoryHelper().getRepoList(userName);
    }
}
