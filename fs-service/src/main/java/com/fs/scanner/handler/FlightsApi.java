package com.fs.scanner.handler;

import com.fs.scanner.client.AggregationService;
import com.fs.scanner.common.model.FlightDetails;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;

@Path("/flights")
public class FlightsApi {

    @Inject
    AggregationService aggregationService;

    @GET
    @Produces({"application/json"})
    public Response getFlights(@QueryParam("source") String source, @QueryParam("destination") String destination, @QueryParam("travelDate") String travelDate) {
        FlightDetails flightDetails =
                new FlightDetails.FlightDetailsBuilder().setSource(source).setDestination(destination).setTravelDate(LocalDate.parse(travelDate)).build();
        return Response.ok(aggregationService.getOffers(flightDetails)).build();
    }
}