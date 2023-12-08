package com.example.security.basicauth.dto;


import com.example.security.basicauth.model.Role;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;


import java.util.Set;


@Builder
@Data
public class CreateUserRequest{

    private String name;
    private String username;
    private String password;
    private Set<Role> authorities;

}
