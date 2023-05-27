package com.deeosoft.headlinewithrxjavaanddagger2.headline.di;

import com.deeosoft.headlinewithrxjavaanddagger2.BuildConfig;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rest.HeadLineRepository;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rest.HeadLineRepositoryImpl;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx.SchedulerProviderImpl;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.data.DataManager;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.data.DataManagerImpl;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.di.HeadLineDatabaseModule;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.helper.RoomHelper;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.NetworkService;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.scope.AppScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {HeadLineDatabaseModule.class})
public class AppModule {
    @Provides
    @AppScope
    NetworkService provideNetworkService(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService.class);
    }

    @Provides
    @AppScope
    SchedulerProviderImpl provideSchedulerProvider(){
        return new SchedulerProviderImpl();
    }
    @Provides
    @AppScope
    HeadLineRepositoryImpl provideHeadLineRepository(NetworkService networkService){
        return new HeadLineRepositoryImpl(networkService);
    }

    @Provides
    @AppScope
    DataManager provideDataManager(RoomHelper roomHelper, HeadLineRepository headLineRepository){
        return new DataManagerImpl(roomHelper, headLineRepository);
    }
}
