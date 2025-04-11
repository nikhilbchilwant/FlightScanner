package com.fs.scanner.common.model;

import java.time.LocalDate;

public class FlightDetails {
    private String source;
    private String destination;
    private LocalDate travelDate;

    private FlightDetails(FlightDetailsBuilder flightDetailsBuilder) {
        this.source = flightDetailsBuilder.source;
        this.destination = flightDetailsBuilder.destination;
        this.travelDate = flightDetailsBuilder.travelDate;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public static class FlightDetailsBuilder {
        private String source;
        private String destination;
        private LocalDate travelDate;

        public FlightDetailsBuilder setSource(String source) {
            this.source = source;
            return this;
        }

        public FlightDetailsBuilder setDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public FlightDetailsBuilder setTravelDate(LocalDate travelDate) {
            this.travelDate = travelDate;
            return this;
        }

        public FlightDetails build() {
            return new FlightDetails(this);
        }
    }
}



