package com.fs.scanner.client;

import com.fs.scanner.common.handler.OfferProvider;
import com.fs.scanner.common.model.Offer;
import com.fs.scanner.lufthansa.handler.LufthansaApi;
import jakarta.enterprise.context.Dependent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Dependent
public class LufthansaClientProxy implements OfferProvider {

    private static final Log log = LogFactory.getLog(LufthansaClientProxy.class);

    @RestClient
    private LufthansaApi lufthansaClient;

    @Override
    public Offer call() {
        log.info("Lufthansa client " + lufthansaClient);
        return null;
    }
}
