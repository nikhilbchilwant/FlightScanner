package com.fs.scanner.handler;

import com.fs.scanner.klm.handler.KlmApi;
import com.fs.scanner.klm.model.FlightDetails;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@Path("/flights")
public class FlightsApi {

    @RestClient
    KlmApi KlmClient;

    @GET
    @Produces({"application/json"})
    public Response getFlights(@QueryParam("source") String source, @QueryParam("destination") String destination, @QueryParam("travelDate") String travelDate) {
        return Response.ok().entity(KlmClient.offer(new FlightDetails()).offerPrice(1.0)).build();
    }
}
