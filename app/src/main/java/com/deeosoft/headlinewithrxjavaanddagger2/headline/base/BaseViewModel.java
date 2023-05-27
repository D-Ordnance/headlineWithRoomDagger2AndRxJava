package com.deeosoft.headlinewithrxjavaanddagger2.headline.base;

import androidx.lifecycle.ViewModel;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx.SchedulerProvider;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.data.DataManager;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    @Inject
    SchedulerProvider schedulerProvider;

    @Inject
    DataManager dataManager;

    private final CompositeDisposable compositeDisposable;

    public BaseViewModel(SchedulerProvider schedulerProvider, DataManager dataManager){
        compositeDisposable = new CompositeDisposable();
        this.schedulerProvider = schedulerProvider;
        this.dataManager = dataManager;
    }

    protected abstract void setError(Throwable e);

    protected SchedulerProvider getSchedulerProvider(){
        return schedulerProvider;
    }

    protected CompositeDisposable getCompositeDisposable(){
        return compositeDisposable;
    }

    protected DataManager getDataManager(){
        return dataManager;
    }

    @Override
    protected void onCleared() {
        if(compositeDisposable != null){
            compositeDisposable.dispose();
        }
        super.onCleared();
    }
}
