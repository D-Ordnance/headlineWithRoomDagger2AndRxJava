package com.deeosoft.headlinewithrxjavaanddagger2.headline.repository.remote;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.HeadLineItem;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.HeadLineNetworkModel;
import com.deeosoft.headlinewithrxjavaanddagger2.util.GeneralModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface HeadLineRemote {
    Single<GeneralModel<List<HeadLineNetworkModel>>> getTopHeadLines(String country, String apiKey);
}
