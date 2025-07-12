package com.codewithyash.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.codewithyash.blog.payloads.UserDto;
import com.codewithyash.blog.services.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private TemplateEngine templateEngine;
    
    @Value("${spring.mail.username}")
    private String fromEmail;
    
    @Value("${app.base-url:http://localhost:8080}")
    private String baseUrl;

    @Override
    public void sendWelcomeEmail(UserDto user) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            
            helper.setFrom(fromEmail);
            helper.setTo(user.getEmail());
            helper.setSubject("Welcome to BlogApp - Your Account is Ready!");
            
            Context context = new Context();
            context.setVariable("userName", user.getName());
            context.setVariable("userEmail", user.getEmail());
            context.setVariable("baseUrl", baseUrl);
            
            String htmlContent = templateEngine.process("welcome-email", context);
            helper.setText(htmlContent, true);
            
            mailSender.send(message);
            System.out.println("✅ Welcome email sent to: " + user.getEmail());
            
        } catch (MessagingException e) {
            System.err.println("❌ Failed to send welcome email to: " + user.getEmail());
            e.printStackTrace();
        }
    }

    @Override
    public void sendVerificationEmail(UserDto user, String verificationToken) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            
            helper.setFrom(fromEmail);
            helper.setTo(user.getEmail());
            helper.setSubject("Verify Your Email - BlogApp");
            
            Context context = new Context();
            context.setVariable("userName", user.getName());
            context.setVariable("verificationUrl", baseUrl + "/api/auth/verify?token=" + verificationToken);
            context.setVariable("baseUrl", baseUrl);
            
            String htmlContent = templateEngine.process("verification-email", context);
            helper.setText(htmlContent, true);
            
            mailSender.send(message);
            System.out.println("✅ Verification email sent to: " + user.getEmail());
            
        } catch (MessagingException e) {
            System.err.println("❌ Failed to send verification email to: " + user.getEmail());
            e.printStackTrace();
        }
    }

    @Override
    public void sendPasswordResetEmail(UserDto user, String resetToken) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            
            helper.setFrom(fromEmail);
            helper.setTo(user.getEmail());
            helper.setSubject("Password Reset Request - BlogApp");
            
            Context context = new Context();
            context.setVariable("userName", user.getName());
            context.setVariable("resetUrl", baseUrl + "/api/auth/reset-password?token=" + resetToken);
            context.setVariable("baseUrl", baseUrl);
            
            String htmlContent = templateEngine.process("password-reset-email", context);
            helper.setText(htmlContent, true);
            
            mailSender.send(message);
            System.out.println("✅ Password reset email sent to: " + user.getEmail());
            
        } catch (MessagingException e) {
            System.err.println("❌ Failed to send password reset email to: " + user.getEmail());
            e.printStackTrace();
        }
    }

    @Override
    public void sendCommentNotification(UserDto postAuthor, String commenterName, String postTitle, String commentContent) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            
            helper.setFrom(fromEmail);
            helper.setTo(postAuthor.getEmail());
            helper.setSubject("New Comment on Your Post - BlogApp");
            
            Context context = new Context();
            context.setVariable("authorName", postAuthor.getName());
            context.setVariable("commenterName", commenterName);
            context.setVariable("postTitle", postTitle);
            context.setVariable("commentContent", commentContent);
            context.setVariable("baseUrl", baseUrl);
            
            String htmlContent = templateEngine.process("comment-notification", context);
            helper.setText(htmlContent, true);
            
            mailSender.send(message);
            System.out.println("✅ Comment notification sent to: " + postAuthor.getEmail());
            
        } catch (MessagingException e) {
            System.err.println("❌ Failed to send comment notification to: " + postAuthor.getEmail());
            e.printStackTrace();
        }
    }

    @Override
    public void sendFollowNotification(UserDto user, String followerName) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            
            helper.setFrom(fromEmail);
            helper.setTo(user.getEmail());
            helper.setSubject("New Follower - BlogApp");
            
            Context context = new Context();
            context.setVariable("userName", user.getName());
            context.setVariable("followerName", followerName);
            context.setVariable("baseUrl", baseUrl);
            
            String htmlContent = templateEngine.process("follow-notification", context);
            helper.setText(htmlContent, true);
            
            mailSender.send(message);
            System.out.println("✅ Follow notification sent to: " + user.getEmail());
            
        } catch (MessagingException e) {
            System.err.println("❌ Failed to send follow notification to: " + user.getEmail());
            e.printStackTrace();
        }
    }

    @Override
    public void sendNewPostNotification(UserDto follower, String authorName, String postTitle, String postUrl) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            
            helper.setFrom(fromEmail);
            helper.setTo(follower.getEmail());
            helper.setSubject("New Post from " + authorName + " - BlogApp");
            
            Context context = new Context();
            context.setVariable("followerName", follower.getName());
            context.setVariable("authorName", authorName);
            context.setVariable("postTitle", postTitle);
            context.setVariable("postUrl", postUrl);
            context.setVariable("baseUrl", baseUrl);
            
            String htmlContent = templateEngine.process("new-post-notification", context);
            helper.setText(htmlContent, true);
            
            mailSender.send(message);
            System.out.println("✅ New post notification sent to: " + follower.getEmail());
            
        } catch (MessagingException e) {
            System.err.println("❌ Failed to send new post notification to: " + follower.getEmail());
            e.printStackTrace();
        }
    }
} 