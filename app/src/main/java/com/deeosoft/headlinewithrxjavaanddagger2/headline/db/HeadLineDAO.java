package com.deeosoft.headlinewithrxjavaanddagger2.headline.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.HeadLineItem;

import java.util.List;

@Dao
interface HeadLineDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    public void insert(HeadLineItem item);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(List<HeadLineItem> item);

    @Query("SELECT * FROM HeadLine ORDER BY id desc")
    List<HeadLineItem> getTopHeadLines();

}
