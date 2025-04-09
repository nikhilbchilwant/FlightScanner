package com.fs.scanner.klm.handler;

import com.fs.scanner.klm.model.FlightDetails;
import com.fs.scanner.klm.model.Offer;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/klm/offers")
@RegisterRestClient(configKey = "klm-api")
public interface KlmApi {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Offer offer(FlightDetails flightDetails);
}
