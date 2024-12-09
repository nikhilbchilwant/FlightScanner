package com.fs.scanner.klm.model;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("FlightDetails")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.8.0")
public class FlightDetails   {
  private String origin;
  private String destination;
  private Object travelDate = null;

  /**
   * Airport code of starting point
   **/
  public FlightDetails origin(String origin) {
    this.origin = origin;
    return this;
  }

  
  @JsonProperty("origin")
  public String getOrigin() {
    return origin;
  }

  @JsonProperty("origin")
  public void setOrigin(String origin) {
    this.origin = origin;
  }

  /**
   * Airport code of destination point
   **/
  public FlightDetails destination(String destination) {
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
  public FlightDetails travelDate(Object travelDate) {
    this.travelDate = travelDate;
    return this;
  }

  
  @JsonProperty("travelDate")
  public Object getTravelDate() {
    return travelDate;
  }

  @JsonProperty("travelDate")
  public void setTravelDate(Object travelDate) {
    this.travelDate = travelDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlightDetails flightDetails = (FlightDetails) o;
    return Objects.equals(this.origin, flightDetails.origin) &&
        Objects.equals(this.destination, flightDetails.destination) &&
        Objects.equals(this.travelDate, flightDetails.travelDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(origin, destination, travelDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlightDetails {\n");
    
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    travelDate: ").append(toIndentedString(travelDate)).append("\n");
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

