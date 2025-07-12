package com.codewithyash.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithyash.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	// Search methods
	List<Category> findByCategoryTitleContainingIgnoreCaseOrCategoryDescriptionContainingIgnoreCase(String title, String description);
	List<Category> findByCategoryTitleContainingIgnoreCase(String title);
}
