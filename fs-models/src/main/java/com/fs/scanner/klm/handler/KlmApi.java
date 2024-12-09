package com.fs.scanner.klm.handler;

import com.fs.scanner.klm.model.FlightDetails;
import com.fs.scanner.klm.model.Offer;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;



@Path("/klm/offers")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.8.0")
public interface KlmApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Offer offer(FlightDetails flightDetails);
}
