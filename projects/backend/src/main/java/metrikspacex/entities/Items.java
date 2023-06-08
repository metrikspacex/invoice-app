package metrikspacex.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Items {
  @Column(name = "items_name", nullable = false) private String name;
  @Column(name = "items_price", nullable = false) private Double price;
  @Column(name = "items_quantity", nullable = false) private Integer quantity;
  @Column(name = "items_total", nullable = false) private Double total;

  // Constructors
  public Items() {}

  public Items(String name, Double price, int quantity, Double total) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.total = total;
  }

  // Equals
  @Override
  public boolean equals(Object object) {
    if (this == object)
      return true;
    if (!(object instanceof Items))
      return false;

    Items items = (Items)object;
    return Objects.equals(this.name, items.name) &&
        Objects.equals(this.price, items.price) &&
        Objects.equals(this.quantity, items.quantity) &&
        Objects.equals(this.total, items.total);
  }

  // Getters
  public String getName() { return this.name; }

  public Double getPrice() { return this.price; }

  public Integer getQuantity() { return this.quantity; }

  public Double getTotal() { return this.total; }

  // Hashcode
  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.price, this.quantity, this.total);
  }

  // Setters
  public void setName(String name) { this.name = name; }

  public void setPrice(Double price) { this.price = price; }

  public void setQuantity(Integer quantity) { this.quantity = quantity; }

  public void setTotal(Double total) { this.total = total; }

  // toString
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Items [name=")
        .append(this.name)
        .append(", price=")
        .append(this.price)
        .append(", quantity=")
        .append(this.quantity)
        .append(", total=")
        .append(this.total)
        .append("]");
    return builder.toString();
  }
}
