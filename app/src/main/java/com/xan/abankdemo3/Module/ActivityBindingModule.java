package com.xan.abankdemo3.Module;

import com.xan.abankdemo3.splash.SplashActivity;
import com.xan.abankdemo3.splash.SplashModule;
import com.xan.abankdemo3.ui.login.LoginActivity;
import com.xan.abankdemo3.ui.login.LoginModule;
import com.xan.abankdemo3.ui.repolist.RepoListActivity;
import com.xan.abankdemo3.ui.repolist.RepoListModule;
import com.xan.abankdemo3.ui.userlist.UserListActivity;
import com.xan.abankdemo3.ui.userlist.UserListModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = SplashModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = UserListModule.class)
    abstract UserListActivity bindUserActivity();

    @ContributesAndroidInjector(modules = RepoListModule.class)
    abstract RepoListActivity bindRepoActivity();
}
