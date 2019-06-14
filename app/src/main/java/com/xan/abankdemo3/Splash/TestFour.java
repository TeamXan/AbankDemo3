package com.xan.abankdemo3.Splash;

import com.xan.abankdemo3.TestTwo;

import javax.inject.Inject;

public class TestFour {
    T3 test3;

    public TestFour(T3 testThree) {
        test3 = testThree;
    }
    public String gg(){
        return test3.returnTest3();
    }
}
