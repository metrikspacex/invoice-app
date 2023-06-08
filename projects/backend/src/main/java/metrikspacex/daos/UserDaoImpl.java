package metrikspacex.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import metrikspacex.entities.Invoice;
import metrikspacex.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
  private EntityManager entityManager;

  public UserDaoImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<User> findAll() {
    TypedQuery<User> query = entityManager.createQuery("from User", User.class);
    List<User> user = query.getResultList();
    return user;
  }

  @Override
  public List<Invoice> findInvoicesByEmail(int id) {
    TypedQuery<Invoice> query = entityManager.createQuery(
        "from Course where instructor.id = :data", Invoice.class);
    query.setParameter("data", id);
    List<Invoice> invoices = query.getResultList();
    return invoices;
  }

  @Override
  @Transactional
  public User save(User user) {
    User _user = entityManager.merge(user);
    return _user;
  }
}
