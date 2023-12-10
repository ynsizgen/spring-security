package com.example.security.basicauth;

import com.example.security.basicauth.dto.CreateUserRequest;
import com.example.security.basicauth.model.Role;
import com.example.security.basicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

	private final UserService userService;

	public BasicAuthApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		createDummyData();
	}

	private void createDummyData() {

		CreateUserRequest request = CreateUserRequest.builder()
				.name("John Doe")
				.username("john")
				.password("1234")
				.authorities(Set.of(Role.ROLE_ADMIN, Role.ROLE_USER))
				.build();

		userService.createUser(request);

		CreateUserRequest request1 = CreateUserRequest.builder()
				.name("ahmet")
				.username("ahmet")
				.password("1234")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.createUser(request1);

		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("ali")
				.username("ali")
				.password("1234")
				.authorities(Set.of(Role.ROLE_MODERATOR))
				.build();
		userService.createUser(request2);
	}


}
