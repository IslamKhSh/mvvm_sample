package com.islamkhsh.mvvmsample.ui.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.islamkhsh.mvvmsample.data.AppRepository;
import com.islamkhsh.mvvmsample.data.RepositoryHelper;

/**
 * Created by ESLAM on 12/25/2018.
 */

public class BaseViewModel extends AndroidViewModel {

    private RepositoryHelper repositoryHelper;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        this.repositoryHelper = AppRepository.getInstance();
    }

    protected RepositoryHelper getRepositoryHelper() {
        return repositoryHelper;
    }
}
