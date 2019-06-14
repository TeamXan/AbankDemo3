package com.xan.abankdemo3.Splash;

import android.arch.lifecycle.ViewModel;

import com.xan.abankdemo3.Module.StringTwo;
import com.xan.abankdemo3.TestTwo;
import com.xan.abankdemo3.base.BaseViewModel;

import javax.inject.Inject;

public class SplashViewModel extends BaseViewModel<Navigator> {
    String str;

    @Inject
    public SplashViewModel(@StringTwo String string) {
        str = string;

    }
    public void start(String testtwo){
        getNavigator().openToast(testtwo);

    }

}
