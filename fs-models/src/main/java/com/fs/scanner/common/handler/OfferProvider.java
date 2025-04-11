package com.fs.scanner.common.handler;

import com.fs.scanner.common.model.FlightDetails;
import com.fs.scanner.common.model.Offer;

public interface OfferProvider {

    public Offer call(FlightDetails flightDetails);
}
