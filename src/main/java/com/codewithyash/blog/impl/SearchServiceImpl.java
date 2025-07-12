package com.codewithyash.blog.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codewithyash.blog.entities.Post;
import com.codewithyash.blog.entities.User;
import com.codewithyash.blog.entities.Category;
import com.codewithyash.blog.payloads.PostDto;
import com.codewithyash.blog.payloads.UserDto;
import com.codewithyash.blog.payloads.CategoryDto;
import com.codewithyash.blog.payloads.SearchResult;
import com.codewithyash.blog.repositories.PostRepo;
import com.codewithyash.blog.repositories.UserRepo;
import com.codewithyash.blog.repositories.CategoryRepo;
import com.codewithyash.blog.services.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private PostRepo postRepo;
    
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private CategoryRepo categoryRepo;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostDto> searchPosts(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        String searchTerm = "%" + keyword.toLowerCase() + "%";
        List<Post> posts = postRepo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(searchTerm, searchTerm);
        
        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> searchPosts(String keyword, int page, int size) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        Pageable pageable = PageRequest.of(page, size);
        String searchTerm = "%" + keyword.toLowerCase() + "%";
        Page<Post> postPage = postRepo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(searchTerm, searchTerm, pageable);
        
        return postPage.getContent().stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> searchUsers(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        String searchTerm = "%" + keyword.toLowerCase() + "%";
        List<User> users = userRepo.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(searchTerm, searchTerm);
        
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDto> searchCategories(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        String searchTerm = "%" + keyword.toLowerCase() + "%";
        List<Category> categories = categoryRepo.findByCategoryTitleContainingIgnoreCaseOrCategoryDescriptionContainingIgnoreCase(searchTerm, searchTerm);
        
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SearchResult globalSearch(String keyword) {
        SearchResult result = new SearchResult(keyword);
        
        if (keyword == null || keyword.trim().isEmpty()) {
            result.setPosts(new ArrayList<>());
            result.setUsers(new ArrayList<>());
            result.setCategories(new ArrayList<>());
            result.setTotalResults(0);
            return result;
        }
        
        // Search posts
        List<PostDto> posts = searchPosts(keyword);
        result.setPosts(posts);
        
        // Search users
        List<UserDto> users = searchUsers(keyword);
        result.setUsers(users);
        
        // Search categories
        List<CategoryDto> categories = searchCategories(keyword);
        result.setCategories(categories);
        
        // Calculate total results
        result.setTotalResults();
        
        // Calculate search time
        result.setSearchTime(System.currentTimeMillis() - result.getSearchTime());
        
        return result;
    }

    @Override
    public List<PostDto> advancedSearch(String keyword, String category, String author, String dateRange) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        String searchTerm = "%" + keyword.toLowerCase() + "%";
        List<Post> posts = postRepo.findByAdvancedSearch(searchTerm, category, author);
        
        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> searchPostsByTags(List<String> tags) {
        if (tags == null || tags.isEmpty()) {
            return new ArrayList<>();
        }
        
        // For now, we'll search by title and content that contains the tags
        // In a real implementation, you'd have a separate tags table
        List<Post> posts = new ArrayList<>();
        for (String tag : tags) {
            String searchTerm = "%" + tag.toLowerCase() + "%";
            List<Post> tagPosts = postRepo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(searchTerm, searchTerm);
            posts.addAll(tagPosts);
        }
        
        // Remove duplicates
        posts = posts.stream().distinct().collect(Collectors.toList());
        
        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getSearchSuggestions(String partialKeyword) {
        if (partialKeyword == null || partialKeyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        String searchTerm = "%" + partialKeyword.toLowerCase() + "%";
        List<String> suggestions = new ArrayList<>();
        
        // Get post titles
        List<Post> posts = postRepo.findByTitleContainingIgnoreCase(searchTerm);
        suggestions.addAll(posts.stream()
                .map(Post::getTitle)
                .limit(5)
                .collect(Collectors.toList()));
        
        // Get user names
        List<User> users = userRepo.findByNameContainingIgnoreCase(searchTerm);
        suggestions.addAll(users.stream()
                .map(User::getName)
                .limit(3)
                .collect(Collectors.toList()));
        
        // Get category titles
        List<Category> categories = categoryRepo.findByCategoryTitleContainingIgnoreCase(searchTerm);
        suggestions.addAll(categories.stream()
                .map(Category::getCategoryTitle)
                .limit(3)
                .collect(Collectors.toList()));
        
        return suggestions.stream().distinct().limit(10).collect(Collectors.toList());
    }
} 