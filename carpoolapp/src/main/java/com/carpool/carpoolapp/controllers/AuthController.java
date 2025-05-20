package com.carpool.carpoolapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carpool.carpoolapp.dto.RegisterRequest;
import com.carpool.carpoolapp.models.User;
import com.carpool.carpoolapp.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public String register(@RequestBody RegisterRequest request) {
		User user = User.builder()
				.email(request.getEmail())
				.name(request.getName())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(request.getRole())
				.build();
		userRepository.save(user);
		return "User Created Successfully!!";
	}
}
