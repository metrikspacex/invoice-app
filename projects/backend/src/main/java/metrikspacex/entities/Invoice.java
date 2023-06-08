package metrikspacex.entities;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Embeddable
@Table(name = "invoice")
public class Invoice {

  @Column(name = "client_address", nullable = false)
  @Embedded
  private ClientAddress clientAddress;

  @Column(name = "client_email", nullable = false) private String clientEmail;

  @Column(name = "client_name", nullable = false) private String clientName;

  @Column(name = "created_at", nullable = false)
  @CreatedDate
  private Date createdAt;

  @Column(name = "description", nullable = false) private String description;

  @Id
  @GenericGenerator(name = "invoice_id",
                    strategy = "metrikspacex.generators.InvoiceIdGenerator")
  @GeneratedValue(generator = "invoice_id", strategy = GenerationType.SEQUENCE)
  private String id;

  @Column(name = "items", nullable = false)
  @ElementCollection(targetClass = Items.class, fetch = FetchType.EAGER)
  @Embedded
  private List<Items> items = new ArrayList<Items>();

  @Column(name = "payment_due", nullable = false) private Date paymentDue;

  @Column(name = "payment_terms", nullable = false) private Double paymentTerms;

  @Column(name = "sender_address", nullable = false)
  @Embedded
  private SenderAddress senderAddress;

  @Column(name = "status", nullable = false) private String status;

  @Column(name = "total", nullable = false) private Double total;

  // Constructors
  public Invoice() {}

  public Invoice(ClientAddress clientAddress, String clientEmail,
                 String clientName, String createdAt, String description,
                 List<Items> items, String paymentDue, Double paymentTerms,
                 SenderAddress senderAddress, String status, Double total) {
    this.clientAddress = clientAddress;
    this.clientEmail = clientEmail;
    this.clientName = clientName;
    this.createdAt = Date.valueOf(createdAt);
    this.description = description;
    this.items = items;
    this.paymentDue = Date.valueOf(paymentDue);
    this.paymentTerms = paymentTerms;
    this.senderAddress = senderAddress;
    this.status = status;
    this.total = total;
  }

  public Invoice(ClientAddress clientAddress, String clientEmail,
                 String clientName, String createdAt, String description,
                 String id, List<Items> items, String paymentDue,
                 Double paymentTerms, SenderAddress senderAddress,
                 String status, Double total) {
    this.clientAddress = clientAddress;
    this.clientEmail = clientEmail;
    this.clientName = clientName;
    this.createdAt = Date.valueOf(createdAt);
    this.description = description;
    this.id = id;
    this.items = items;
    this.paymentDue = Date.valueOf(paymentDue);
    this.paymentTerms = paymentTerms;
    this.senderAddress = senderAddress;
    this.status = status;
    this.total = total;
  }

  // Equals
  @Override
  public boolean equals(Object object) {
    if (this == object)
      return true;
    if (!(object instanceof Invoice))
      return false;

    Invoice invoice = (Invoice)object;
    return Objects.equals(this.clientAddress, invoice.clientAddress) &&
        Objects.equals(this.clientEmail, invoice.clientEmail) &&
        Objects.equals(this.clientName, invoice.clientName) &&
        Objects.equals(this.createdAt, invoice.createdAt) &&
        Objects.equals(this.description, invoice.description) &&
        Objects.equals(this.id, invoice.id) &&
        Objects.equals(this.items, invoice.items) &&
        Objects.equals(this.paymentDue, invoice.paymentDue) &&
        Objects.equals(this.paymentTerms, invoice.paymentTerms) &&
        Objects.equals(this.senderAddress, invoice.senderAddress) &&
        Objects.equals(this.status, invoice.status) &&
        Objects.equals(this.total, invoice.total);
  }

  // Getters
  public ClientAddress getClientAddress() { return this.clientAddress; }

  public String getClientEmail() { return this.clientEmail; }

  public String getClientName() { return this.clientName; }

  public String getCreatedAt() { return this.createdAt.toString(); }

  public String getDescription() { return this.description; }

  public String getId() { return this.id; }

  public List<Items> getItems() { return this.items; }

  public String getPaymentDue() { return this.paymentDue.toString(); }

  public Double getPaymentTerms() { return this.paymentTerms; }

  public SenderAddress getSenderAddress() { return this.senderAddress; }

  public String getStatus() { return this.status; }

  public Double getTotal() { return this.total; }

  // Hashcode
  @Override
  public int hashCode() {
    return Objects.hash(this.clientAddress, this.clientEmail, this.clientName,
                        this.createdAt, this.description, this.id, this.items,
                        this.paymentDue, this.paymentTerms, this.senderAddress,
                        this.status, this.total);
  }

  // Setters
  public void setClientAddress(ClientAddress clientAddress) {
    this.clientAddress = clientAddress;
  }

  public void setClientEmail(String clientEmail) {
    this.clientEmail = clientEmail;
  }

  public void setClientName(String clientName) { this.clientName = clientName; }

  public void setCreatedAt(String createdAt) {
    this.createdAt = Date.valueOf(createdAt);
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setId(String id) {
    if (this.checkId(id)) {
      this.id = id;
    } else {
      Random random = new Random();
      String prefix = RandomStringUtils.randomAlphabetic(2).toUpperCase();
      String suffix = String.format("%04d", random.nextInt(10000));
      this.id = prefix + suffix;
    }
  }

  public void setItems(List<Items> items) { this.items = items; }

  public void setPaymentDue(String paymentDue) {
    this.paymentDue = Date.valueOf(paymentDue);
  }

  public void setPaymentTerms(Double paymentTerms) {
    this.paymentTerms = paymentTerms;
  }

  public void setSenderAddress(SenderAddress senderAddress) {
    this.senderAddress = senderAddress;
  }

  public void setStatus(String status) { this.status = status; }

  public void setTotal(Double total) { this.total = total; }

  // toString
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Invoice [clientAddress=")
        .append(clientAddress)
        .append(", clientEmail=")
        .append(clientEmail)
        .append(", clientName=")
        .append(clientName)
        .append(", createdAt=")
        .append(createdAt)
        .append(", description=")
        .append(description)
        .append(", id=")
        .append(id)
        .append(", items=")
        .append(items)
        .append(", paymentDue=")
        .append(paymentDue)
        .append(", paymentTerms=")
        .append(paymentTerms)
        .append(", senderAddress=")
        .append(senderAddress)
        .append(", status=")
        .append(status)
        .append(", total=")
        .append(total)
        .append("]");
    return builder.toString();
  }

  // Utilities
  private Boolean checkId(String id) {
    if (id.length() != 6)
      return false;

    for (Character c : id.substring(0, 2).toCharArray()) {
      if (!Character.isAlphabetic(c))
        return false;
    }

    for (Character c : id.substring(2).toCharArray()) {
      if (!Character.isDigit(c))
        return false;
    }

    return true;
  }
}
