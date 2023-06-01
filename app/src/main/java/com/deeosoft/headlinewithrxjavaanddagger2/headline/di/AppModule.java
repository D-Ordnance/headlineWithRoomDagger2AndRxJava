package com.deeosoft.headlinewithrxjavaanddagger2.headline.di;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx.SchedulerProvider;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx.SchedulerProviderImpl;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.scope.AppScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NetworkModule.class, RoomModule.class})
public class AppModule {

    @Provides
    @AppScope
    SchedulerProvider provideSchedulerProvider(){
        return new SchedulerProviderImpl();
    }
}
