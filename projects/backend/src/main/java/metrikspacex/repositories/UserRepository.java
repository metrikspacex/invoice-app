package metrikspacex.repositories;

import java.util.List;
import metrikspacex.entities.Invoice;
import metrikspacex.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  @Query(value = "SELECT * FROM _USER  WHERE EMAIL = ?", nativeQuery = true)
  List<Invoice> findInvoicesByEmail(String email);
}
