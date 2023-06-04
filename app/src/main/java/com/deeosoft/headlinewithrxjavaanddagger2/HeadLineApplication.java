package com.deeosoft.headlinewithrxjavaanddagger2;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.di.DaggerHeadLineComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;

public class HeadLineApplication extends DaggerApplication {

    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerHeadLineComponent.builder().application(this).build();
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }
}
