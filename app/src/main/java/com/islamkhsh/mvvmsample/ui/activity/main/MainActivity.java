package com.islamkhsh.mvvmsample.ui.activity.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.islamkhsh.mvvmsample.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.islamkhsh.mvvmsample.data.remote.model.Repo;
import com.islamkhsh.mvvmsample.ui.adapter.RepoAdapter;
import com.islamkhsh.mvvmsample.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.repo_list)
    public RecyclerView recyclerView;

    private MainViewModel mainViewModel;
    private RepoAdapter repoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getUpdatedData();
    }


    @Override
    public void setViewModel() {
        this.mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }


    @Override
    public void getUpdatedData() {
        mainViewModel.getRepoList("square").observe(this, new Observer<List<Repo>>() {
            @Override
            public void onChanged(@Nullable List<Repo> repos) {
                setupRepoRecycler(repos);
            }
        });
    }


    @Override
    public void setupRepoRecycler(List<Repo> repos) {
        repoAdapter = new RepoAdapter(this, repos);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(repoAdapter);
    }

}
