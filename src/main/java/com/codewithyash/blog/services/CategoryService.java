package com.codewithyash.blog.services;

import java.util.List;

import com.codewithyash.blog.payloads.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto category);
	
	CategoryDto updateCategory(CategoryDto category, Integer categoryId);
	
	void deleteCategory(Integer categoryId);
	
	CategoryDto getCategory(Integer categoryId);
	
	List<CategoryDto> getCategories();
		
}
