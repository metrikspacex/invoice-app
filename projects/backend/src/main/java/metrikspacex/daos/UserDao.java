package metrikspacex.daos;

import java.util.List;
import metrikspacex.entities.Invoice;
import metrikspacex.entities.User;

public interface UserDao {
  List<User> findAll();
  List<Invoice> findInvoicesByEmail(int id);
  User save(User user);
}
