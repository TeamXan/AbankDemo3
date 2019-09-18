package com.xan.abankdemo3.ui.repolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;
import android.widget.Toast;

import com.xan.abankdemo3.base.BaseViewModel;
import com.xan.abankdemo3.model.Repository;
import com.xan.abankdemo3.model.ReturnDataRepository;
import com.xan.abankdemo3.ui.main.MainActivity;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class RepoListViewModel extends BaseViewModel {
    int count = 0;

    private final ReturnDataRepository returnDataRepository;
    private CompositeDisposable disposable ;
    public final ObservableList<Repository> repoObservableArrayList = new ObservableArrayList<>();

    private final MutableLiveData<List<Repository>> repoLivedata ;
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    Context context;
    @Inject
    public RepoListViewModel(ReturnDataRepository returnDataRepository) {
        this.returnDataRepository = returnDataRepository;
        disposable = new CompositeDisposable();
        repoLivedata = new MutableLiveData<>();

        Log.i("viewmodel","viewmodel");
    }


    public void addRepoItemsToList(List<Repository> repos) {
        repoObservableArrayList.clear();
        repoObservableArrayList.addAll(repos);
        //repoObservableArrayList.size();
        /*Intent intent = MainActivity.newIntent(context);
        intent.putExtra("responsedata", (Serializable) repos);
        context.startActivity(intent);*/
        Log.i("Array list",""+repoObservableArrayList.size());

    }
    LiveData<Boolean> getLoading() {
        return loading;
    }
    LiveData<Boolean> getError() {
        return repoLoadError;
    }
    public void fetchRepos() {
        Log.i("fetchrepo","true"+count++);
       //setIsLoading(true);
        loading.setValue(true);
        disposable.add(returnDataRepository.getRepositories().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<Repository>>() {

                    @Override
                    public void onSuccess(List<Repository> value) {

                        repoLivedata.setValue(value);
                        Log.i("disposable","success");
                        repoLoadError.setValue(false);
                        loading.setValue(false);




                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("disposable","fail");
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