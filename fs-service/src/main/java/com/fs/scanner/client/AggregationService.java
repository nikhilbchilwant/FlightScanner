package com.fs.scanner.client;

import com.fs.scanner.common.handler.OfferProvider;
import com.fs.scanner.common.model.FlightDetails;
import com.fs.scanner.common.model.Offer;
import io.smallrye.context.api.ManagedExecutorConfig;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.microprofile.context.ManagedExecutor;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequestScoped
public class AggregationService {

    private static final Log log = LogFactory.getLog(AggregationService.class);
    @Inject
    @Any
    Instance<OfferProvider> clients;
    @Inject
    @ManagedExecutorConfig(maxAsync = 4)
    ManagedExecutor aggregationExecutor;

    @Channel("flight-datapoints") Emitter<Offer> flightDatapointsEmitter;

    public List<Offer> getOffers(FlightDetails flightDetails) {
        log.trace("AggregationService bean " + this);
        Iterator<OfferProvider> iterator = clients.iterator();
        List<Offer> offers = new ArrayList<>();
        while (iterator.hasNext()) {
            OfferProvider provider = iterator.next();
            Offer offer = provider.call(flightDetails);
            offers.add(offer);
            flightDatapointsEmitter.send(offer);
        }

        return offers;
    }
}
