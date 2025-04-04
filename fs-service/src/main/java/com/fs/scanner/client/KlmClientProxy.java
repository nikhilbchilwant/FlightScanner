package com.fs.scanner.client;

import com.fs.scanner.common.handler.OfferProvider;
import com.fs.scanner.common.model.Offer;
import com.fs.scanner.klm.handler.KlmApi;
import jakarta.enterprise.context.Dependent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Dependent
public class KlmClientProxy implements OfferProvider {

    private static final Log log = LogFactory.getLog(KlmClientProxy.class);

    @RestClient
    private KlmApi klmClient;

    @Override
    public Offer call() {
        log.info("KLM client " + klmClient);
        com.fs.scanner.klm.model.Offer klmOffer = klmClient.offer(null);
        return new Offer("KLM", klmOffer.getOfferPrice());
    }
}
