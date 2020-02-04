package com.nexus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<User> getAllUsers(@RequestParam(required = false) Boolean active,
			@RequestParam(required = false) String eyeColor, @RequestParam(required = false) Double balance,
			@RequestParam(required = false) Integer age, @RequestParam(required = false) String gender,
			@RequestParam(required = false) Integer zipCode) {
		if (balance == null)
			balance = Double.valueOf(0);
		if (age == null)
			age = Integer.valueOf(0);
		if (zipCode == null)
			zipCode = Integer.valueOf(0);
		return userService.getAllUsers(active, eyeColor, balance, age.intValue(), zipCode.intValue(), gender);
	}

	@GetMapping("/users/highbalance")
	public List<User> getHighBalanceUsers() {
		return userService.getHighBalanceUsers();
	}

	@GetMapping("/users/active")
	public List<User> getActiveUsers() {
		return userService.getActiveUsers();
	}

	@GetMapping("/users/inactive")
	public List<User> getInActiveUsers() {
		return userService.getInActiveUsers();
	}

	@GetMapping("/users/females")
	public List<User> getFemaleUsers() {
		return userService.getFemaleUsers();
	}
}
