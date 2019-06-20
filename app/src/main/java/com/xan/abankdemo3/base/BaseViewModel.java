package com.xan.abankdemo3.base;

import android.arch.lifecycle.ViewModel;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<N> extends ViewModel {
   // private CompositeDisposable mCompositeDisposable;
    public BaseViewModel(){

    }

    private WeakReference<N> mNavigator;

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }
   /* @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }
*/
   /* public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }*/
}
