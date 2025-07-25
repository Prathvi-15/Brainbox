package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
  private final User user;
  public UserDetailsImpl(User u) { this.user = u; }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return user.getRoles().stream()
        .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName()))
        .collect(Collectors.toSet());
  }
  @Override public String getPassword() { return user.getPassword(); }
  @Override public String getUsername() { return user.getUsername(); }
  @Override public boolean isAccountNonExpired() { return true; }
  @Override public boolean isAccountNonLocked() { return true; }
  @Override public boolean isCredentialsNonExpired() { return true; }
  @Override public boolean isEnabled() { return true; }
}
