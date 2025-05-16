package com.fs.warehouse.entity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OfferRepository implements PanacheRepository<OfferEntity>{

}
