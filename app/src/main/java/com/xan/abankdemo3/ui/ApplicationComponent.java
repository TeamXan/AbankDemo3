package com.xan.abankdemo3.ui;

import android.app.Application;

import com.xan.abankdemo3.Module.ActivityBindingModule;
import com.xan.abankdemo3.Module.ApplicationModule;
import com.xan.abankdemo3.Module.ContextModule;
import com.xan.abankdemo3.base.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {ContextModule.class, ApplicationModule.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }
}
