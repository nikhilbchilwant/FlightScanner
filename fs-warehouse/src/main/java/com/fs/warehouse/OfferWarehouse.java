package com.fs.warehouse;

import com.fs.scanner.common.model.Offer;
import com.fs.warehouse.entity.OfferEntity;
import com.fs.warehouse.entity.OfferRepository;
import com.fs.warehouse.mapper.OfferMapper;
import io.smallrye.reactive.messaging.annotations.Blocking;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class OfferWarehouse {

    private static final Log log = LogFactory.getLog(OfferWarehouse.class);

    @Inject
    OfferRepository offerRepository;

    @Inject
    OfferMapper offerMapper;

    @Incoming("offers")
    @Blocking
    @Transactional
    public void process(JsonObject message) {
        Offer offer = message.mapTo(Offer.class);
        OfferEntity offerEntity = offerMapper.toOfferEntity(offer);
        log.info("Received " + offerEntity.toString());
        offerRepository.persist(offerEntity);
    }
}
