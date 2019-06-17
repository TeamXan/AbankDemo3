package com.xan.abankdemo3.ui.login;

import android.arch.lifecycle.MutableLiveData;

import com.xan.abankdemo3.base.BaseViewModel;

import javax.inject.Inject;

public class LoginFragmentViewModel extends BaseViewModel<LoginNavigator>{

    public LoginFragmentViewModel() {
    }

    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    public void goLogin(){
        getNavigator().showToast(username.getValue(),password.getValue());

    }
}
