package com.deeosoft.headlinewithrxjavaanddagger2.headline.network;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain.HeadLineDomainModel;
import com.deeosoft.headlinewithrxjavaanddagger2.util.GeneralModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkService {

    @GET("top-headlines")
    Single<GeneralModel<List<HeadLineNetworkModel>>> getTopHeadLines(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}
