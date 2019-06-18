package com.xan.abankdemo3.ui.userlist;

import android.support.v7.widget.LinearLayoutManager;

import com.xan.abankdemo3.model.Users;
import com.xan.abankdemo3.splash.T3;
import com.xan.abankdemo3.splash.TestFour;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
@Module
public class UserListModule {
    @Provides
    Users provideUsers() {
        return new Users();
    }

    @Provides
    UserListAdapter provideAdapter() {
        return new UserListAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(UserListActivity userListActivity) {
        return new LinearLayoutManager(userListActivity);
    }
}
