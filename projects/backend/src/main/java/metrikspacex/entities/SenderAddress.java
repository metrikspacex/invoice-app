package metrikspacex.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class SenderAddress {
  @Column(name = "sender_address_city", nullable = false) private String city;

  @Column(name = "sender_address_country", nullable = false)
  private String country;

  @Column(name = "sender_address_post_code", nullable = false)
  private String postCode;

  @Column(name = "sender_address_street", nullable = false)
  private String street;

  // Constructors
  public SenderAddress() {}

  public SenderAddress(String city, String country, String postCode,
                       String street) {
    this.city = city;
    this.country = country;
    this.postCode = postCode;
    this.street = street;
  }

  // Equals
  @Override
  public boolean equals(Object object) {
    if (this == object)
      return true;
    if (!(object instanceof SenderAddress))
      return false;

    SenderAddress senderAddress = (SenderAddress)object;
    return Objects.equals(this.city, senderAddress.city) &&
        Objects.equals(this.country, senderAddress.country) &&
        Objects.equals(this.postCode, senderAddress.postCode) &&
        Objects.equals(this.street, senderAddress.street);
  }

  // Getters
  public String getCity() { return this.city; }

  public String getCountry() { return this.country; }

  public String getPostCode() { return this.postCode; }

  public String getStreet() { return this.street; }

  // Hashcode
  @Override
  public int hashCode() {
    return Objects.hash(this.city, this.country, this.postCode, this.street);
  }

  // Setters
  public void setCity(String city) { this.city = city; }

  public void setCountry(String country) { this.country = country; }

  public void setPostCode(String postCode) { this.postCode = postCode; }

  public void setStreet(String street) { this.street = street; }

  // toString
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SenderAddress [city=")
        .append(this.city)
        .append(", country=")
        .append(this.country)
        .append(", postCode=")
        .append(this.postCode)
        .append(", street=")
        .append(this.street)
        .append("]");
    return builder.toString();
  }
}
