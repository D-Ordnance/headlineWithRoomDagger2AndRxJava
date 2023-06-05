package com.deeosoft.headlinewithrxjavaanddagger2.headline.db.helper;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.HeadLineDatabase;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.HeadLineItem;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class RoomHelperImpl implements RoomHelper{

    private final String TAG = "RoomHelperImpl";
    @Inject
    public HeadLineDatabase headLineDatabase;

    @Inject
    public RoomHelperImpl(HeadLineDatabase headLineDatabase){
        this.headLineDatabase = headLineDatabase;
    }

    @Override
    public Maybe<Long[]> insert(List<HeadLineItem> items) {
        return headLineDatabase.getHeadLineDAO().insert(items);
    }

    @Override
    public Completable insert(HeadLineItem item) {
        return headLineDatabase.getHeadLineDAO().insert(item);
    }

    @Override
    public Single<List<HeadLineItem>> getTopHeadLines() {
        return headLineDatabase.getHeadLineDAO().getTopHeadLines();
    }
}
