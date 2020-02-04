package com.nexus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nexus.persistence.entity.User;
import com.nexus.persistence.repo.UserRepo;

@Service
public class UserService {

	private UserRepo userRepo;
	
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public void saveAllUsers(List<User> list){
		userRepo.saveAll(list);
	}
}

