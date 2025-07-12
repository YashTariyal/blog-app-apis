package com.codewithyash.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.codewithyash.blog.repositories")
public class SearchConfig {

    @Bean
    public String searchConfigInfo() {
        System.out.println("🔍 Search Configuration Loaded");
        System.out.println("📊 Available Search Features:");
        System.out.println("   - Global search across posts, users, categories");
        System.out.println("   - Advanced search with filters");
        System.out.println("   - Search suggestions");
        System.out.println("   - Tag-based search");
        System.out.println("   - Paginated search results");
        return "Search configuration initialized";
    }
} 