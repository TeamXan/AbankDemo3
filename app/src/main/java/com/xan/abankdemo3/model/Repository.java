package com.xan.abankdemo3.model;

import com.google.gson.annotations.SerializedName;

public class Repository {

    @SerializedName("stargazers_count")
    public final long stars;
    @SerializedName("forks_count")
    public final long forks;

    public Repository(long stars, long forks) {
        this.stars = stars;
        this.forks = forks;
    }

    public long getStars() {
        return stars;
    }

    public long getForks() {
        return forks;
    }
}
