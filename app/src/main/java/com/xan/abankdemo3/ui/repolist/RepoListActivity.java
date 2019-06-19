package com.xan.abankdemo3.ui.repolist;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.xan.abankdemo3.BR;
import com.xan.abankdemo3.R;
import com.xan.abankdemo3.Utils.ViewModelFactory;
import com.xan.abankdemo3.base.BaseActivity;
import com.xan.abankdemo3.databinding.RepolistLayoutBinding;
import com.xan.abankdemo3.databinding.UserlistLayoutBinding;
import com.xan.abankdemo3.model.Users;
import com.xan.abankdemo3.ui.login.LoginActivity;
import com.xan.abankdemo3.ui.userlist.UserListAdapter;
import com.xan.abankdemo3.ui.userlist.UserListViewModel;

import java.util.List;

import javax.inject.Inject;

public class RepoListActivity extends BaseActivity<RepolistLayoutBinding,RepoListViewModel> {

    @Inject
    RepoListAdapter repoListAdapter;
    @Inject
    LinearLayoutManager mLayoutManager;
    RepolistLayoutBinding repolistLayoutBinding;
    @Inject
    ViewModelFactory factory;
    private RepoListViewModel repoListViewModel;
    public static Intent newIntent(Context context) {
        return new Intent(context, RepoListActivity.class);
    }
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.repolist_layout;
    }

    @Override
    public RepoListViewModel getViewModel() {

        repoListViewModel = ViewModelProviders.of(this,factory).get(RepoListViewModel.class);
        return repoListViewModel;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repolistLayoutBinding = getViewDataBinding();
        setUp();
        subscribeToLiveData();
    }



    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        repolistLayoutBinding.repoItem.setLayoutManager(mLayoutManager);
        repolistLayoutBinding.repoItem.setItemAnimator(new DefaultItemAnimator());
        repolistLayoutBinding.repoItem.setAdapter(repoListAdapter);
    }

    private void subscribeToLiveData() {
        repoListViewModel.getRepos().observe(this,
                repoItemViewModels -> repoListViewModel
                        .addRepoItemsToList(repoItemViewModels));
    }
}
