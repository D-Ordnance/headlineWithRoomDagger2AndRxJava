package com.deeosoft.headlinewithrxjavaanddagger2.headline.data;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rest.HeadLineRepository;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.HeadLineItem;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.helper.RoomHelper;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain.HeadLineDomainModel;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.network.HeadLineNetworkModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public class DataManagerImpl implements DataManager{

    @Inject
    RoomHelper roomHelper;

    @Inject
    HeadLineRepository headLineRepository;

    @Inject
    public DataManagerImpl(RoomHelper roomHelper, HeadLineRepository headLineRepository){
        this.roomHelper = roomHelper;
        this.headLineRepository = headLineRepository;
    }

    @Override
    public Single<List<HeadLineNetworkModel>> getTopHeadLines(String country, String apiKey) {
        return headLineRepository.getTopHeadLines(country, apiKey);
    }

    @Override
    public Completable insert(List<HeadLineItem> items) {
        return roomHelper.insert(items);
    }

    @Override
    public Completable insert(HeadLineItem item) {
        return roomHelper.insert(item);
    }

    @Override
    public Single<List<HeadLineItem>> getTopHeadLines() {
        return roomHelper.getTopHeadLines();
    }
}
