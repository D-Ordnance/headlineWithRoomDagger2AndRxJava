package com.deeosoft.headlinewithrxjavaanddagger2.headline.di;

import androidx.lifecycle.ViewModelProvider;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.scope.AppScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelBuilder {

    @Binds
    @AppScope
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

}
