package com.islamkhsh.mvvmsample.ui.activity.main;

import com.islamkhsh.mvvmsample.data.remote.model.Repo;
import com.islamkhsh.mvvmsample.ui.base.BaseView;

import java.util.List;

/**
 * Created by ESLAM on 12/25/2018.
 */

public interface MainView extends BaseView {
    void setupRepoRecycler(List<Repo> repos);

    void getUpdatedData();


}
