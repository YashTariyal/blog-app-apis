package com.codewithyash.blog.services;

import java.util.List;
import com.codewithyash.blog.payloads.PostDto;
import com.codewithyash.blog.payloads.UserDto;
import com.codewithyash.blog.payloads.CategoryDto;
import com.codewithyash.blog.payloads.SearchResult;

public interface SearchService {
    
    /**
     * Search posts by keyword
     */
    List<PostDto> searchPosts(String keyword);
    
    /**
     * Search posts by keyword with pagination
     */
    List<PostDto> searchPosts(String keyword, int page, int size);
    
    /**
     * Search users by name or email
     */
    List<UserDto> searchUsers(String keyword);
    
    /**
     * Search categories by title or description
     */
    List<CategoryDto> searchCategories(String keyword);
    
    /**
     * Global search across all entities
     */
    SearchResult globalSearch(String keyword);
    
    /**
     * Advanced search with filters
     */
    List<PostDto> advancedSearch(String keyword, String category, String author, String dateRange);
    
    /**
     * Search posts by tags
     */
    List<PostDto> searchPostsByTags(List<String> tags);
    
    /**
     * Get search suggestions
     */
    List<String> getSearchSuggestions(String partialKeyword);
} 