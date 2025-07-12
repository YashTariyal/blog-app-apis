package com.codewithyash.blog.services;

import com.codewithyash.blog.payloads.UserDto;

public interface EmailService {
    
    /**
     * Send welcome email to new user
     */
    void sendWelcomeEmail(UserDto user);
    
    /**
     * Send email verification link
     */
    void sendVerificationEmail(UserDto user, String verificationToken);
    
    /**
     * Send password reset email
     */
    void sendPasswordResetEmail(UserDto user, String resetToken);
    
    /**
     * Send notification when someone comments on user's post
     */
    void sendCommentNotification(UserDto postAuthor, String commenterName, String postTitle, String commentContent);
    
    /**
     * Send notification when someone follows the user
     */
    void sendFollowNotification(UserDto user, String followerName);
    
    /**
     * Send notification about new post from followed author
     */
    void sendNewPostNotification(UserDto follower, String authorName, String postTitle, String postUrl);
} 