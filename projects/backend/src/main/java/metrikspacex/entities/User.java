package metrikspacex.entities;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "_user")
public class User {
  @Column(name = "user_email") private String email;

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "id")
  @ElementCollection(targetClass = Invoice.class, fetch = FetchType.EAGER)
  @Embedded
  private List<Invoice> invoices;

  @Column(name = "user_password") private String password;

  @Column(name = "user_role") @Enumerated(EnumType.STRING) private Role role;

  // Constructors
  public User() {}

  public User(String email, List<Invoice> invoices, String password,
              Role role) {
    this.email = email;
    this.invoices = invoices;
    this.password = password;
    this.role = role;
  }

  public User(String email, Integer id, List<Invoice> invoices, String password,
              Role role) {
    this.email = email;
    this.id = id;
    this.invoices = invoices;
    this.password = password;
    this.role = role;
  }

  // Equals
  @Override
  public boolean equals(Object object) {
    if (this == object)
      return true;
    if (!(object instanceof User))
      return false;

    User invoice = (User)object;
    return Objects.equals(this.email, invoice.email) &&
        Objects.equals(this.id, invoice.id) &&
        Objects.equals(this.invoices, invoice.invoices) &&
        Objects.equals(this.password, invoice.password) &&
        Objects.equals(this.role, invoice.role);
  }

  // Getters
  public String getEmail() { return this.email; }

  public Integer getId() { return this.id; }

  public List<Invoice> getInvoices() { return this.invoices; }

  public String getPassword() { return this.password; }

  public Role getRole() { return this.role; }

  // Hashcode
  @Override
  public int hashCode() {
    return Objects.hash(this.email, this.id, this.invoices, this.password,
                        this.role);
  }

  // Setters
  public void setEmail(String email) { this.email = email; }

  public void setId(Integer id) { this.id = id; }

  public void setInvoices(List<Invoice> invoice) { this.invoices = invoice; }

  public void setPassword(String password) { this.password = password; }

  public void setRole(Role role) { this.role = role; }

  // toString
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Authentication [email=")
        .append(this.email)
        .append(", id=")
        .append(this.id)
        .append(", invoice=")
        .append(this.invoices)
        .append(", password=")
        .append(this.password)
        .append(", role=")
        .append(this.role)
        .append("]");
    return builder.toString();
  }
}
