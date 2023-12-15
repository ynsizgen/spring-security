package com.example.jwttoken.controller;

import com.example.jwttoken.dto.AuthRequest;
import com.example.jwttoken.dto.CreateUserRequest;
import com.example.jwttoken.model.User;
import com.example.jwttoken.service.JwtService;
import com.example.jwttoken.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
public class UserController {
    private final UserService userService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Every think all right";
    }

    @PostMapping("/addNewUser")
    public boolean addUser(@RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest request){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
                if(authentication.isAuthenticated()){
                    return jwtService.generateToken(request.username());
                }
                log.info("Invalid username",request.username());
                throw new UsernameNotFoundException("invalid username {}"+ request.username());
    }

    @GetMapping("/user")
    public String getUserString(){
        return "This is USER!";
    }

    @GetMapping("/admin")
    public String getAdminString(){
        return "This is ADMIN!";
    }



}
