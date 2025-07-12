package com.codewithyash.blog.impl;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Service;

import com.codewithyash.blog.entities.User;
import com.codewithyash.blog.exceptions.ResourceNotFoundException;
import com.codewithyash.blog.payloads.UserDto;
import com.codewithyash.blog.repositories.UserRepo;
import com.codewithyash.blog.services.UserService;
import com.codewithyash.blog.services.EmailService;

@Service
public class UsersServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private StreamBridge streamBridge;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		UserDto dto = this.userToDto(savedUser);
		boolean send = streamBridge.send("userCreatedEvent-out-0", dto);
		// boolean send = streamBridge.send("userCreatedEvent-out-0", savedUser);
		if(send) {
			System.out.println("User Created Event Published Sucessfully");
		}
		
		// Send welcome email
		try {
			emailService.sendWelcomeEmail(dto);
			System.out.println("✅ Welcome email sent to: " + dto.getEmail());
		} catch (Exception e) {
			System.err.println("❌ Failed to send welcome email: " + e.getMessage());
		}
		
		return this.userToDto(savedUser);
	}
	
	@Bean
	public Consumer<UserDto> userEventReceiver() {
	    System.out.println("🔧 Registering userEventReceiver consumer function");
	    return userDto -> {
	        System.out.println("✅ User Event Consumed Successfully!");
	        System.out.println("User ID: " + userDto.getId());
	        System.out.println("User Name: " + userDto.getName());
	        System.out.println("User Email: " + userDto.getEmail());
	        System.out.println("Full User DTO: " + userDto);
	    };
	}

	@ServiceActivator(inputChannel = "userEventReceiver-in-0.errors")
	public void handleKafkaConsumerError(ErrorMessage message) {
	    System.err.println("❌ Kafka Consumer Error:");
	    System.err.println(message.getPayload());
	    System.err.println(message.getOriginalMessage());
	}


	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}
	
	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);
	}
	
	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return userDto;
	}
	

}
