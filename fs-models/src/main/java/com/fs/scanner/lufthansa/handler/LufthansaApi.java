package com.fs.scanner.lufthansa.handler;

import com.fs.scanner.lufthansa.model.FlightDetails;
import com.fs.scanner.lufthansa.model.Offer;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


import java.io.InputStream;
import java.util.Map;
import java.util.List;



@Path("/lufthansa/offers")
@RegisterRestClient(configKey = "lufthansa-api")
public interface LufthansaApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Offer offer(FlightDetails flightDetails);
}
