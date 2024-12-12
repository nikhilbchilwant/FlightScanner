package com.fs.mock.klm;

import com.fs.scanner.klm.handler.KlmApi;
import com.fs.scanner.klm.model.FlightDetails;
import com.fs.scanner.klm.model.Offer;
import jakarta.ws.rs.Path;

@Path("/klm/offers")
public class KlmOffers implements KlmApi {

    @Override
    public Offer offer(FlightDetails flightDetails) {
        return new Offer().offerPrice(1.0);
    }
}
