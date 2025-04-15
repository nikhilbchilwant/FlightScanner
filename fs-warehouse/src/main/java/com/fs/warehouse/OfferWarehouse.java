package com.fs.warehouse;

import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class OfferWarehouse {

    @Incoming("requests")
    @Blocking
    public void process() {

    }
}
