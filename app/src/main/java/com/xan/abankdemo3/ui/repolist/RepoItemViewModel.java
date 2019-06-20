package com.xan.abankdemo3.ui.repolist;

import android.databinding.ObservableField;

import com.xan.abankdemo3.model.Repository;


public class RepoItemViewModel {
    public final ObservableField<String> name ;

    public final ObservableField<String> realname ;
    private final Repository repo;

    public RepoItemViewModel(Repository repository) {
        this.repo =repository;
        name = new ObservableField<>(repo.getName());
        realname = new ObservableField<>(repo.getRealname());
    }
}
