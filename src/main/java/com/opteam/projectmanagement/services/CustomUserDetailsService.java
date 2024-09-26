package com.opteam.projectmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Value("${spring.security.user.name}")
    private String managerUsername;

    @Value("${spring.security.user.password}")
    private String managerPassword;

    @Value("${spring.security.user2.name:}")
    private String employeeUsername;

    @Value("${spring.security.user2.password:}")
    private String employeePassword;

    @Autowired
    public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (managerUsername.equals(username)) {
            return new org.springframework.security.core.userdetails.User(
                    managerUsername, passwordEncoder.encode(managerPassword), new ArrayList<>()
            );
        } else if (employeeUsername.equals(username)) {
            return new org.springframework.security.core.userdetails.User(
                    employeeUsername, passwordEncoder.encode(employeePassword), new ArrayList<>()
            );
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
