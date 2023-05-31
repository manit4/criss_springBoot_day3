package com.cris.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cris.service.UserService;
import com.cris.to.User;
import com.cris.to.UserDataRequest;

@RestController
public class FirstController {
	
	@Autowired
	UserService userService;
	
	

	@RequestMapping("/message")
	public String getMessage() {

		return "Hello class, I am updating greetings again...";
	}

	@RequestMapping("/getUser")
	public User getUser() {

		User user = new User("ran@123", "1234", "Randhir", "ran@gmail.com");
		user.setPassword(null);

		return user;
	}

	@RequestMapping("/getUsers")
	public List<User> getUsers() {

		User user1 = new User("ran@123", "1234", "Randhir", "ran@gmail.com");
		User user2 = new User("van@123", "2345", "Vansh", "va@gmail.com");
		User user3 = new User("san@345", "3456", "Sanjeet", "san@gmail.com");

		List<User> users = new ArrayList<>();

		users.add(user1);
		users.add(user2);
		users.add(user3);

		return users;

	}
	
	@RequestMapping("/fetchUserId/{userId}/{name}")
	public String getUserId(@PathVariable String name, @PathVariable String userId) {
		
		System.out.println("userid is "+userId+name);
		
		return "UserId fetched Successfully"+userId;	
	}
	
	@RequestMapping("/addUser")
	public String addUser(@RequestBody User user) {
		
		System.out.println(user.getUsername()+", "+user.getPassword()+", "+user.getName()+", "+user.getEmail());
		
//		UserService service = new UserService();
		
		return userService.register(user);
	}
	
	@RequestMapping("/addUserData")
	public String addUserData(@RequestBody UserDataRequest dataRequest) {
		
		System.out.println(dataRequest.getUser().getUsername()+", "+dataRequest.getAddress().getState());
		
		return "User added successfully";
	}

}
