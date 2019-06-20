package com.xan.abankdemo3.model;

import com.google.gson.annotations.SerializedName;

public class Repository {

    @SerializedName("name")
    public final String name;
    @SerializedName("realname")
    public final String  realname;


    public Repository(String name, String realname) {
        this.name = name;
        this.realname = realname;
    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }
}
