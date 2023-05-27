package com.deeosoft.headlinewithrxjavaanddagger2;

import android.app.Application;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.di.AppModule;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.di.DaggerHeadLineComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class HeadLineApplication extends Application implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        DaggerHeadLineComponent.builder()
                .appModule(new AppModule())
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }
}
