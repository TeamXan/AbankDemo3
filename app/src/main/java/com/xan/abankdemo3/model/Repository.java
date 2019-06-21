package com.xan.abankdemo3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repository {
    @Expose
    @SerializedName("name")
    public final String name;
    @Expose
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
