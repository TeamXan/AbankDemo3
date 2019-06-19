package com.xan.abankdemo3.ui.repolist;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.xan.abankdemo3.base.BaseViewModel;
import com.xan.abankdemo3.model.Repository;
import com.xan.abankdemo3.model.ReturnDataRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class RepoListViewModel extends BaseViewModel {

    private final ReturnDataRepository returnDataRepository;
    private CompositeDisposable disposable;
    private final ObservableList<RepoItemViewModel> repoItemViewModels = new ObservableArrayList<>();
    private MutableLiveData<List<RepoItemViewModel>> repos = new MutableLiveData<>();


    @Inject
    public RepoListViewModel(ReturnDataRepository returnDataRepository) {
        this.returnDataRepository = returnDataRepository;
        disposable = new CompositeDisposable();
        repos = new MutableLiveData<>();
        fetchRepos();
    }

    public MutableLiveData<List<RepoItemViewModel>> getRepos() {
        return repos;
    }

    public void addRepoItemsToList(List<RepoItemViewModel> repoItemViewModels) {
        repoItemViewModels.clear();
        repoItemViewModels.addAll(repoItemViewModels);
    }
    private void fetchRepos() {

        disposable.add(returnDataRepository.getRepositories().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<Repository>>() {
                    @Override
                    public void onSuccess(List<Repository> value) {
                        repos.setValue(getViewModelList(value));

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }));
    }
    public ObservableList<RepoItemViewModel> getRepoItemViewModels() {
        return repoItemViewModels;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
    public List<RepoItemViewModel> getViewModelList(List<Repository> repoList) {
        List<RepoItemViewModel> repoItemViewModels = new ArrayList<>();
        for (Repository repo : repoList) {
            repoItemViewModels.add(new RepoItemViewModel(
                     String.valueOf(repo.getForks()),
                     String.valueOf(repo.getStars())));
        }
        return repoItemViewModels;
    }
}
