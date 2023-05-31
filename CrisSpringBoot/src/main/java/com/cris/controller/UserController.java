package com.cris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cris.repository.UserRepository;
import com.cris.service.UserService;
import com.cris.to.User;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/home")
	public String loginPage() {

		System.out.println("isnxide loginPageController");

		return "home";
	}

	@RequestMapping("/registrationPage")
	public String registrationPage() {

		System.out.println("REgsitrationPage...");

		return "registration";
	}

//	@RequestMapping("/register")
//	public String register(String username, String password, String name, String email) {
//		
//		System.out.println("isndie Register()..."+username+", "+password+", "+name+", "+email);
//		
//		return "home";
//	}

	@RequestMapping("/register")
	public String register(User user) {

		System.out.println("isndie Register()..." + user.getUsername() + ", " + user.getPassword() + ", "
				+ user.getName() + ", " + user.getEmail());

		userService.register(user);

		return "home";
	}

	@RequestMapping("/login")
	public ModelAndView login(String username, String password) {
		
		ModelAndView modelAndView = null;

		System.out.println("isndie login controller() " + username + ", " + password);

		User user = userService.validate(username, password);

		if (user != null) {

			modelAndView =  new ModelAndView("welcome");
			
			modelAndView.addObject("userData", user);
			
		} else {

			modelAndView = new ModelAndView("home");
			modelAndView.addObject("errorMessage", "Wrong Credentails, please try again...");
		}
		
		return modelAndView;
	}
}
