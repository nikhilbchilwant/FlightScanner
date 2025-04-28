package com.fs.scanner.client;

import com.fs.scanner.klm.handler.KlmApi;
import com.fs.scanner.lufthansa.handler.LufthansaApi;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
@QuarkusTest
public class AggregationServiceTest {

    @InjectMock
    @RestClient
    KlmApi klmMock;

    @InjectMock
    @RestClient
    LufthansaApi lufthansaMock;

    @Test
    public void testAggregationService() {
        Mockito.when(klmMock.offer(Mockito.any(com.fs.scanner.klm.model.FlightDetails.class)))
                .thenReturn(new com.fs.scanner.klm.model.Offer().offerPrice(200.0));
        Mockito.when(lufthansaMock.offer(Mockito.any(com.fs.scanner.lufthansa.model.FlightDetails.class)))
                .thenReturn(new com.fs.scanner.lufthansa.model.Offer().offerPrice(250.0));

        given().when().get("/fs/v1/flights?source={source}&destination={destination}&travelDate={travelDate}", "BOM",
                        "FRA", "2025-06-01").then().statusCode(200);
    }
}
