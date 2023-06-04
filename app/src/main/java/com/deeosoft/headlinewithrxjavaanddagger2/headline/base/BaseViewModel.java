package com.deeosoft.headlinewithrxjavaanddagger2.headline.base;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.Errors.ConnectionErrorListener;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.Errors.NetworkErrorListener;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.Errors.UIErrorListener;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx.SchedulerProvider;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.receiver.NetworkReceiver;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.repository.data.DataManager;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    @Inject
    SchedulerProvider schedulerProvider;

    @Inject
    DataManager dataManager;

    //We could use Disposable for this use case since we calling only one endpoint at a time
    // other types are SerialDisposable
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
