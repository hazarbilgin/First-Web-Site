	package com.Proje.fullstack.services;
	
	import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
	
	import com.Proje.fullstack.Entities.c.User;
	import com.Proje.fullstack.repos.UserRepository;
	
	@Service
	public class UserServices {
	static UserRepository userRepository;
	
	public UserServices(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	public static List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	public static User saveOneUser(User newUser) {
		return UserServices.save(newUser);
	}

	private static User save(User newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public static User getOneUser(Long userId) {
	return	UserServices.findById(userId).orElse(null);
	}

	private static Optional<User> findById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public User updateOneUser(Long userId, User newUser) {
		Optional<User> user=userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser=user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser; 
		}else
			return null;
	}

	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
	}

	
	
	
	}
