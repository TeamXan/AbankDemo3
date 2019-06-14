package com.xan.abankdemo3.Module;

import com.xan.abankdemo3.splash.SplashActivity;
import com.xan.abankdemo3.splash.SplashModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = SplashModule.class)
    abstract SplashActivity bindSplashActivity();

}
