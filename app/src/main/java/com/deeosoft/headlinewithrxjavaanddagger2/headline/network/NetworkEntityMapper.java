package com.deeosoft.headlinewithrxjavaanddagger2.headline.network;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain.HeadLineDomainModel;
import com.deeosoft.headlinewithrxjavaanddagger2.util.Collection;
import com.deeosoft.headlinewithrxjavaanddagger2.util.EntityMapper;

import java.util.List;

import javax.inject.Inject;

public class NetworkEntityMapper implements EntityMapper<HeadLineNetworkModel, HeadLineDomainModel> {

    @Inject
    public NetworkEntityMapper(){}


    @Override
    public HeadLineDomainModel mapFromEntity(HeadLineNetworkModel headLineNetworkModel) {
        return new HeadLineDomainModel(
                headLineNetworkModel.author,
                headLineNetworkModel.title,
                headLineNetworkModel.url,
                headLineNetworkModel.imageSrc
        );
    }

    public List<HeadLineDomainModel> mapFromEntityList(List<HeadLineNetworkModel> headLineNetworkModels){
        return Collection.transform(headLineNetworkModels, this::mapFromEntity);
    }
}
