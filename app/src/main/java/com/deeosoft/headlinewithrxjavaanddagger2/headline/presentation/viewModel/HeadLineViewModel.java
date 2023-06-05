package com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.viewModel;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.Errors.NetworkErrorListener;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.BaseViewModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx.SchedulerProvider;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.repository.data.DataManager;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.HeadLineItem;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.RoomEntityMapper;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain.HeadLineDomainModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.HeadLineNetworkModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.NetworkEntityMapper;
import com.deeosoft.headlinewithrxjavaanddagger2.util.GeneralModel;
import com.deeosoft.headlinewithrxjavaanddagger2.util.Resource;

import java.util.List;

import javax.inject.Inject;


public class HeadLineViewModel extends BaseViewModel implements NetworkErrorListener {

    private final String TAG = "HeadLineViewModel";
    MutableLiveData<Resource<List<HeadLineDomainModel>>> source = new MutableLiveData<>();


    @Inject
    RoomEntityMapper roomEntityMapper;

    @Inject
    NetworkEntityMapper networkEntityMapper;

    @Inject
    public HeadLineViewModel(SchedulerProvider schedulerProvider, DataManager dataManager) {
        super(schedulerProvider, dataManager);

        getLocalSource(null);
    }

    public LiveData<Resource<List<HeadLineDomainModel>>> getSource(){
        return source;
    }

    private void getLocalSource(@Nullable Long[] rowId){
        if(rowId != null){
            long singleRowId = -1;
            for(long id: rowId){
                singleRowId = id;
            }
            if(singleRowId == -1){
                source.postValue(Resource.error(null, "No new data"));
            }
            getCompositeDisposable().add(getDataManager().getTopHeadLines()
                    .doOnSubscribe(disposable -> onLoading())
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(this::onLocalSourceSuccess, this::setError));

        }
    }

    public void getRemoteSource(String country, String apiKeys){
        getCompositeDisposable().add(getDataManager().getTopHeadLines(country, apiKeys)
                .doOnSubscribe(disposable -> onLoading())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(this::onRemoteSourceSuccess, this::setError));
    }

    private void saveData(List<HeadLineItem> items){
        getCompositeDisposable().add(getDataManager().insert(items)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(this::getLocalSource, this::setError));
    }

    @Override
    protected void setError(Throwable e) {
        source.setValue(Resource.error(null, e.getMessage()));
    }

    private void onLoading(){
        source.postValue(Resource.loading(null));
    }

    private void onRemoteSourceSuccess(GeneralModel<List<HeadLineNetworkModel>> items){
        // save data here using the entityMapper....
        saveData(networkEntityMapper.mapToRoomEntityList(items.article));
    }

    private void onLocalSourceSuccess(List<HeadLineItem> items){
        // emit data here using the entityMapper....
        source.postValue(Resource.success(roomEntityMapper.mapFromEntityList(items), null));
    }

    @Override
    public void onNetworkError() {

    }
}
