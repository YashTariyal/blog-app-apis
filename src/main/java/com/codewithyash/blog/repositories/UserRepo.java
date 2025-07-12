package com.codewithyash.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithyash.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	// Search methods
	List<User> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);
	List<User> findByNameContainingIgnoreCase(String name);
}
