package com.islamkhsh.mvvmsample.data;


import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.islamkhsh.mvvmsample.data.remote.AppRemote;
import com.islamkhsh.mvvmsample.data.remote.RemoteHelper;
import com.islamkhsh.mvvmsample.data.remote.model.Repo;

import java.util.List;

/**
 * Created by ESLAM on 12/25/2018.
 */

public class AppRepository implements RepositoryHelper {

    //for singleton
    private static final Object LOCK = new Object();
    private static volatile AppRepository sInstance;
    private RemoteHelper remote;

    public static AppRepository getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new AppRepository();
                }
            }
        }
        return sInstance;
    }

    private AppRepository() {
        this.remote = AppRemote.getInstance();
    }



    @Override
    public MutableLiveData<List<Repo>> getRepoList(String userName) {
        return remote.getRepoList(userName);
    }


}
