package com.xan.abankdemo3;

import javax.inject.Inject;

public class TestTwo implements T2 {
    @Inject
    public TestTwo() {
    }

    @Override
    public String back() {
        return "google";
    }
}
