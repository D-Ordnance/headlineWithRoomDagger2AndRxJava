package com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain.HeadLineDomainModel;
import com.deeosoft.headlinewithrxjavaanddagger2.util.Collection;
import com.deeosoft.headlinewithrxjavaanddagger2.util.EntityMapper;

import java.util.List;

import javax.inject.Inject;

public class RoomEntityMapper implements EntityMapper<HeadLineItem, HeadLineDomainModel> {

    @Inject
    public RoomEntityMapper(){}


    @Override
    public HeadLineDomainModel mapFromEntity(HeadLineItem headLineItem) {
        return new HeadLineDomainModel(
                headLineItem.author,
                headLineItem.title,
                headLineItem.url,
                headLineItem.urlToImage
        );
    }

    public List<HeadLineDomainModel> mapFromEntityList(List<HeadLineItem> headLineItems){
        return Collection.transform(headLineItems, this::mapFromEntity);
    }
}
