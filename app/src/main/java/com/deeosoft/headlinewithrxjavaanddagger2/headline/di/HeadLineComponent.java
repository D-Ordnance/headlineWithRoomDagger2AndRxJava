package com.deeosoft.headlinewithrxjavaanddagger2.headline.di;

import android.app.Application;

import com.deeosoft.headlinewithrxjavaanddagger2.HeadLineApplication;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.scope.AppScope;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@AppScope
@Component(modules = {
        AppContextModule.class,
        AppModule.class,
        AndroidSupportInjectionModule.class,
        HeadLineActivityModule.class})
public interface HeadLineComponent extends AndroidInjector<HeadLineApplication> {

//    void inject(HeadLineApplication HeadLineApplication);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        HeadLineComponent build();
    }
}
