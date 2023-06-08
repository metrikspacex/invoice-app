package metrikspacex.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "_client_address")
public class ClientAddress {
  private String city;

  private String country;

  @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;

  private String postCode;

  private String street;
}
