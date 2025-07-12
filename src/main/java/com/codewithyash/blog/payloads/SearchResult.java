package com.codewithyash.blog.payloads;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResult {
    
    private List<PostDto> posts;
    private List<UserDto> users;
    private List<CategoryDto> categories;
    private int totalResults;
    private String searchKeyword;
    private long searchTime;
    
    public SearchResult(String keyword) {
        this.searchKeyword = keyword;
        this.searchTime = System.currentTimeMillis();
    }
    
    public void setTotalResults() {
        this.totalResults = (posts != null ? posts.size() : 0) + 
                           (users != null ? users.size() : 0) + 
                           (categories != null ? categories.size() : 0);
    }
} 