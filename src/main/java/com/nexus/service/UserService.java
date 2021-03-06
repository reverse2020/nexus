package com.nexus.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<User> getHighBalanceUsers() {
		
		return userRepo
				.findAll()
				.stream()
				.parallel()
				.filter(user -> user.getBalance() >4000)
				.sorted(Comparator.comparingDouble(User::getBalance))
				.collect(Collectors.toList());
	
	}

	public List<User> getActiveUsers() {
		return userRepo
				.findAll()
				.stream()
				.parallel()
				.filter(user -> user.getIsActive())
				.collect(Collectors.toList());
	}
	
	public List<User> getInActiveUsers() {
		return userRepo
				.findAll()
				.stream()
				.parallel()
				.filter(user -> !user.getIsActive())
				.collect(Collectors.toList());
	}

	public List<User> getFemaleUsers() {
		return userRepo
				.findAll()
				.stream()
				.parallel()
				.filter(user -> user.getGender().equalsIgnoreCase("female"))
				.collect(Collectors.toList());
	}

	public List<User> getAllUsers(Boolean active, String eyeColor, Double balance, int age, int zipCode, String gender) {
		return userRepo
				.findAll()
				.stream()
				.filter(user -> active==null ||user.getIsActive()==active.booleanValue())
				.filter(user -> eyeColor == null ||user.getEyeColor().equalsIgnoreCase(eyeColor))
				.filter(user -> user.getBalance() >= balance.doubleValue())
				.filter(user -> age ==0 || user.getAge() == age)
				.filter(user -> zipCode ==0 || user.getAddress().getZip() == zipCode)
				.collect(Collectors.toList());
	}
}
