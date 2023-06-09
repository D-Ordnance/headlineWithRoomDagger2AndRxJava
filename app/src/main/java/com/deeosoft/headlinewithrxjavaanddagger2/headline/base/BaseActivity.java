package com.deeosoft.headlinewithrxjavaanddagger2.headline.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.di.ViewModelProviderFactory;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.receiver.NetworkReceiver;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<V extends BaseViewModel> extends DaggerAppCompatActivity {

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    private V viewModel;

    public abstract V getViewModel();

    protected boolean getNetworkConnection(){
        return NetworkReceiver.isNetworkAvailable(this);
    }


    public ViewModelProvider.Factory getViewModelFactory(){
        return viewModelProviderFactory;
    }
}
