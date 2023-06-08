package metrikspacex.Filters;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecurityFilter {
  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
      throws Exception {
    httpSecurity.authorizeHttpRequests(authorizeHttpRequestsCustomizer -> {
      authorizeHttpRequestsCustomizer
          .requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
          .permitAll();
    });
    return httpSecurity.build();
  }
}
