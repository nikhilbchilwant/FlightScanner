package com.fs.scanner.client;

import com.fs.scanner.common.handler.OfferProvider;
import com.fs.scanner.common.model.FlightDetails;
import com.fs.scanner.common.model.Offer;
import com.fs.scanner.lufthansa.handler.LufthansaApi;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.Dependent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Dependent
public class LufthansaClientProxy implements OfferProvider {

    private static final Log log = LogFactory.getLog(LufthansaClientProxy.class);

    @RestClient
    private LufthansaApi lufthansaClient;

    @Channel("offers")
    Emitter<Offer> flightDatapointsEmitter;

    @Override
    @CacheResult(cacheName = "offers-cache", keyGenerator = FlightDetailsCacheKeyGenerator.class)
    public Offer call(FlightDetails flightDetails) {
        log.trace("Lufthansa client " + lufthansaClient);
                com.fs.scanner.lufthansa.model.FlightDetails lufthansaFlightDetails =
                new com.fs.scanner.lufthansa.model.FlightDetails().origin(flightDetails.getSource()).destination(flightDetails.getDestination()).travelDate(flightDetails.getTravelDate());
        com.fs.scanner.lufthansa.model.Offer lufthansaOffer = lufthansaClient.offer(lufthansaFlightDetails);
        Offer offer = new Offer.OfferBuilder().setBidder("Lufthansa").setValue(lufthansaOffer.getOfferPrice()).setSource(flightDetails.getSource()).setDestination(flightDetails.getDestination()).createOffer();
        flightDatapointsEmitter.send(offer);
        return offer;
    }
}
