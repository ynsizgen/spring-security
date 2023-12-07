package com.example.security.basicauth.dto;


import com.example.security.basicauth.model.Role;

import java.util.Set;

public record CreateUserRequest(
    String name,
    String username,
    String password,
    Set<Role> authorities) {
}
