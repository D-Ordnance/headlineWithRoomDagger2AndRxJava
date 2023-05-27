package com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.BaseViewModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx.SchedulerProvider;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.data.DataManager;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain.HeadLineDomainModel;
import com.deeosoft.headlinewithrxjavaanddagger2.util.Resource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class HeadLineViewModel extends BaseViewModel {

    MutableLiveData<Resource<Single<List<HeadLineDomainModel>>>> source = new MutableLiveData<>();
    private String TAG = "HeadLineViewModel";

    @Inject
    public HeadLineViewModel(SchedulerProvider schedulerProvider, DataManager dataManager) {
        super(schedulerProvider, dataManager);
        getLocalSource();
    }

    LiveData<Resource<Single<List<HeadLineDomainModel>>>> getSource(){
        return source;
    }

    void getLocalSource(){
        getCompositeDisposable().add(getDataManager().getTopHeadLines()
                .doOnSubscribe(disposable -> onLoading())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .doOnSuccess(this::onLocalSourceSuccess)
                .doOnError(this::setError)
                .subscribe());
    }

    void getRemoteSource(String country, String apiKeys){
        getCompositeDisposable().add(getDataManager().getTopHeadLines(country, apiKeys)
                .doOnSubscribe(disposable -> onLoading())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .doOnSuccess(this::onRemoteSourceSuccess)
                .doOnError(this::setError)
                .subscribe());
    }

    @Override
    protected void setError(Throwable e) {
        System.out.println("What is the item size: " + e.getMessage());
    }

    private void onLoading(){
        source.postValue(Resource.loading());
    }

    private void onRemoteSourceSuccess(List<HeadLineDomainModel> items){
        System.out.println("What is the item size: " + items.size());
        Log.d(TAG, "onSuccess: " + items);
    }

    private void onLocalSourceSuccess(List<HeadLineDomainModel> items){
        System.out.println("What is the item size: " + items.size());
        Log.d(TAG, "onSuccess: " + items);
    }
}
