package com.example.security.basicauth.service;

import com.example.security.basicauth.config.PasswordEncoderConfig;
import com.example.security.basicauth.dto.CreateUserRequest;
import com.example.security.basicauth.model.User;
import com.example.security.basicauth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoderConfig passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoderConfig passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(CreateUserRequest request) {
        User newUser = User.builder()
                .name(request.getName())
                .username(request.getUsername())
                .password(passwordEncoder.bCryptPasswordEncoder().encode(request.getPassword()))
                .authorities(request.getAuthorities())
                .isEnabled(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build();
        return userRepository.save(newUser);
    }


}
