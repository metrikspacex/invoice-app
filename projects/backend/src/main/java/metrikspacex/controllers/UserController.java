package metrikspacex.controllers;

import java.util.List;
import metrikspacex.entities.User;
import metrikspacex.services.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  private UserServiceImpl userServiceImpl;

  public UserController(UserServiceImpl userServiceImpl) {
    this.userServiceImpl = userServiceImpl;
  }

  @GetMapping("/api/v1/user")
  public List<User> findAll() {
    return this.userServiceImpl.findAll();
  }
}
