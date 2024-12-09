package com.fs.scanner.model;

import java.time.OffsetDateTime;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("Flight")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.8.0")
public class Flight   {
  private Long id;
  private String source;
  private String destination;
  private OffsetDateTime departure;
  private OffsetDateTime arrival;

  /**
   **/
  public Flight id(Long id) {
    this.id = id;
    return this;
  }

  
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Long id) {
    this.id = id;
  }

  /**
   **/
  public Flight source(String source) {
    this.source = source;
    return this;
  }

  
  @JsonProperty("source")
  public String getSource() {
    return source;
  }

  @JsonProperty("source")
  public void setSource(String source) {
    this.source = source;
  }

  /**
   **/
  public Flight destination(String destination) {
    this.destination = destination;
    return this;
  }

  
  @JsonProperty("destination")
  public String getDestination() {
    return destination;
  }

  @JsonProperty("destination")
  public void setDestination(String destination) {
    this.destination = destination;
  }

  /**
   **/
  public Flight departure(OffsetDateTime departure) {
    this.departure = departure;
    return this;
  }

  
  @JsonProperty("departure")
  public OffsetDateTime getDeparture() {
    return departure;
  }

  @JsonProperty("departure")
  public void setDeparture(OffsetDateTime departure) {
    this.departure = departure;
  }

  /**
   **/
  public Flight arrival(OffsetDateTime arrival) {
    this.arrival = arrival;
    return this;
  }

  
  @JsonProperty("arrival")
  public OffsetDateTime getArrival() {
    return arrival;
  }

  @JsonProperty("arrival")
  public void setArrival(OffsetDateTime arrival) {
    this.arrival = arrival;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Flight flight = (Flight) o;
    return Objects.equals(this.id, flight.id) &&
        Objects.equals(this.source, flight.source) &&
        Objects.equals(this.destination, flight.destination) &&
        Objects.equals(this.departure, flight.departure) &&
        Objects.equals(this.arrival, flight.arrival);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, source, destination, departure, arrival);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Flight {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    departure: ").append(toIndentedString(departure)).append("\n");
    sb.append("    arrival: ").append(toIndentedString(arrival)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

