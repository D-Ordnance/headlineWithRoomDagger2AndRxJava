package com.deeosoft.headlinewithrxjavaanddagger2.headline.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.HeadLineItem;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface HeadLineDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    public Completable insert(HeadLineItem item);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public Completable insert(List<HeadLineItem> items);

    @Query("SELECT * FROM HeadLine ORDER BY id desc")
    public Single<List<HeadLineItem>> getTopHeadLines();

}
