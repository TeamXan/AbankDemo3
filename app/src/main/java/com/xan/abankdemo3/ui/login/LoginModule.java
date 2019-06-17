package com.xan.abankdemo3.ui.login;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {
    @ContributesAndroidInjector
    abstract LoginFragment provideLoginFragment();
}
