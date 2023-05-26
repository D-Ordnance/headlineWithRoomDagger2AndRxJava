package com.deeosoft.headlinewithrxjavaanddagger2.headline.base;

import androidx.lifecycle.ViewModel;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    @Inject
    SchedulerProvider schedulerProvider;

    private final CompositeDisposable compositeDisposable;

    @Inject
    public BaseViewModel(SchedulerProvider schedulerProvider){
        compositeDisposable = new CompositeDisposable();
        this.schedulerProvider = schedulerProvider;
    }

    protected abstract void setError(Throwable e);

    protected SchedulerProvider getSchedulerProvider(){
        return schedulerProvider;
    }

    protected CompositeDisposable getCompositeDisposable(){
        return compositeDisposable;
    }

    @Override
    protected void onCleared() {
        if(compositeDisposable != null){
            compositeDisposable.dispose();
        }
        super.onCleared();
    }
}
