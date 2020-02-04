package com.nexus.bootstrap;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexus.persistence.entity.User;
import com.nexus.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class DataLoader {


	@Autowired
	private UserService userService;

	@PostConstruct
	private void loadUsers() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/bootstrap.json");
		try {
			List<User> users = mapper.readValue(inputStream, typeReference);
			log.info("Saving users...");
			userService.saveAllUsers(users);
			log.info(users.size() + " Users Saved...");
		} catch (IOException e) {
			log.error("Unable to save users: " + e.getMessage());
		}

	}
}