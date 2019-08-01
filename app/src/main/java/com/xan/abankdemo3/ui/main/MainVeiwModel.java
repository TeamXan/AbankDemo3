package com.xan.abankdemo3.ui.main;

import com.xan.abankdemo3.base.BaseViewModel;

import javax.inject.Inject;

public class MainVeiwModel extends BaseViewModel<MainNavigator>
{
    @Inject
    public MainVeiwModel(){

    }
    public void goLogin(){
        getNavigator().openLoginActivity();
    }
}
