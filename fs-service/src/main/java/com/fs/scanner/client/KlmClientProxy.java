package com.fs.scanner.client;

import com.fs.scanner.common.handler.OfferProvider;
import com.fs.scanner.common.model.FlightDetails;
import com.fs.scanner.common.model.Offer;
import com.fs.scanner.klm.handler.KlmApi;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.Dependent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Dependent
public class KlmClientProxy implements OfferProvider {

    private static final Log log = LogFactory.getLog(KlmClientProxy.class);

    @RestClient
    private KlmApi klmClient;

    @Override
    @CacheResult(cacheName = "offers-cache", keyGenerator = FlightDetailsCacheKeyGenerator.class)
    public Offer call(FlightDetails flightDetails) {
        log.trace("KLM client " + klmClient);
        com.fs.scanner.klm.model.FlightDetails klmFlightDetails =
                new com.fs.scanner.klm.model.FlightDetails().origin(flightDetails.getSource()).destination(flightDetails.getDestination()).travelDate(flightDetails.getTravelDate());
        com.fs.scanner.klm.model.Offer klmOffer = klmClient.offer(klmFlightDetails);
        return new Offer.OfferBuilder().setBidder("KLM").setValue(klmOffer.getOfferPrice()).setSource(flightDetails.getSource()).setDestination(flightDetails.getDestination()).createOffer();
    }
}
