package com.fs.mock.lufthansa;

import com.fs.scanner.lufthansa.handler.LufthansaApi;
import com.fs.scanner.lufthansa.model.FlightDetails;
import com.fs.scanner.lufthansa.model.Offer;
import jakarta.ws.rs.Path;

@Path("/lufthansa/offers")
public class LufthansaOffers implements LufthansaApi {
    @Override
    public Offer offer(FlightDetails flightDetails) {
        return new Offer().offerPrice(2.0);
    }
}
