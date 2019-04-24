package com.islamkhsh.mvvmsample.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import com.islamkhsh.mvvmsample.R;
import com.islamkhsh.mvvmsample.common.Constants;
import com.islamkhsh.mvvmsample.data.remote.model.Repo;

/**
 * Created by ESLAM on 12/27/2018.
 */

public class RepoAdapter extends RecyclerView.Adapter<RepoViewHolder> {

    private Context context;
    private List<Repo> repoList;

    public RepoAdapter(Context context, List<Repo> repoList) {
        this.context = context;
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if (viewType == Constants.FIRST_ROW)
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_repo_first_item, parent,
                    false);
        else
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_repo_item, parent,
                    false);

        return new RepoViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.repoName.setText(repoList.get(position).getName());
        holder.repoDescription.setText(repoList.get(position).getDescription());
        holder.repoOwnerUserName.setText(" " + repoList.get(position).getOwner().getLogin());

        if (repoList.get(position).getFork())
            holder.repoContainer.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.white));
        else
            holder.repoContainer.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_green_dark));

        holder.setCurrentRepo(repoList.get(position));

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return Constants.FIRST_ROW;
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

}
