package com.fs.scanner.lufthansa.handler;

import com.fs.scanner.lufthansa.model.FlightDetails;
import com.fs.scanner.lufthansa.model.Offer;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/lufthansa/offers")
@RegisterRestClient(configKey = "lufthansa-api")
public interface LufthansaApi {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Offer offer(FlightDetails flightDetails);
}
