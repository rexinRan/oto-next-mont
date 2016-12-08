package redis;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

public class Address implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = -3051830568172510046L;
  private String            number;
  private String            street;
  private String            town;
  private String            postcode;

  public String getNumber() {
    return number;
  }
  public void setNumber(String number) {
    this.number = number;
  }
  public String getStreet() {
    return street;
  }
  public void setStreet(String street) {
    this.street = street;
  }
  public String getTown() {
    return town;
  }
  public void setTown(String town) {
    this.town = town;
  }
  public String getPostcode() {
    return postcode;
  }
  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}