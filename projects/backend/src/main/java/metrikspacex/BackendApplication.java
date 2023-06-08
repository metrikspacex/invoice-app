package metrikspacex;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import metrikspacex.entities.User;
import metrikspacex.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

@SpringBootApplication(
    exclude = {SecurityAutoConfiguration.class, SessionAutoConfiguration.class})
public class BackendApplication {
  public static void main(String[] args) {
    SpringApplication.run(BackendApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(UserRepository userRepository)
      throws FileNotFoundException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    // Load user data from resources
    byte[] userInvoiceData = Files.readAllBytes(
        ResourceUtils.getFile("classpath:simple-invoice.json").toPath());

    List<User> demoUsers = objectMapper.readValue(
        userInvoiceData, new TypeReference<List<User>>() {});

    System.out.println(demoUsers);
    return args -> { userRepository.saveAll(demoUsers); };
  }
}
