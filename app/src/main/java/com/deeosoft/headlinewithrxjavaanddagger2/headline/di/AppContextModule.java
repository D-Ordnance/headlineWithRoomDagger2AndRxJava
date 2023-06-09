package com.deeosoft.headlinewithrxjavaanddagger2.headline.di;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppContextModule {
    @Binds
    public abstract Context provideAppContext(Application application);
}
