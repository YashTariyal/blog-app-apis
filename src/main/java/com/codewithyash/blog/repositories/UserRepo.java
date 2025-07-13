package com.codewithyash.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codewithyash.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	// Search methods
	List<User> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);
	List<User> findByNameContainingIgnoreCase(String name);
	
	// Custom query for debugging
	@Query("SELECT u FROM User u WHERE u.name LIKE %:keyword% OR u.email LIKE %:keyword%")
	List<User> searchUsersByKeyword(@Param("keyword") String keyword);
	
	// Simple query to get all users with names
	@Query("SELECT u FROM User u WHERE u.name IS NOT NULL AND u.name != ''")
	List<User> findAllUsersWithNames();
}
