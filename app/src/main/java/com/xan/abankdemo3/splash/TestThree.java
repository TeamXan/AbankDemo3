package com.xan.abankdemo3.splash;

import com.xan.abankdemo3.T2;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TestThree implements T3 {
 T2 two;
 @Inject
 public TestThree(T2 t2){
  two = t2;
 }
 @Override
 public String returnTest3(){
     return two.back();
 }
}
