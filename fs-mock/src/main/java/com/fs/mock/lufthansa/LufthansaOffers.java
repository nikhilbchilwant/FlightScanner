package com.fs.mock.lufthansa;

import com.fs.scanner.lufthansa.handler.LufthansaApi;
import com.fs.scanner.lufthansa.model.FlightDetails;
import com.fs.scanner.lufthansa.model.Offer;
import jakarta.ws.rs.Path;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Random;

@Path("/lufthansa/offers")
public class LufthansaOffers implements LufthansaApi {

    private static final Log log = LogFactory.getLog(LufthansaOffers.class);

    /**
     * @param flightDetails
     * @return an Offer with random price.
     *
     * In future, we would like to return the price based on demand (dynamic pricing).
     */
    @Override
    public Offer offer(FlightDetails flightDetails) {
        double offerPrice = Math.floor(new Random().nextDouble(200, 250) * 100) / 100;
        Offer offer = new Offer().offerPrice(offerPrice);
        log.debug(offer);
        return offer;
    }
}
