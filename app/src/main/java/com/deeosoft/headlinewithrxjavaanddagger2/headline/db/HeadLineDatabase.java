package com.deeosoft.headlinewithrxjavaanddagger2.headline.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.HeadLineItem;

@Database(
        entities = {HeadLineItem.class},
        version = 1,
        exportSchema = false
)
public abstract class HeadLineDatabase extends RoomDatabase {
    public abstract HeadLineDAO getHeadLineDAO();
}
