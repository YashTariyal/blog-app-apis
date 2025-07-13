package com.codewithyash.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codewithyash.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	// Search methods
	List<Category> findByCategoryTitleContainingIgnoreCaseOrCategoryDescriptionContainingIgnoreCase(String title, String description);
	List<Category> findByCategoryTitleContainingIgnoreCase(String title);
	
	// Custom query for debugging
	@Query("SELECT c FROM Category c WHERE c.categoryTitle LIKE %:keyword% OR c.categoryDescription LIKE %:keyword%")
	List<Category> searchCategoriesByKeyword(@Param("keyword") String keyword);
}
