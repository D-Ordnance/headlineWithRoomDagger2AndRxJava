package com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.BaseViewModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx.SchedulerProvider;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.repository.data.DataManager;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.HeadLineItem;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.RoomEntityMapper;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain.HeadLineDomainModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.HeadLineNetworkModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.NetworkEntityMapper;
import com.deeosoft.headlinewithrxjavaanddagger2.util.GeneralModel;
import com.deeosoft.headlinewithrxjavaanddagger2.util.NetworkState;
import com.deeosoft.headlinewithrxjavaanddagger2.util.Resource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class HeadLineViewModel extends BaseViewModel {

    MutableLiveData<Resource<List<HeadLineDomainModel>>> source = new MutableLiveData<>();
    private String TAG = "HeadLineViewModel";

    @Inject
    RoomEntityMapper roomEntityMapper;

    @Inject
    NetworkEntityMapper networkEntityMapper;

    @Inject
    public HeadLineViewModel(SchedulerProvider schedulerProvider, DataManager dataManager) {
        super(schedulerProvider, dataManager);
        getLocalSource();
    }

    public LiveData<Resource<List<HeadLineDomainModel>>> getSource(){
        return source;
    }

    public void getLocalSource(){
        getCompositeDisposable().add(getDataManager().getTopHeadLines()
                .doOnSubscribe(disposable -> onLoading())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .doOnSuccess(this::onLocalSourceSuccess)
                .doOnError(this::setError)
                .subscribe());
    }

    public void getRemoteSource(String country, String apiKeys){
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
        source.postValue(Resource.error(null, e.getMessage()));
        System.out.println("Error What is the item size: " + e.getMessage());
    }

    private void onLoading(){
        source.postValue(Resource.loading(null));
    }

    private void onRemoteSourceSuccess(GeneralModel<List<HeadLineNetworkModel>> items){
        System.out.println("What is the item size: " + items.article.get(0).imageSrc);
        Log.d(TAG, "onSuccess: " + items);
        // emit data here using the entityMapper....
        source.postValue(Resource.success(networkEntityMapper.mapFromEntityList(items.article), null));
        Log.d(TAG, "after transformation "  + networkEntityMapper.mapFromEntityList(items.article));

    }

    private void onLocalSourceSuccess(List<HeadLineItem> items){
        System.out.println("What is the item size: " + items.size());
        Log.d(TAG, "onSuccess: " + items);
        // emit data here using the entityMapper....
        Log.d(TAG, "after transformation "  + roomEntityMapper.mapFromEntityList(items));
    }
}
