package com.carpool.carpoolapp.dto;

import com.carpool.carpoolapp.entities.Role;

import lombok.Data;

@Data
public class RegisterRequest {
	private String email;
	private String password;
	private String name;
	private Role role;
}
