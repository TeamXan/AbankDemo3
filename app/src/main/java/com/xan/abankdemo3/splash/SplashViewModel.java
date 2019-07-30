package com.xan.abankdemo3.splash;

import com.xan.abankdemo3.base.BaseViewModel;

import javax.inject.Inject;

public class SplashViewModel extends BaseViewModel<Navigator> {

    @Inject
    public SplashViewModel() {

    }
    public void start(){

        getNavigator().openLoginActivity();

    }

}
