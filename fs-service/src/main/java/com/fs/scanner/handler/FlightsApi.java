package com.fs.scanner.handler;

import com.fs.scanner.client.AggregationService;
import com.fs.scanner.common.model.FlightDetails;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;


@Path("/flights")
public class FlightsApi {

    @Inject
    AggregationService aggregationService;

    @GET
    @Produces({"application/json"})
    public Response getFlights(@QueryParam("source") String source, @QueryParam("destination") String destination, @QueryParam("travelDate") String travelDate) {
        return Response.ok(aggregationService.getOffers(null)).build();
    }
}
