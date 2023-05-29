package com.deeosoft.headlinewithrxjavaanddagger2.headline.repository;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain.HeadLineDomainModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.HeadLineNetworkModel;
import com.deeosoft.headlinewithrxjavaanddagger2.util.GeneralModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface HeadLineRepository {
    Single<GeneralModel<List<HeadLineNetworkModel>>> getTopHeadLines(String country, String apiKey);
}
