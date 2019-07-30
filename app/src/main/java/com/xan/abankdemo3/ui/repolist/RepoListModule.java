package com.xan.abankdemo3.ui.repolist;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;


import com.xan.abankdemo3.model.Repository;
import com.xan.abankdemo3.ui.login.LoginFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public  class RepoListModule {

    @Provides
    RepoListAdapter provideAdapter(RepoListViewModel repoListViewModel, LifecycleOwner lifecycleOwner) {
        return new RepoListAdapter(repoListViewModel,lifecycleOwner);
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(RepoListActivity repoListActivity) {
        return new LinearLayoutManager(repoListActivity);
    }

    @Provides
    LifecycleOwner provideLifecycleOwner(RepoListActivity repoListActivity) {

        return repoListActivity;
    }

}