package com.fs.warehouse;

import com.fs.scanner.common.model.Offer;
import io.smallrye.reactive.messaging.annotations.Blocking;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class OfferWarehouse {

    private static final Log log = LogFactory.getLog(OfferWarehouse.class);

    @Incoming("offers")
    @Blocking
    public void process(JsonObject message) {
        Offer offer = message.mapTo(Offer.class);
        log.info(offer.toString());
    }
}
