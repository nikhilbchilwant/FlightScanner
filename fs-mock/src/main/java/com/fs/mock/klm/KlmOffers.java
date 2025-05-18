package com.fs.mock.klm;

import com.fs.scanner.klm.handler.KlmApi;
import com.fs.scanner.klm.model.FlightDetails;
import com.fs.scanner.klm.model.Offer;
import jakarta.ws.rs.Path;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Random;

@Path("/klm/offers")
public class KlmOffers implements KlmApi {

    private static final Log log = LogFactory.getLog(KlmOffers.class);

    /**
     * @param flightDetails
     * @return an Offer with random price.
     *
     * In future, we would like to return the price based on demand (dynamic pricing).
     */
    @Override
    public Offer offer(FlightDetails flightDetails) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double offerPrice = Math.floor(new Random().nextDouble(200, 250) * 100) / 100;
        Offer offer = new Offer().offerPrice(offerPrice);
        log.debug(offer);
        return offer;
    }
}
