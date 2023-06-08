package metrikspacex.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "_user")
public class User {
  private String email;

  @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn()
  private List<Invoice> invoices;

  private String password;
}
