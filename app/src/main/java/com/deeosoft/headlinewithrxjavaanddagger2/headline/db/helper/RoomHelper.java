package com.deeosoft.headlinewithrxjavaanddagger2.headline.db.helper;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.HeadLineItem;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface RoomHelper{

    Maybe<Long[]> insert(List<HeadLineItem> items);

    Completable insert(HeadLineItem item);

    Single<List<HeadLineItem>> getTopHeadLines();
}
