package com.deeosoft.headlinewithrxjavaanddagger2.headline.network;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity.HeadLineItem;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain.HeadLineDomainModel;
import com.deeosoft.headlinewithrxjavaanddagger2.util.Collection;
import com.deeosoft.headlinewithrxjavaanddagger2.util.EntityMapper;

import java.util.List;

import javax.inject.Inject;

public class NetworkEntityMapper implements EntityMapper<HeadLineItem, HeadLineDomainModel> {

    @Inject
    public NetworkEntityMapper(){}


    @Override
    public HeadLineDomainModel mapFromEntity(HeadLineItem headLineNetworkModel) {
        return new HeadLineDomainModel(
                headLineNetworkModel.author,
                headLineNetworkModel.title,
                headLineNetworkModel.url,
                headLineNetworkModel.urlToImage
        );
    }

    public List<HeadLineItem> mapToRoomEntityList(List<HeadLineNetworkModel> headLineNetworkModel){
        return Collection.transform(headLineNetworkModel, entity -> new HeadLineItem(
                entity.title,
                entity.author,
                entity.url,
                entity.imageSrc
        ));
    }

    public List<HeadLineDomainModel> mapFromEntityList(List<HeadLineItem> headLineNetworkModels){
        return Collection.transform(headLineNetworkModels, this::mapFromEntity);
    }
}
