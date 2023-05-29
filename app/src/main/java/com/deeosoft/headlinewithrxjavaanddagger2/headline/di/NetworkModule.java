package com.deeosoft.headlinewithrxjavaanddagger2.headline.di;

import com.deeosoft.headlinewithrxjavaanddagger2.BuildConfig;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.NetworkService;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.scope.AppScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @AppScope
    NetworkService provideNetworkService(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(NetworkService.class);
    }
}
