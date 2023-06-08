package metrikspacex.services;

import java.util.List;
import metrikspacex.entities.User;

public interface UserService {
  List<User> findAll();
  User save(User user);
}
