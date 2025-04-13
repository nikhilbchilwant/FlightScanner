package com.fs.scanner.client;

import com.fs.scanner.common.model.FlightDetails;
import io.quarkus.cache.CacheKeyGenerator;
import io.quarkus.cache.CompositeCacheKey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Method;

public class FlightDetailsCacheKeyGenerator implements CacheKeyGenerator {

    private static final Log log = LogFactory.getLog(FlightDetailsCacheKeyGenerator.class);

    @Override
    public Object generate(Method method, Object... methodParams) {
        try {
            FlightDetails flightDetails = (FlightDetails) methodParams[0];
            return new CompositeCacheKey(method.getDeclaringClass().getSimpleName(), flightDetails.getSource(),
                    flightDetails.getDestination(), flightDetails.getTravelDate());
        } catch (ClassCastException incorrectParameterEx) {
            log.error("Failed to generate cache key due to incorrect parameter", incorrectParameterEx);
            return null;
        }
    }
}
