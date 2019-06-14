package com.xan.abankdemo3.Splash;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.widget.Toast;

import com.xan.abankdemo3.R;
import com.xan.abankdemo3.Test;
import com.xan.abankdemo3.TestTwo;
import com.xan.abankdemo3.Utils.ViewModelFactory;
import com.xan.abankdemo3.base.BaseActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements Navigator {
    @Inject
    TestFour testFour;
    @Inject
    Test test;
    @Inject
    ViewModelFactory viewModelFactory;
    private SplashViewModel viewModel;
    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel.class);
        viewModel.setNavigator(this);
        viewModel.start(testFour.gg());
    }

    @Override
    public void openToast(String str) {
        Toast.makeText(this, "  "+str,
                Toast.LENGTH_LONG).show();

    }
}
