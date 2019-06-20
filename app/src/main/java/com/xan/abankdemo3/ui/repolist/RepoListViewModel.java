package com.xan.abankdemo3.ui.repolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.xan.abankdemo3.base.BaseViewModel;
import com.xan.abankdemo3.model.Repository;
import com.xan.abankdemo3.model.ReturnDataRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class RepoListViewModel extends BaseViewModel {

    private final ReturnDataRepository returnDataRepository;
    private CompositeDisposable disposable;
   private final ObservableList<Repository> repoObservableArrayList = new ObservableArrayList<>();

    private final MutableLiveData<List<Repository>> repoLivedata ;
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public RepoListViewModel(ReturnDataRepository returnDataRepository) {
        this.returnDataRepository = returnDataRepository;
        disposable = new CompositeDisposable();
        repoLivedata = new MutableLiveData<>();
        fetchRepos();
    }


    public void addRepoItemsToList(List<Repository> repos) {
        repoObservableArrayList.clear();
        repoObservableArrayList.addAll(repos);
        //repoObservableArrayList.size();
        Log.i("Array list",""+repoObservableArrayList.size());

    }

    private void fetchRepos() {
        loading.setValue(true);
        disposable.add(returnDataRepository.getRepositories().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<Repository>>() {
                    @Override
                    public void onSuccess(List<Repository> value) {
                        repoLoadError.setValue(false);
                        repoLivedata.setValue(value);
                        loading.setValue(false);



                    }

                    @Override
                    public void onError(Throwable e) {

                        repoLoadError.setValue(true);
                        loading.setValue(false);

                    }
                }));
    }
    public MutableLiveData<List<Repository>> getRepoListLiveData() {
        return repoLivedata;
    }
    public ObservableList<Repository> getRepoObservableArrayList(){
        return repoObservableArrayList;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }

}
