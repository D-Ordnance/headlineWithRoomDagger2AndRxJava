package com.deeosoft.headlinewithrxjavaanddagger2.headline.network;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.feature.HeadLineModel;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkService {

    @GET("top-headlines")
    Single<HeadLineModel> getTopHeadLines(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}
