package com.deeosoft.headlinewithrxjavaanddagger2.headline.base;

import androidx.lifecycle.ViewModelProvider;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.di.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.DaggerActivity;
import dagger.android.support.DaggerAppCompatActivity;

public class BaseActivity<V extends BaseViewModel> extends DaggerAppCompatActivity {

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;


    ViewModelProvider.Factory getViewModelFactory(){
        return viewModelProviderFactory;
    }
}
