package com.fs.mock.klm;

import com.fs.scanner.klm.handler.KlmApi;
import com.fs.scanner.klm.model.FlightDetails;
import com.fs.scanner.klm.model.Offer;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/klm/offers")
public class KlmOffers {//implements KlmApi {
//    @Override
    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Offer offer(FlightDetails flightDetails) {
        return new Offer();
    }
}
