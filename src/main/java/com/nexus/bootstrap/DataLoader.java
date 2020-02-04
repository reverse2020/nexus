package com.nexus.bootstrap;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexus.persistence.entity.User;
import com.nexus.persistence.repo.UserRepo;

@Configuration

public class DataLoader {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

	@Autowired
	private UserRepo userRepo;

	@PostConstruct
	private void loadUsers() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/bootstrap.json");
		try {
			List<User> users = mapper.readValue(inputStream, typeReference);
			logger.info("Saving users...");
			userRepo.saveAll(users);
			logger.info("Users Saved...");
		} catch (IOException e) {
			logger.error("Unable to save users: " + e.getMessage());
		}

	}
}