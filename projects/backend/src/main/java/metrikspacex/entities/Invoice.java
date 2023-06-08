package metrikspacex.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "_invoice")
public class Invoice {
  @OneToOne(cascade = CascadeType.ALL) private ClientAddress clientAddress;

  @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;
}
