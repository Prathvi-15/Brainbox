package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepo;
  public UserDetailsServiceImpl(UserRepository ur) { this.userRepo = ur; }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User u = userRepo.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    return new UserDetailsImpl(u);
  }
}
