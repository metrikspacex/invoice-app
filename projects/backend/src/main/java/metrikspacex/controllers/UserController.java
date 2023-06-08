package metrikspacex.controllers;

import java.util.ArrayList;
import java.util.List;
import metrikspacex.entities.ClientAddress;
import metrikspacex.entities.Invoice;
import metrikspacex.entities.User;
import metrikspacex.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping(value = "/api/v1/user")
  public List<User> findAll() {
    return this.userRepository.findAll();
  }

  @GetMapping(value = "/api/v1/user/invoices")
  public List<Invoice> findInvoicesByEmail() {
    return new ArrayList<Invoice>() {
      { add(new Invoice(new ClientAddress("", "", 1, "", ""), 1)); }
    };
  }
}
