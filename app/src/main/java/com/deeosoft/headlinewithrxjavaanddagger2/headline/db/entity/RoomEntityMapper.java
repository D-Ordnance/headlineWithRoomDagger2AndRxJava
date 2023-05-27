package com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain.HeadLineDomainModel;
import com.deeosoft.headlinewithrxjavaanddagger2.util.EntityMapper;

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

    @Override
    public HeadLineItem mapToEntity(HeadLineDomainModel headLineDomainModel) {
        // I am not using this
        // Look into this, because it breaks one of the SOLID principles which is Interface Segregation
        return null;
    }
}
