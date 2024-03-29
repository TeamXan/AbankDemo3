package com.xan.abankdemo3.Module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

import com.xan.abankdemo3.splash.SplashViewModel;
import com.xan.abankdemo3.Utils.ViewModelFactory;
import com.xan.abankdemo3.ui.login.LoginViewModel;
import com.xan.abankdemo3.ui.main.MainVeiwModel;
import com.xan.abankdemo3.ui.repolist.RepoItemViewModel;
import com.xan.abankdemo3.ui.repolist.RepoListViewModel;
import com.xan.abankdemo3.ui.userlist.UserItemViewModel;
import com.xan.abankdemo3.ui.userlist.UserListViewModel;

@Singleton
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    abstract ViewModel bindSplashViewModel(SplashViewModel splashViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MainVeiwModel.class)
    abstract ViewModel bindMainViewModel(MainVeiwModel mainVeiwModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(UserListViewModel.class)
    abstract ViewModel bindUserListViewModel(UserListViewModel userListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RepoListViewModel.class)
    abstract ViewModel bindRepoListViewModel(RepoListViewModel repoListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    abstract UserItemViewModel bindUserItemViewModel(UserItemViewModel viewModel);
    @Binds
    abstract RepoItemViewModel bindRepoItemViewModel(RepoItemViewModel viewModel);
}
