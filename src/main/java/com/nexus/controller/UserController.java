package com.nexus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexus.persistence.entity.User;
import com.nexus.service.UserService;

@RestController
public class UserController {

	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/highbalance")
	public List<User> getHighBalanceUsers(){
		return userService.getHighBalanceUsers();
	}
}
