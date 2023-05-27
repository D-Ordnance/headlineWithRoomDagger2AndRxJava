package com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rest;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain.HeadLineDomainModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.HeadLineNetworkModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.NetworkService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class HeadLineRepositoryImpl implements HeadLineRepository{

    @Inject
    NetworkService networkService;

    @Inject
    public HeadLineRepositoryImpl(NetworkService networkService){
        this.networkService = networkService;
    }

    @Override
    public Single<List<HeadLineNetworkModel>> getTopHeadLines(String country, String apiKey) {
        return networkService.getTopHeadLines(country, apiKey);
    }
}
