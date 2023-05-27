package com.deeosoft.headlinewithrxjavaanddagger2.headline.db.di;

import android.content.Context;

import androidx.room.Room;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.HeadLineDatabase;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.helper.RoomHelperImpl;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.scope.AppScope;

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
    @AppScope
    HeadLineDatabase provideDatabaseModule(Context context){
        return Room.databaseBuilder(
                context,
                HeadLineDatabase.class,
                "top_head_lines_with_java"
        ).build();
    }

    @Provides
    @AppScope
    RoomHelperImpl provideRoomHelper(HeadLineDatabase headLineDatabase){
        return new RoomHelperImpl(headLineDatabase);
    }
}
