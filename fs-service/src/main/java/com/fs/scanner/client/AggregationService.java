package com.fs.scanner.client;

import com.fs.scanner.common.handler.OfferProvider;
import com.fs.scanner.common.model.FlightDetails;
import com.fs.scanner.common.model.Offer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class AggregationService {

    private static final Log log = LogFactory.getLog(AggregationService.class);

    @Inject
    @Any
    Instance<OfferProvider> clients;

    public List<Offer> getOffers(FlightDetails flightDetails) {
        log.trace("AggregationService bean " + this);
        return clients.stream().parallel().map(offerProvider -> offerProvider.call(flightDetails)).collect(Collectors.toList());
    }
}
