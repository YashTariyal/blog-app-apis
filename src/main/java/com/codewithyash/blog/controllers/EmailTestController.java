package com.codewithyash.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithyash.blog.payloads.ApiResponse;
import com.codewithyash.blog.payloads.UserDto;
import com.codewithyash.blog.services.EmailService;

@RestController
@RequestMapping("/api/test/email")
public class EmailTestController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/welcome")
    public ResponseEntity<ApiResponse> testWelcomeEmail(@RequestParam String email, @RequestParam String name) {
        try {
            UserDto testUser = new UserDto();
            testUser.setEmail(email);
            testUser.setName(name);
            
            emailService.sendWelcomeEmail(testUser);
            
            return ResponseEntity.ok(new ApiResponse("Welcome email sent successfully to " + email, true));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse("Failed to send email: " + e.getMessage(), false));
        }
    }

    @PostMapping("/comment-notification")
    public ResponseEntity<ApiResponse> testCommentNotification(
            @RequestParam String authorEmail,
            @RequestParam String authorName,
            @RequestParam String commenterName,
            @RequestParam String postTitle,
            @RequestParam String commentContent) {
        try {
            UserDto author = new UserDto();
            author.setEmail(authorEmail);
            author.setName(authorName);
            
            emailService.sendCommentNotification(author, commenterName, postTitle, commentContent);
            
            return ResponseEntity.ok(new ApiResponse("Comment notification sent successfully to " + authorEmail, true));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse("Failed to send email: " + e.getMessage(), false));
        }
    }
} 