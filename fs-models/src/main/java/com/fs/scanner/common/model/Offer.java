package com.fs.scanner.common.model;

public class Offer {

    private String bidder;
    private double value;
    private String source;
    private String destination;

    private Offer(String bidder, double value, String source, String destination) {
        this.bidder = bidder;
        this.value = value;
        this.source = source;
        this.destination = destination;
    }

    public String getBidder() {
        return bidder;
    }

    public void setBidder(String bidder) {
        this.bidder = bidder;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public static class OfferBuilder {
        private String bidder;
        private double value;
        private String source;
        private String destination;

        public OfferBuilder setBidder(String bidder) {
            this.bidder = bidder;
            return this;
        }

        public OfferBuilder setValue(double value) {
            this.value = value;
            return this;
        }

        public OfferBuilder setSource(String source) {
            this.source = source;
            return this;
        }

        public OfferBuilder setDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public Offer createOffer() {
            return new Offer(bidder, value, source, destination);
        }
    }
}
