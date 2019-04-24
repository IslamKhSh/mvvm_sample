package com.islamkhsh.mvvmsample.data.remote;

import android.arch.lifecycle.MutableLiveData;

import com.islamkhsh.mvvmsample.data.remote.model.Repo;

import java.util.List;

/**
 * Created by ESLAM on 12/25/2018.
 */

public interface RemoteHelper {
    MutableLiveData<List<Repo>> getRepoList(String userName);

}
