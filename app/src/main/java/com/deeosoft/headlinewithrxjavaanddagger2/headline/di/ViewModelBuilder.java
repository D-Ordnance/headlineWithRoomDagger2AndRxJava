package com.deeosoft.headlinewithrxjavaanddagger2.headline.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.viewModel.HeadLineViewModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.scope.AppScope;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(HeadLineViewModel.class)
    public abstract ViewModel bindHeadLineViewModel(HeadLineViewModel headLineViewModel);

    @Binds
    @AppScope
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

}
