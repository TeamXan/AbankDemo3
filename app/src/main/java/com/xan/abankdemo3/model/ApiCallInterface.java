package com.xan.abankdemo3.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiCallInterface {

    @GET("orgs/Google/repos")
    Single<List<Repository>> getRepositories();
}
