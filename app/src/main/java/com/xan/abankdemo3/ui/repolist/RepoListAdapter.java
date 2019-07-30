package com.xan.abankdemo3.ui.repolist;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.xan.abankdemo3.base.BaseViewHolder;
import com.xan.abankdemo3.databinding.RepoItemBinding;
import com.xan.abankdemo3.model.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class  RepoListAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private final List<Repository> repositoryList = new ArrayList<>();

   /* public void addItems(List<Repository> repository) {
        repositoryList.addAll(repository);
        notifyDataSetChanged();
    }*/

  /*  public void clearItems() {
        repositoryList.clear();
    }*/



   /* public RepoListAdapter(List<Repository> repoResponseList) {
        this.repositoryList = repoResponseList;

    }*/
    @Inject
    public RepoListAdapter(RepoListViewModel viewModel,LifecycleOwner lifecycleOwner) {

        viewModel.getRepoListLiveData().observe(lifecycleOwner, repos -> {
            this.repositoryList.clear();
            if (repos != null) {
                this.repositoryList.addAll(repos);
                notifyDataSetChanged();
            }
        });

    }
    @Override
    public int getItemCount() {
        if (repositoryList != null && repositoryList.size() > 0) {
            return repositoryList.size();
        } else {
            return 1;
        }
    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        RepoItemBinding repoItemBinding = RepoItemBinding
                .inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
        return new RepoItemViewHolder(repoItemBinding);
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }




    public class RepoItemViewHolder extends BaseViewHolder{

        private RepoItemBinding mBinding;

        private RepoItemViewModel repoItemViewModel;



        public RepoItemViewHolder(RepoItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
               /* if(repositoryList.size() == 0){
                    return;
                }*/
                final Repository repository = repositoryList.get(position);
                repoItemViewModel = new RepoItemViewModel(repository);
                mBinding.setViewModel(repoItemViewModel);

                mBinding.executePendingBindings();



        }


    }
}
