package com.xan.abankdemo3.Splash;

import com.xan.abankdemo3.Test;
import com.xan.abankdemo3.TestTwo;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
@Module
public class SplashModule {
    @Provides
    Test provideFeedPagerAdapter(SplashActivity activity) {
        return new Test();
    }

    @Provides
    TestFour provideTestFour(T3 T) {
        return new TestFour(T);
    }


}
