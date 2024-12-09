package com.fs.scanner.klm.model;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("Offer")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.8.0")
public class Offer   {
  private Double offerPrice;

  /**
   * Lowest offered price in Euros
   **/
  public Offer offerPrice(Double offerPrice) {
    this.offerPrice = offerPrice;
    return this;
  }

  
  @JsonProperty("offerPrice")
  public Double getOfferPrice() {
    return offerPrice;
  }

  @JsonProperty("offerPrice")
  public void setOfferPrice(Double offerPrice) {
    this.offerPrice = offerPrice;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Offer offer = (Offer) o;
    return Objects.equals(this.offerPrice, offer.offerPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offerPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Offer {\n");
    
    sb.append("    offerPrice: ").append(toIndentedString(offerPrice)).append("\n");
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

