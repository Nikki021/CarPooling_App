package com.carpool.carpoolapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carpool.carpoolapp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
