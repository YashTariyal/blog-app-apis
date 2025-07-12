package com.codewithyash.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class BlogAppApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}

@Configuration
class ValidationConfiguration {

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
}

@Configuration
class StreamConfiguration {
    
    @Bean
    public String logStartup() {
        System.out.println("🚀 Spring Cloud Stream Configuration Loaded");
        System.out.println("📡 Consumer function 'userEventReceiver' should be registered");
        return "StreamConfiguration initialized";
    }
}