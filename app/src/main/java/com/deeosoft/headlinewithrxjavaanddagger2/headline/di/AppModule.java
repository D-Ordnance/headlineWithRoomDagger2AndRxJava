package com.deeosoft.headlinewithrxjavaanddagger2.headline.di;

import com.deeosoft.headlinewithrxjavaanddagger2.BuildConfig;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx.SchedulerProvider;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.repository.HeadLineRepository;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.repository.HeadLineRepositoryImpl;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx.SchedulerProviderImpl;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.data.DataManager;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.data.DataManagerImpl;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.di.HeadLineDatabaseModule;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.helper.RoomHelper;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.NetworkService;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.scope.AppScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {NetworkModule.class, RoomModule.class})
public class AppModule {

    @Provides
    @AppScope
    SchedulerProvider provideSchedulerProvider(){
        return new SchedulerProviderImpl();
    }
}
