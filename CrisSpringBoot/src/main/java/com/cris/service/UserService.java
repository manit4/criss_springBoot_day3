package com.cris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cris.repository.UserRepository;
import com.cris.to.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public String register(User user) {
		
		//UserRepository userRepository = new UserRepository();
		
		System.out.println("inside Service of user...");
		
		return userRepository.addUser(user);
	}
	
	public User validate(String username, String password) {
		
		User user = userRepository.findUser(username, password);
		
		return user;
	}

}
