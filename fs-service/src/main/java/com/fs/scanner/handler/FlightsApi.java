package com.fs.scanner.handler;

import com.fs.scanner.model.Flight;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;



@Path("/flights")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.8.0")
public class FlightsApi {

    @GET
    @Produces({ "application/json" })
    public Response getFlights(@QueryParam("source")   String source,@QueryParam("destination")   String destination,@QueryParam("travelDate")   String travelDate) {
        return Response.ok().entity("magic!").build();
    }
}
