package com.example.demo.config;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {
            List<String> roleNames = List.of("ADMIN", "EDITOR", "CONTRIBUTOR", "REVIEWER", "VIEWER");

            for (String roleName : roleNames) {
                // Only insert if it doesn't already exist
                if (roleRepository.findByName(roleName).isEmpty()) {
                    Role role = new Role();
                    role.setName(roleName);
                    roleRepository.save(role);
                    System.out.println("Inserted role: " + roleName);
                } else {
                    System.out.println("Role already exists: " + roleName);
                }
            }
        };
    }
}
