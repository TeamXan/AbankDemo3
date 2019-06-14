package com.xan.abankdemo3.ui.login;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xan.abankdemo3.BR;
import com.xan.abankdemo3.R;
import com.xan.abankdemo3.Utils.ViewModelFactory;
import com.xan.abankdemo3.base.BaseActivity;
import com.xan.abankdemo3.databinding.LoginLayoutBinding;

import javax.inject.Inject;
import javax.inject.Named;

public class LoginActivity  extends BaseActivity<LoginLayoutBinding,LoginViewModel> implements
        LoginNavigator{


    @Inject
    ViewModelFactory factory;
    LoginLayoutBinding loginLayoutBinding;
    private LoginViewModel loginViewModel;
    public static Intent newIntent(Context context) {
        return new Intent(context, LoginViewModel.class);
        }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
        }

    @Override
    public int getLayoutId() {
        return R.layout.login_layout;
        }

    @Override
    public LoginViewModel getViewModel() {
        loginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel.class);
        return loginViewModel;
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginLayoutBinding = getViewDataBinding();
        showFragment();
        }



    private void showFragment() {
        getSupportFragmentManager()
        .beginTransaction()
        .disallowAddToBackStack()
        .add(R.id.screenContainer, LoginFragment.newInstance(), LoginFragment.TAG)
        .commit();
        }


             @Override
             public void showToast(String name, String password) {

             }
         }
