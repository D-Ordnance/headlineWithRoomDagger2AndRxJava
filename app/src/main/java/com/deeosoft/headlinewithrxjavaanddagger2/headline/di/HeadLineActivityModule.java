package com.deeosoft.headlinewithrxjavaanddagger2.headline.di;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.ui.HeadLineActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HeadLineActivityModule {

    @ContributesAndroidInjector(modules = {ViewModelBuilder.class})
    abstract HeadLineActivity contributeHeadLineActivity();
}
