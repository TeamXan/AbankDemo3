package com.xan.abankdemo3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.inject.Inject;

public class Repository implements Serializable {
    @Expose
    @SerializedName("name")
    public  String name;

    @Expose
    @SerializedName("realname")
    public  String  realname;

    @Inject
    public Repository() {

    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }


}
