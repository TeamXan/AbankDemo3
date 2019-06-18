package com.xan.abankdemo3.ui.userlist;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.xan.abankdemo3.BR;
import com.xan.abankdemo3.R;
import com.xan.abankdemo3.Utils.ViewModelFactory;
import com.xan.abankdemo3.base.BaseActivity;
import com.xan.abankdemo3.databinding.UserlistLayoutBinding;
import com.xan.abankdemo3.model.Users;

import javax.inject.Inject;

public class UserListActivity extends BaseActivity<UserlistLayoutBinding,UserListViewModel>  {
    String User,Password;
    @Inject
    Users users;
    @Inject
    UserListAdapter userListAdapter;
    @Inject
    LinearLayoutManager mLayoutManager;
    UserlistLayoutBinding userlistLayoutBinding;

    public static Intent newIntent(Context context){
        return new Intent(context,UserListActivity.class);
    }
    @Inject
    ViewModelFactory factory;
    private UserListViewModel userListViewModel;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.userlist_layout;
    }

    @Override
    public UserListViewModel getViewModel() {
        userListViewModel = ViewModelProviders.of(this,factory).get(UserListViewModel.class);
        return userListViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         User = getIntent().getStringExtra("User");
         Password = getIntent().getStringExtra("Password");

        userListViewModel.addList(changeList(User,Password));

        userlistLayoutBinding = getViewDataBinding();
        setUp();
    }


    public Users changeList(String user,String pass){
        users.setUsername(user);
        users.setPassword(pass);

        return users;


    }

    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        userlistLayoutBinding.userView.setLayoutManager(mLayoutManager);
        userlistLayoutBinding.userView.setItemAnimator(new DefaultItemAnimator());
        userlistLayoutBinding.userView.setAdapter(userListAdapter);
    }
}
