package com.example.demo.config;

import com.example.demo.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  private final UserDetailsServiceImpl uds;
  public SecurityConfig(UserDetailsServiceImpl uds) { this.uds = uds; }

  @Bean BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(auth -> auth
         .requestMatchers("/login", "/css/**", "/js/**").permitAll()
         .requestMatchers("/admin/**").hasRole("ADMIN")
         .requestMatchers("/contributor/**").hasRole("CONTRIBUTOR")
         .anyRequest().authenticated()
      )
      .userDetailsService(uds)
      .formLogin(form -> form
         .loginPage("/login")
         .defaultSuccessUrl("/dashboard", true)
         .permitAll()
      )
      .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login"));
    return http.build();
  }
}
