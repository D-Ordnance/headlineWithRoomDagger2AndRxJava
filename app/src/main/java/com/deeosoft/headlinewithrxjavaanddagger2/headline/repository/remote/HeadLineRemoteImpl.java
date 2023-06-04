package com.deeosoft.headlinewithrxjavaanddagger2.headline.repository.remote;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.HeadLineItem;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.HeadLineNetworkModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.NetworkService;
import com.deeosoft.headlinewithrxjavaanddagger2.util.GeneralModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class HeadLineRemoteImpl implements HeadLineRemote {

    @Inject
    NetworkService networkService;

    @Inject
    public HeadLineRemoteImpl(NetworkService networkService){
        this.networkService = networkService;
    }

    @Override
    public Single<GeneralModel<List<HeadLineNetworkModel>>> getTopHeadLines(String country, String apiKey) {
        return networkService.getTopHeadLines(country, apiKey);
    }
}
