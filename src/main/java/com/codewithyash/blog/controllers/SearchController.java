package com.codewithyash.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithyash.blog.payloads.PostDto;
import com.codewithyash.blog.payloads.UserDto;
import com.codewithyash.blog.payloads.CategoryDto;
import com.codewithyash.blog.payloads.SearchResult;
import com.codewithyash.blog.services.SearchService;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    /**
     * Global search across all entities
     */
    @GetMapping("/global")
    public ResponseEntity<SearchResult> globalSearch(@RequestParam String keyword) {
        SearchResult result = searchService.globalSearch(keyword);
        return ResponseEntity.ok(result);
    }

    /**
     * Search posts by keyword
     */
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> searchPosts(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        List<PostDto> posts = searchService.searchPosts(keyword, page, size);
        return ResponseEntity.ok(posts);
    }

    /**
     * Search users by keyword
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> searchUsers(@RequestParam String keyword) {
        List<UserDto> users = searchService.searchUsers(keyword);
        return ResponseEntity.ok(users);
    }

    /**
     * Search categories by keyword
     */
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> searchCategories(@RequestParam String keyword) {
        List<CategoryDto> categories = searchService.searchCategories(keyword);
        return ResponseEntity.ok(categories);
    }

    /**
     * Advanced search with filters
     */
    @GetMapping("/advanced")
    public ResponseEntity<List<PostDto>> advancedSearch(
            @RequestParam String keyword,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String dateRange) {
        
        List<PostDto> posts = searchService.advancedSearch(keyword, category, author, dateRange);
        return ResponseEntity.ok(posts);
    }

    /**
     * Search posts by tags
     */
    @GetMapping("/tags")
    public ResponseEntity<List<PostDto>> searchByTags(@RequestParam List<String> tags) {
        List<PostDto> posts = searchService.searchPostsByTags(tags);
        return ResponseEntity.ok(posts);
    }

    /**
     * Get search suggestions
     */
    @GetMapping("/suggestions")
    public ResponseEntity<List<String>> getSearchSuggestions(@RequestParam String keyword) {
        List<String> suggestions = searchService.getSearchSuggestions(keyword);
        return ResponseEntity.ok(suggestions);
    }

    /**
     * Quick search - returns posts only
     */
    @GetMapping("/quick")
    public ResponseEntity<List<PostDto>> quickSearch(@RequestParam String keyword) {
        List<PostDto> posts = searchService.searchPosts(keyword);
        return ResponseEntity.ok(posts);
    }
} 