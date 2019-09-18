package com.xan.abankdemo3.ui.repolist;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.xan.abankdemo3.BR;
import com.xan.abankdemo3.R;
import com.xan.abankdemo3.Utils.ViewModelFactory;
import com.xan.abankdemo3.base.BaseActivity;
import com.xan.abankdemo3.databinding.RepolistActivityBinding;
import com.xan.abankdemo3.databinding.RepolistLayoutBinding;


import javax.inject.Inject;

public class RepoListActivity extends BaseActivity<RepolistActivityBinding,RepoListViewModel> {


    @Inject
    ViewModelFactory factory;
    RepolistActivityBinding repolistActivityBinding;
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
        return R.layout.repolist_activity;
    }

    @Override
    public RepoListViewModel getViewModel() {

        repoListViewModel = ViewModelProviders.of(this,factory).get(RepoListViewModel.class);
        return repoListViewModel;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        repolistActivityBinding = getViewDataBinding();
        showFragment();

    }




  private void showFragment() {
      getSupportFragmentManager()
              .beginTransaction()
              .disallowAddToBackStack()
              .add(R.id.screenContainer, RepoListFragment.newInstance(), RepoListFragment.TAG)
              .commit();
  }
}
