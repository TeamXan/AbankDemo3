package com.xan.abankdemo3.ui.repolist;

import android.databinding.ObservableField;


public class RepoItemViewModel {
    public final ObservableField<String> forks = new ObservableField<>();

    public final ObservableField<String> stars = new ObservableField<>();



    public RepoItemViewModel(String forks, String stars) {
        this.forks.set(forks);
        this.stars.set(stars);

    }
}
