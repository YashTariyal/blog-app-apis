package com.codewithyash.blog.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codewithyash.blog.entities.Post;
import com.codewithyash.blog.entities.Category;
import com.codewithyash.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByCategory(Category category);
	List<Post> findByUser(User user);
	List<Post> findByTitleContaining(String title);
	
	// Search methods
	List<Post> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title, String content);
	Page<Post> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title, String content, Pageable pageable);
	List<Post> findByTitleContainingIgnoreCase(String title);
	
	@Query("SELECT p FROM Post p WHERE " +
	       "(:keyword IS NULL OR p.title LIKE %:keyword% OR p.content LIKE %:keyword%) AND " +
	       "(:category IS NULL OR p.category.categoryTitle LIKE %:category%) AND " +
	       "(:author IS NULL OR p.user.name LIKE %:author%)")
	List<Post> findByAdvancedSearch(@Param("keyword") String keyword, 
	                               @Param("category") String category, 
	                               @Param("author") String author);
}
