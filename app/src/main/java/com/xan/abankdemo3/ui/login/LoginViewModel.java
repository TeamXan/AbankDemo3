package com.xan.abankdemo3.ui.login;


import android.arch.lifecycle.MutableLiveData;

import com.xan.abankdemo3.base.BaseViewModel;

import javax.inject.Inject;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();


    @Inject
    public LoginViewModel(){


    }

    public MutableLiveData<String> getPassword(){
        return password;

    }

    public void goLogin(){
        //getNavigator().showToast(username.getValue(),password.getValue());
        getNavigator().gotoUserListActivity();

    }
    public void goRepo(){
        getNavigator().gotoRepoListActivity();
    }

    public String getU(){
        return username.getValue();
    }
    public String getP(){
        return password.getValue();
    }

}
