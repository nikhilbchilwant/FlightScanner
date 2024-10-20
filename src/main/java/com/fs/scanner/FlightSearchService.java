package com.fs.scanner;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/flights")
public class FlightSearchService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String search() {
        return "Your flights here";
    }
}