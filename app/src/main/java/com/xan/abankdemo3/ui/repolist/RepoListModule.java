package com.xan.abankdemo3.ui.repolist;

import android.support.v7.widget.LinearLayoutManager;


import com.xan.abankdemo3.model.Repository;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class RepoListModule {


    @Provides
    RepoListAdapter provideAdapter() {
        return new RepoListAdapter();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(RepoListActivity repoListActivity) {
        return new LinearLayoutManager(repoListActivity);
    }
}
