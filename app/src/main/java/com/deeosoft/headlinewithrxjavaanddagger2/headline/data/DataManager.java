package com.deeosoft.headlinewithrxjavaanddagger2.headline.data;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.repository.HeadLineRepository;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.helper.RoomHelper;

public interface DataManager extends RoomHelper, HeadLineRepository {
}
