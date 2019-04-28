package com.edu.authservice.service;

import com.edu.authservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserByUsername(username)
                .orElseThrow(usernameNotFoundException(username));
    }

    private Supplier<UsernameNotFoundException> usernameNotFoundException(String username) {
        return () -> new UsernameNotFoundException(String.format("Username %s not found", username));
    }


}
