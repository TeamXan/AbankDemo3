package com.xan.abankdemo3.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.xan.abankdemo3.BR;
import com.xan.abankdemo3.R;
import com.xan.abankdemo3.Utils.ViewModelFactory;
import com.xan.abankdemo3.base.BaseActivity;
import com.xan.abankdemo3.databinding.ActivityMainBinding;
import com.xan.abankdemo3.databinding.NavHeaderMainBinding;
import com.xan.abankdemo3.model.Repository;
import com.xan.abankdemo3.ui.login.LoginActivity;

import java.io.Serializable;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainVeiwModel> implements MainNavigator {
    @Inject Repository repository;
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
    private Toolbar mToolbar;
    @Inject
    MainVeiwModel mainVeiwModel;
    ActivityMainBinding activityMainBinding;
    @Inject
    ViewModelFactory factory;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainVeiwModel getViewModel() {
        mainVeiwModel = ViewModelProviders.of(this,factory).get(MainVeiwModel.class);
        return mainVeiwModel;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.newIntent(this));
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = getViewDataBinding();
//        getSupportActionBar().hide();
        mainVeiwModel.setNavigator(this);

        setUp();
        Repository repository = (Repository) getIntent().getSerializableExtra("responsedata");
//        Log.i("response",repository.getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (drawerLayout != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }

    private void lockDrawer() {
        if (drawerLayout != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
    }

    private void setUp() {

        drawerLayout = activityMainBinding.drawerView;
        mToolbar = activityMainBinding.toolbar;
        navigationView = activityMainBinding.navigationView;

        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }
        };
        drawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        setupNavMenu();

        //Repository repository = (Repository) getIntent().getSerializableExtra("responsedata");
    }
    private void setupNavMenu() {
        NavHeaderMainBinding navHeaderMainBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.nav_header_main, activityMainBinding.navigationView, false);
        activityMainBinding.navigationView.addHeaderView(navHeaderMainBinding.getRoot());
        navHeaderMainBinding.setViewModel(mainVeiwModel);

        navigationView.setNavigationItemSelectedListener(
                item -> {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    switch (item.getItemId()) {
                        case R.id.navItemLogin:
                            mainVeiwModel.goLogin();
                            return true;
                        case R.id.navItemRepo:

                            return true;

                        default:
                            return false;
                    }
                });
    }

}
