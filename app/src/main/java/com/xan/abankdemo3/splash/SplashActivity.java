package com.xan.abankdemo3.splash;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.xan.abankdemo3.R;
import com.xan.abankdemo3.Utils.ViewModelFactory;
import com.xan.abankdemo3.base.BaseActivity;
import com.xan.abankdemo3.databinding.SplashLayoutBinding;
import com.xan.abankdemo3.ui.login.LoginActivity;
import com.xan.abankdemo3.ui.main.MainActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<SplashLayoutBinding,SplashViewModel> implements Navigator {


    Handler handler;
    @Inject
    ViewModelFactory factory;
    private SplashViewModel splashViewModel;

    public static Intent newIntent(Context context) {
        return new Intent(context, SplashActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.splash_layout;
    }


    @Override
    public SplashViewModel getViewModel() {
        splashViewModel = ViewModelProviders.of(this,factory).get(SplashViewModel.class);
        return splashViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashViewModel.setNavigator(this);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                splashViewModel.start();
                finish();
            }
        },3000);

    }

    @Override
    public void openToast(String string) {

    }

    @Override
    public void openLoginActivity() {
        Intent intent = MainActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
        Toast.makeText(this, "This is my Toast message!",
                Toast.LENGTH_LONG).show();

    }
}
