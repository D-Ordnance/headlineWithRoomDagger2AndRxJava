package com.deeosoft.headlinewithrxjavaanddagger2.headline.di;

import android.app.Application;

import androidx.room.Room;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.repository.data.DataManager;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.repository.data.DataManagerImpl;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.HeadLineDatabase;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.helper.RoomHelper;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.helper.RoomHelperImpl;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.repository.remote.HeadLineRemote;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.repository.remote.HeadLineRemoteImpl;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.scope.AppScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NetworkModule.class})
public class RoomModule {
    @Provides
    @AppScope
    static HeadLineRemote provideHeadLineRepository(HeadLineRemoteImpl headLineRepository){
        return headLineRepository;
    }

    @AppScope
    @Provides
    static RoomHelper provideRoomHelper(RoomHelperImpl roomHelper){
        return roomHelper;
    }

    @Provides
    @AppScope
    DataManager provideDataManager(RoomHelper roomHelper, HeadLineRemote headLineRepository) {
        return new DataManagerImpl(roomHelper, headLineRepository);
    }

    @Provides
    @AppScope
    HeadLineDatabase provideDatabaseModule(Application application){
        return Room.databaseBuilder(
                application,
                HeadLineDatabase.class,
                "top_head_lines_with_java"
        ).build();
    }
}
