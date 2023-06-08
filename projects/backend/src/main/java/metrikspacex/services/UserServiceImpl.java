package metrikspacex.services;

import java.util.List;
import metrikspacex.daos.UserDaoImpl;
import metrikspacex.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private UserDaoImpl userDaoImpl;

  public UserServiceImpl(UserDaoImpl userDaoImpl) {
    this.userDaoImpl = userDaoImpl;
  }

  @Override
  public List<User> findAll() {
    return this.userDaoImpl.findAll();
  }

  @Override
  public User save(User user) {
    return this.userDaoImpl.save(user);
  }
}
