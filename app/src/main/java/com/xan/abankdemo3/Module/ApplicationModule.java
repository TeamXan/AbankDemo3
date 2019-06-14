package com.xan.abankdemo3.Module;

import com.xan.abankdemo3.splash.T3;
import com.xan.abankdemo3.splash.TestThree;
import com.xan.abankdemo3.T2;
import com.xan.abankdemo3.TestTwo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Singleton
@Module(includes = ViewModelModule.class)
public class ApplicationModule {

    @Provides
    @Singleton
    String provideStringOne() {
        return "hello";
    }

    @Provides
    @StringTwo
    String provideStringTwo() {
        return "Welcome";
    }

    @Provides
    @Singleton
    T2 provideTestTwo(TestTwo testTwo) {
        return testTwo;
    }


    @Provides
    @Singleton
    T3 provideTestThree(TestThree test3) {
        return test3;
    }
}
