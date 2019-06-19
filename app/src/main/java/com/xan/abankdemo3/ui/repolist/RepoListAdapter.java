package com.xan.abankdemo3.ui.repolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.xan.abankdemo3.base.BaseViewHolder;
import com.xan.abankdemo3.databinding.RepoItemBinding;

import java.util.ArrayList;
import java.util.List;

public class RepoListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private final List<RepoItemViewModel> repositoryList;


    public void addItems(List<RepoItemViewModel> repository) {
        repositoryList.addAll(repository);
        notifyDataSetChanged();
    }

    public void clearItems() {
        repositoryList.clear();
    }

    public RepoListAdapter() {
        this.repositoryList = new ArrayList<>();

    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        RepoItemBinding repoItemBinding = RepoItemBinding
                .inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
        return new RepoListAdapter.RepoItemViewHolder(repoItemBinding);
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }


    @Override
    public int getItemCount() {
        if (repositoryList != null && repositoryList.size() > 0) {
            return repositoryList.size();
        } else {
            return 1;
        }
    }

    public class RepoItemViewHolder extends BaseViewHolder{

        private RepoItemBinding mBinding;

        //private RepoItemViewModel repoItemViewModel;



        public RepoItemViewHolder(RepoItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final RepoItemViewModel repoItemViewModel = repositoryList
                    .get(position);
            mBinding.setViewModel(repoItemViewModel);


            mBinding.executePendingBindings();
        }


    }
}
