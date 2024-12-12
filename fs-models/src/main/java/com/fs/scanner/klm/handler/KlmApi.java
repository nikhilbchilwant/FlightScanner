package com.fs.scanner.klm.handler;

import com.fs.scanner.klm.model.FlightDetails;
import com.fs.scanner.klm.model.Offer;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("/klm/offers")
@RegisterRestClient
public interface KlmApi {

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    Offer offer(FlightDetails flightDetails);
}
