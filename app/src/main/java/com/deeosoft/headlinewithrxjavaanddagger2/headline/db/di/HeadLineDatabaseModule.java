package com.deeosoft.headlinewithrxjavaanddagger2.headline.db.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.HeadLineDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HeadLineDatabaseModule {

    @Provides
    @Singleton
    Context provideContext(){
        return provideContext().getApplicationContext();
    }

    @Provides
    @Singleton
    HeadLineDatabase provideDatabaseModule(Context context){
        return Room.databaseBuilder(
                context,
                HeadLineDatabase.class,
                "top_head_lines_with_java"
        ).build();
    }
}
