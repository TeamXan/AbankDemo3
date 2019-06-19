package com.xan.abankdemo3.model;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class ReturnDataRepository {
    private final ApiCallInterface apiCallInterface;

    @Inject
    public ReturnDataRepository(ApiCallInterface apiCallInterface) {
        this.apiCallInterface = apiCallInterface;
    }

    public Single<List<Repository>> getRepositories() {
        return apiCallInterface.getRepositories();
    }
}
