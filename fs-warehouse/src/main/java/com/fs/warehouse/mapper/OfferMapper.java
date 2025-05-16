package com.fs.warehouse.mapper;

import com.fs.scanner.common.model.Offer;
import com.fs.warehouse.entity.OfferEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface OfferMapper {
    OfferEntity toOfferEntity(Offer person);
}